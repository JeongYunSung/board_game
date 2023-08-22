package com.yunseong.model.game

import com.yunseong.model.board.Board

data class Game(
    val board: Board,
    val players: Participants
)
