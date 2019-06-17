package com.kc5m.twitag.controllers

import com.kc5m.twitag.dto.req.GetTwitsReq
import com.kc5m.twitag.dto.res._
import com.kc5m.twitag.usecases.GetTwitsUseCase
import play.api.libs.json.{Json, Writes}
import play.api.mvc._

class TwitController(
    controllerComponents: ControllerComponents
)(
    implicit
    ec: ControllerContext,
    twitsWrites: Writes[TwitsRes],
    uc: GetTwitsUseCase
) extends AbstractController(controllerComponents) {
  def list(): Action[AnyContent] = Action.async {
    implicit request: Request[AnyContent] =>
      uc.exec(GetTwitsReq(Option.empty, Option.empty, Option.empty))
        .map { twiTags =>
          Ok(Json.toJson(twiTags))
        }
  }
}
