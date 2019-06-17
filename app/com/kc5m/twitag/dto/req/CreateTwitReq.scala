package com.kc5m.twitag.dto.req

case class CreateTwitReq(msg: String, tags: Seq[String] = Nil)
