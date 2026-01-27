package dev.tito.core

const val SIDE_MIN = 6
const val SIDE_MAX = 16

data class Board(
    val side: Int = 8,
    val pieces: List<Piece> = emptyList()
) {
    init {
        require(side in SIDE_MIN..SIDE_MAX) {
            "Board Side = $side Invalid. Must be between $SIDE_MIN - $SIDE_MAX."
        }
        require(side % 2 == 0) {
            "Board Side = $side Invalid. Must be even."
        }
    }

//    fun start(): Board {
//        return copy(
//            side = side,
//            pieces = this.addPiece()
//        )
//    }

    fun print() {
        pieces.forEach {
            println(it)
        }
    }

    fun printPiece(idx: Int) {
        println(pieces[idx])
    }

    fun addPiece(coordinate: Coordinate, type: Type): Board {
        return this.copy(
            pieces = pieces + Piece(coordinate, type)
        )
    }

    fun removePiece(piece: Piece): Board {
        return this.copy(
            pieces = pieces - piece
        )
    }
}