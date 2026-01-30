package dev.tito.cli

class CLI {

    fun start() {
        while(true) {
            when (val input = readln().lowercase()) {
                "help" -> help()
                else -> println("Unknown input: $input. Try 'help' for list of available commands.")
            }

        }
    }

    fun help() {
        // TODO
        println("help meee")
    }

}