name := "heroes-freedom"

version := "0.1"

scalaVersion := "2.11.12"

scalacOptions ++= Seq("-Ypartial-unification")

val CatsVersion       = "1.0.1"
val ScalaTestVersion  = "3.0.4"

libraryDependencies ++= Seq(
  "org.typelevel"         %% "cats-core"            % CatsVersion,
  "org.scalatest"         %% "scalatest"            % ScalaTestVersion  % Test
)