package com.yunseong.model.history

import com.yunseong.model.board.Move
import com.yunseong.model.player.Player

data class History(
    val actor: Player,
    val move: Move
)
