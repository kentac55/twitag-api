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
