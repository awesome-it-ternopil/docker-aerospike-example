name := "aerospike-docker-example"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.whisk"                  %% "docker-testkit-scalatest"    % "0.9.0" % "test",
  "com.whisk"                  %% "docker-testkit-impl-spotify" % "0.9.0" % "test",
  "com.aerospike"              % "aerospike-client"             % "3.3.1",
  "ch.qos.logback"             % "logback-classic"              % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging"               % "3.5.0",
  "org.scalactic"              %% "scalactic"                   % "3.0.1",
  "org.scalatest"              %% "scalatest"                   % "3.0.1" % "test"
)
