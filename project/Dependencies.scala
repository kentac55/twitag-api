import sbt._

object Dependencies {
  lazy val logstashEncoder   = "net.logstash.logback"     % "logstash-logback-encoder" % "5.3"
  lazy val macwireMacroSakka = "com.softwaremill.macwire" %% "macrosakka"              % "2.3.2" % "provided"
  lazy val macwireMacros     = "com.softwaremill.macwire" %% "macros"                  % "2.3.2" % "provided"
  lazy val macwireProxy      = "com.softwaremill.macwire" %% "proxy"                   % "2.3.2"
  lazy val macwireUtil       = "com.softwaremill.macwire" %% "util"                    % "2.3.2"
  lazy val scalaTest         = "org.scalatestplus.play"   %% "scalatestplus-play"      % "4.0.2" % Test
  lazy val swaggerUI         = "org.webjars"              % "swagger-ui"               % "3.22.1"
}
