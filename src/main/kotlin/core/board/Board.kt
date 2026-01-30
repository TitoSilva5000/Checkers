package dev.tito.core.board

import kotlin.collections.plusAssign

const val SIDE_MIN = 6
const val SIDE_MAX = 26

data class Board(
    val side: Int = 8,
    private val pieces: List<Piece> = emptyList()
) {

    init {
        require(side in SIDE_MIN..SIDE_MAX) {
            "Board Side = $side Invalid. Must be between $SIDE_MIN - $SIDE_MAX."
        }
        require(side % 2 == 0) {
            "Board Side = $side Invalid. Must be even."
        }
    }

    private val size: Int = side * side

    private fun Int.toCoordinate(): Coordinate {
        require(this in 0 until size) {
            "Index $this out of bounds."
        }
        val x = this / side
        val y = this % side
        return Coordinate(x = x, y = y)
    }

    operator fun get(coordinate: Coordinate): Piece? {
        require(coordinate.x in 0 until side) {
            "X = ${coordinate.x} Invalid. Must be between 0 - $side."
        }
        require(coordinate.y in 0 until side) {
            "Y = ${coordinate.y} Invalid. Must be between 0 - $side."
        }
        return pieces.find { it.coordinate == coordinate }
    }

    operator fun get(idx: Int): Piece? {
        require(idx in 0 until size) {
            "Index $idx out of bounds."
        }
        return get(idx.toCoordinate())
    }

    fun start(): Board {
        val pieceRows = (side / 2) - 1
        val tmp = mutableListOf<Piece>()
        for (i in 0 until size) {
            val curr = i.toCoordinate()
            if ((curr.x + curr.y) % 2 != 0) continue
            val type = when {
                curr.x < pieceRows         -> Type.BLACK
                curr.x >= side - pieceRows -> Type.WHITE
                else                       -> Type.EMPTY
            }
            tmp += Piece(coordinate = curr, type = type)
        }
        return copy(side = side, pieces = tmp)
    }

    fun print() {
        if (pieces.isEmpty()) {
            println(pieces)
        } else {
            pieces.forEach {
                println(it)
            }
        }
    }

    fun removePiece(coordinate: Coordinate): Board {
        pieces.forEach { piece -> if (piece.coordinate == coordinate) piece.remove() }
        return this.copy(
            pieces = pieces
        )
    }

    fun removePiece(idx: Int): Board {
        return removePiece(coordinate = idx.toCoordinate())
    }

}