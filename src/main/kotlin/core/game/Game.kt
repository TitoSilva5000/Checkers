package dev.tito.core.game

import dev.tito.core.board.Board

data class Game(
    private val name: String = "Game",
    private val players: List<Player> = emptyList(),
    private val board: Board = Board()
) {
    private var turn: Boolean = true

    fun printName() {
        println(name)
    }

    fun printPlayers() {
        println(players)
    }

    fun printBoard() {
        board.print()
    }

    fun print() {
        println(name)
        println(players)
        board.print()
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
