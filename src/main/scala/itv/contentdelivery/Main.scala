package itv.contentdelivery

import java.io.Closeable

import fs2._
import cats.effect.IO
import cats.syntax.apply._
import scala.util.{Failure, Success, Try}

object Main extends App {



  val ClientStream: Stream[IO, Client] = Stream.bracket(IO(new Client()))(
    use = client => Stream.eval[IO, Client]{
      Try{
        client.connect()
        client
      } match {
        case Success(c) => IO(c)
        case Failure(error) => IO.raiseError(error)
      }
    },
    release = client => IO(if (client.isConnected) client.close()) *> IO.unit
  )


}

class Client() extends Closeable {
  def connect(): Unit = IO(println("connected"))
  def isConnected: Boolean = true
  override def close(): Unit = IO(println("Closed"))
}
