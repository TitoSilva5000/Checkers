package dev.tito.core

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

    private fun toCoordinate(idx: Int): Coordinate {
        require(idx in 0 until size) {
            "Index $idx out of bounds."
        }
        val x = idx / side
        val y = idx % side
        return Coordinate(x = x, y = y)
    }

//    operator fun get(coordinate: Coordinate): Piece {
//        require(coordinate.x in 0 until side) {
//            "X = ${coordinate.x} Invalid. Must be between 0 and $side."
//        }
//        require(coordinate.y in 0 until side) {
//            "Y = ${coordinate.y} Invalid. Must be between 0 and $side."
//        }
//        for (i in 0 until size) {
//            if (pieces[i].coordinate == coordinate) return pieces[i]
//        }
//        return
//    }

    operator fun get(idx: Int): Piece {
        require(idx in 0 until size) {
            "Index $idx out of bounds."
        }
        //return get(toCoordinate(idx))
        return pieces[idx]
    }

    fun start(): Board {
        val tmp = mutableListOf<Piece>()
        for (i in 0 until size) {
            val curr = toCoordinate(i)
            if (curr.x < (side / 2)) {
                if (curr.x + curr.y % 2 == 0) {
                    tmp += Piece(coordinate = curr, type = Type.BLACK)
                }
            } else if (curr.x > (side / 2)) {
                if (curr.x + curr.y % 2 == 0) {
                    tmp += Piece(coordinate = curr, type = Type.WHITE)
                }
            }
        }
        return copy(side = side, pieces = tmp)
    }

    fun print() {
        pieces.forEach {
            println(it)
        }
    }

    fun removePiece(piece: Piece): Board {
        return removePiece(piece.coordinate)
    }

    fun removePiece(coordinate: Coordinate): Board {
        pieces.forEach { piece -> if (piece.coordinate == coordinate) piece.remove() }
        return this.copy(
            pieces = pieces
        )
    }
}