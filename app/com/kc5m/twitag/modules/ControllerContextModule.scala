package com.kc5m.twitag.modules

import akka.actor.ActorSystem
import com.kc5m.twitag.controllers.{ControllerContext, ControllerContextImpl}
import com.softwaremill.macwire.wire

trait ControllerContextModule {
  implicit lazy val ec: ControllerContext = wire[ControllerContextImpl]

  def system: ActorSystem
}
