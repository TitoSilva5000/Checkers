package dev.tito.core.board

import dev.tito.core.board.Type

data class Piece(
    val coordinate: Coordinate,
    val type: Type
) {

    fun remove(): Piece {
        return this.copy(
            coordinate = coordinate,
            type = Type.EMPTY
        )
    }
}