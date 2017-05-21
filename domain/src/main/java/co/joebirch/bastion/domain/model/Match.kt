package co.joebirch.bastion.domain.model

class Match(val id: String, val type: String, val discipline: String,
            val status: String, val tournamentId: String,
            val number: Int, val date: String, val timezone: String)