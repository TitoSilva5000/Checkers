package dev.tito.cli

import dev.tito.cli.commands.*

class CLI {

    fun start() {
        while(true) {
            println(
                "---------- CHECKERS ----------\n" +
                "> 1 - PLAY\n" +
                "> 2 - CREDITS\n" +
                "> 3 - EXIT\n" +
                "------------------------------"
            )
            print("> ")
            when (readln()) {
                "1" -> play()
                "2" -> break
                "3" -> break
                else -> println("Unknown input")
            }

        }
        println("Thanks for playing!")
    }

    fun play() {
        while(true) {
            println("Insert game name:")
            print("> ")
            val gameName = readln()
            println("Enter your name:")
            print("> ")
            val playerName = readln()

        }
    }

}