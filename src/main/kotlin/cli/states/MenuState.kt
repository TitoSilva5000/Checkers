package dev.tito.cli.states

import dev.tito.cli.CLI

class MenuState : State {
    override fun execute(cli: CLI): State? {
        println(
            "-------------- CHECKERS --------------\n" +
            "1 - PLAY\n" +
            "2 - CREDITS\n" +
            "3 - EXIT\n" +
            "--------------------------------------"
        )
        print("> ")
        val input = readln()
        return when (input) {
            "1" -> PlayState()
            "2" -> CreditsState()
            "3" -> null
            else -> {
                println("Invalid input.")
                this
            }
        }
    }
}