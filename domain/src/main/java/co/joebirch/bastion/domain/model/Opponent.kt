package co.joebirch.bastion.domain.model

class Opponent(val number: Int, val participant: Participant, val result: Int,
               val score: String, val forfeit: Boolean)