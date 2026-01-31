package dev.tito.cli

import dev.tito.cli.states.MenuState
import dev.tito.cli.states.State

class CLI {

    fun start() {
        var currentState: State? = MenuState()

        while (currentState != null) { currentState = currentState.execute(cli = this) }

        println("Goodbye!")
    }

}