package com.kc5m.twitag

import _root_.controllers.AssetsComponents
import akka.actor.ActorSystem
import com.kc5m.twitag.modules.{
  ControllerContextModule,
  ControllerModule,
  RepositoryModule,
  UseCaseModule
}
import com.kc5m.twitag.viewmodels.TwitEncoder
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import router.Routes

class AppComponents(context: Context)
    extends BuiltInComponentsFromContext(context)
    with HttpFiltersComponents
    with AssetsComponents
    with ControllerModule
    with TwitEncoder
    with ControllerContextModule
    with RepositoryModule
    with UseCaseModule {
  lazy val router: Router      = wire[Routes]
  lazy val prefix: String      = "/"
  lazy val system: ActorSystem = ActorSystem("db-dispatcher")
}
