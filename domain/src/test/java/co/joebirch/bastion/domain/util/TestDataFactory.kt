package co.joebirch.bastion.domain.util

import co.joebirch.bastion.domain.model.FullTournament
import co.joebirch.bastion.domain.model.Game
import co.joebirch.bastion.domain.model.Match
import co.joebirch.bastion.domain.model.Tournament
import java.util.*

class TestDataFactory {

    companion object Factory {

        private val sRandom = Random()

        fun randomUuid(): String {
            return UUID.randomUUID().toString()
        }

        private fun randomInt(): Int {
            return sRandom.nextInt(200) + Integer.SIZE - 1
        }


        fun makeTournament(): Tournament {
            return Tournament(randomUuid(), randomUuid(), randomUuid(), Date().toString(),
                    Date().toString(), randomInt())
        }

        fun makeFullTournament(): FullTournament {
            return FullTournament(randomUuid(), randomUuid(), randomUuid(), Date().toString(),
                    Date().toString(), randomInt(), randomUuid(), randomUuid(), randomUuid(),
                    randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid(),
                    randomUuid())
        }

        fun makeMatch(): Match {
            return Match(randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid(),
                    randomInt(), randomUuid(), randomUuid())
        }

        fun makeGame(): Game {
            return Game(randomInt(), randomUuid())
        }

        fun makeGameList(count: Int): List<Game> {
            val games: MutableList<Game> = mutableListOf<Game>()
            repeat(count) {
                games.add(makeGame())
            }
            return games
        }

    }
}