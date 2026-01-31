package dev.tito.cli.states

import dev.tito.cli.CLI

class CreditsState : State {
    override fun execute(cli: CLI): State? {
        println(
            "-------------- CHECKERS --------------\n" +
            "        CREATED BY: TITO SILVA        \n" +
            "1 - MAIN MENU\n" +
            "2 - EXIT\n" +
            "--------------------------------------"
        )
        print("> ")
        val input = readln()
        return when (input) {
            "1" -> MenuState()
            "2" -> null
            else -> {
                println("Invalid input.")
                this
            }
        }
    }
}