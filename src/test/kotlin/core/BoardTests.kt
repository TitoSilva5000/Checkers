package core

import dev.tito.core.Board
import dev.tito.core.Coordinate
import dev.tito.core.Piece
import dev.tito.core.SIDE_MAX
import dev.tito.core.SIDE_MIN
import dev.tito.core.Type
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertFailsWith

// If (more like When) there are alot of tests, separate into different files

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
        fun `Board with odd side fails`() {
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

    }

}
