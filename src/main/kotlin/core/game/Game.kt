package dev.tito.core.game

import dev.tito.core.board.Board

data class Game(
    private val name: String = "Game",
    private val players: List<Player> = emptyList(),
    private val board: Board = Board()
) {
    private var targets: Boolean = false
    private var turn: Boolean = true

    fun print() {
        println(name)
        println(players)
        board.print()
    }

    fun toggleTargets() {
        // TODO("Implement Target Logic")
        targets = !targets
    }

    fun addPlayer(player: Player): Game {
        require(players.size <= 2) { "Game is full." }
        return copy(players = players + player)
    }

    fun removePlayer(player: Player): Game {
        require(players.size >= 0) { "Game is empty." }
        return copy(players = players - player)
    }

    fun start(): Game {
        return copy(board = board.start())
    }

//    fun play(): Player {
//
//    }

}
