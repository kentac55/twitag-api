import Dependencies._

name := """twitag-api"""
organization := "com.kc5m"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(
  AshScriptPlugin,
  DockerPlugin,
  JavaAppPackaging,
  PlayScala,
  ScalafmtPlugin,
  ScalastylePlugin,
  SwaggerPlugin
)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  logstashEncoder,
  macwireMacroSakka,
  macwireMacros,
  macwireProxy,
  macwireUtil,
  scalaTest,
  swaggerUI
)

val unusedWarnings = "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  Nil

scalacOptions ++= (
  "-deprecation" ::
    "-unchecked" ::
    "-Xlint" ::
    "-Xfuture" ::
    "-language:existentials" ::
    "-language:higherKinds" ::
    "-language:implicitConversions" ::
    "-Yno-adapted-args" ::
    Nil
) ::: unusedWarnings

Seq(Compile, Test).flatMap(
  c => scalacOptions in (c, console) --= unusedWarnings
)

val port = 9000

dockerBaseImage := "azul/zulu-openjdk-alpine:11-jre"
dockerExposedPorts := Seq(port)
daemonUserUid in Docker := None
daemonUser in Docker := "daemon"
javaOptions in Universal ++= Seq(
  "-J-Xmx1024m",
  "-J-Xms512m",
  "-Dpidfile.path=/dev/null",
  "-Dconfig.file=/opt/docker/conf/application.conf",
  "-Dlogger.file=/opt/docker/conf/logback-prod.xml",
  "-DapplyEvolutions.default=true",
  "-XX:+UnlockExperimentalVMOptions",
  "-XX:+UseContainerSupport"
)

swaggerDomainNameSpaces := Seq("com.kc5m.twitag.dto.res")
swaggerV3 := true
