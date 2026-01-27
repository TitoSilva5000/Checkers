package dev.tito.core

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val pieces = listOf(Piece(Coordinate(0,0), Type.BLACK), Piece(Coordinate(1,0), Type.WHITE))
    val board = Board(side = 2, pieces = pieces)

    board.printPiece(1)
    println()
    board.print()
}