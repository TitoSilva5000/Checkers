package dev.tito.core

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