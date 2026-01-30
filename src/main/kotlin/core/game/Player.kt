package dev.tito.core.game

data class Player(
    val name: String,
) {

    private var winningStreak: Int = 0

    fun increaseWinningStreak() {
        winningStreak++
    }

}
