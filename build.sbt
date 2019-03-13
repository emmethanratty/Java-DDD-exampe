name := "DDD"
organization := "com.dekopay"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "com.google.guava" % "guava" % "27.0-jre"


libraryDependencies += "org.hamcrest" % "hamcrest-all" % "1.3" % Test
libraryDependencies += "info.cukes" % "cucumber-java" % "1.2.5"
libraryDependencies += "info.cukes" % "cucumber-junit" % "1.2.5" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.4.0" % Test
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.8"

publishTo := Some(Resolver.file("file",  new File( "target/universal" )))

javaOptions += "--add-opens=java.base/java.lang=ALL-UNNAMED"