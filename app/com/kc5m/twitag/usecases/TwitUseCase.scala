package com.kc5m.twitag.usecases

import com.kc5m.twitag.domains.entities.Twit
import com.kc5m.twitag.dto.res.TwitRes

trait TwitUseCase {
  protected def entityToResponse(entity: Twit): TwitRes = {
    TwitRes(
      id = entity.id,
      msg = entity.msg.msg,
      tags = entity.tags.map(x => x.tag),
      createdAt = entity.createdAt
    )
  }
}
