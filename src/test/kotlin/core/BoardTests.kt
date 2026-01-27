package core

import dev.tito.core.Board
import kotlin.test.Test
import kotlin.test.assertFailsWith

class BoardTests {

    @Test
    fun `Board with odd side fails`() {
        assertFailsWith<IllegalArgumentException> {
            Board(side = 5)
        }
    }
}