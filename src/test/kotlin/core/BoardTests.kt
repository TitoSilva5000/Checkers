package core

import dev.tito.core.board.Board
import dev.tito.core.board.Coordinate
import dev.tito.core.board.Piece
import dev.tito.core.board.SIDE_MAX
import dev.tito.core.board.SIDE_MIN
import dev.tito.core.board.Type
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BoardTests {

    @Nested
    inner class InitializationTests {

        @Test
        fun `Board with side out of range fails`() {
            val sides = listOf(SIDE_MIN - 2, SIDE_MAX + 1)

            sides.forEach { side ->
                assertFailsWith<IllegalArgumentException> {
                    Board(side = side)
                }
            }

        }

        @Test
        fun `Board with odd side in range fails`() {
            val sides = listOf(SIDE_MIN + 1, SIDE_MAX - 1)

            sides.forEach { side ->
                assertFailsWith<IllegalArgumentException> {
                    Board(side = side)
                }
            }
        }

    }

    @Nested
    inner class IndexingTests {

        val board = Board(side = 6).start()

        @Test
        fun `Board indexing with invalid index fails`() {
            val indices = listOf(-1, 36)

            indices.forEach { index ->
                assertFailsWith<IllegalArgumentException> {
                    board[index]
                }
            }
        }

        @Test
        fun `Board indexing with invalid coordinates fails`() {
            val coordinates = listOf(Coordinate(x = -1, y = 0), Coordinate(x = 0, y = 36))

            coordinates.forEach { coordinate ->
                assertFailsWith<IllegalArgumentException> {
                    board[coordinate]
                }
            }
        }

    }

    @Nested
    inner class StartTests {

        @Test
        fun `Board start succeeds`() {
            val board = Board(side = 6).start()
            val expectedBoard = Board(
                side = 6, pieces = listOf(
                    Piece(coordinate = Coordinate(x = 0, y = 0), type = Type.BLACK),
                    Piece(coordinate = Coordinate(x = 0, y = 2), type = Type.BLACK),
                    Piece(coordinate = Coordinate(x = 0, y = 4), type = Type.BLACK),
                    Piece(coordinate = Coordinate(x = 1, y = 1), type = Type.BLACK),
                    Piece(coordinate = Coordinate(x = 1, y = 3), type = Type.BLACK),
                    Piece(coordinate = Coordinate(x = 1, y = 5), type = Type.BLACK),
                    Piece(coordinate = Coordinate(x = 2, y = 0), type = Type.EMPTY),
                    Piece(coordinate = Coordinate(x = 2, y = 2), type = Type.EMPTY),
                    Piece(coordinate = Coordinate(x = 2, y = 4), type = Type.EMPTY),
                    Piece(coordinate = Coordinate(x = 3, y = 1), type = Type.EMPTY),
                    Piece(coordinate = Coordinate(x = 3, y = 3), type = Type.EMPTY),
                    Piece(coordinate = Coordinate(x = 3, y = 5), type = Type.EMPTY),
                    Piece(coordinate = Coordinate(x = 4, y = 0), type = Type.WHITE),
                    Piece(coordinate = Coordinate(x = 4, y = 2), type = Type.WHITE),
                    Piece(coordinate = Coordinate(x = 4, y = 4), type = Type.WHITE),
                    Piece(coordinate = Coordinate(x = 5, y = 1), type = Type.WHITE),
                    Piece(coordinate = Coordinate(x = 5, y = 3), type = Type.WHITE),
                    Piece(coordinate = Coordinate(x = 5, y = 5), type = Type.WHITE)
                )
            )

            assertEquals(expected = expectedBoard, actual = board)
        }

    }

    @Nested
    inner class RemovePieceTests {

        val board = Board(side = 6).start()

        // Is this a good test??
//        @Test
//        fun `Board_removePiece() does nothing if there is no piece removed`() {
//
//        }

        @Test
        fun `Board_removePiece() with coordinate succeeds`() {
            val newBoard = board.removePiece(coordinate = Coordinate(x = 0, y = 0))
            val expectedBoard = Board(side = 6, pieces = listOf(
                Piece(coordinate = Coordinate(x = 0, y = 0), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 0, y = 2), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 0, y = 4), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 1, y = 1), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 1, y = 3), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 1, y = 5), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 2, y = 0), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 2, y = 2), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 2, y = 4), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 3, y = 1), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 3, y = 3), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 3, y = 5), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 4, y = 0), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 4, y = 2), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 4, y = 4), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 5, y = 1), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 5, y = 3), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 5, y = 5), type = Type.WHITE)
            ))

            assertEquals(expected = expectedBoard, actual = newBoard)
        }

        @Test
        fun `Board_removePiece() with index succeeds`() {
            val newBoard = board.removePiece(idx = 0)
            val expectedBoard = Board(side = 6, pieces = listOf(
                Piece(coordinate = Coordinate(x = 0, y = 0), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 0, y = 2), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 0, y = 4), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 1, y = 1), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 1, y = 3), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 1, y = 5), type = Type.BLACK),
                Piece(coordinate = Coordinate(x = 2, y = 0), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 2, y = 2), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 2, y = 4), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 3, y = 1), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 3, y = 3), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 3, y = 5), type = Type.EMPTY),
                Piece(coordinate = Coordinate(x = 4, y = 0), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 4, y = 2), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 4, y = 4), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 5, y = 1), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 5, y = 3), type = Type.WHITE),
                Piece(coordinate = Coordinate(x = 5, y = 5), type = Type.WHITE)
            ))

            assertEquals(expected = expectedBoard, actual = newBoard)
        }

    }

}
