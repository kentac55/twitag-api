package com.kc5m.twitag.usecases

import com.kc5m.twitag.dto.req.GetTwitReq
import com.kc5m.twitag.dto.res.TwitRes

import scala.concurrent.Future

trait GetTwitUseCase extends TwitUseCase {
  def exec(ro: GetTwitReq): Future[TwitRes]
}
