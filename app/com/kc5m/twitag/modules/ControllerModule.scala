package com.kc5m.twitag.modules

import com.kc5m.twitag.controllers.{ControllerContext, TwitController}
import com.kc5m.twitag.dto.res.{TwitRes, TwitsRes}
import com.kc5m.twitag.repositories.TwitRepo
import com.kc5m.twitag.usecases.GetTwitsUseCase
import com.softwaremill.macwire.wire
import play.api.libs.json.Writes
import play.api.mvc.ControllerComponents

trait ControllerModule {

  lazy val twiTagController: TwitController = wire[TwitController]
  implicit def repo: TwitRepo
  implicit def twitWrites: Writes[TwitRes]
  implicit def twitsWrites: Writes[TwitsRes]
  implicit def ec: ControllerContext
  implicit def uc: GetTwitsUseCase

  def controllerComponents: ControllerComponents
}
