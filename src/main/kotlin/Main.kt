package dev.tito

import dev.tito.core.board.Board
import dev.tito.core.game.Game

fun main() {
    val board = Board(side = 6).start()
    board.print()
}