package com.kc5m.twitag.controllers

import akka.actor.ActorSystem
import play.api.libs.concurrent.CustomExecutionContext

class ControllerContextImpl(system: ActorSystem)
    extends CustomExecutionContext(system, "db.dispatcher")
    with ControllerContext
