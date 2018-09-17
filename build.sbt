name := "streaming"

version := "0.1"

scalaVersion := "2.12.6"

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  "co.fs2" %% "fs2-core" % "0.10.4",
  "org.typelevel" %% "cats-core" % "1.3.1",
  "org.typelevel" %% "cats-effect" % "1.0.0"
)
