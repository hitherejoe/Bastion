package co.joebirch.bastion.domain.model


class FullTournament(id: String, name: String, status: String, dateStart: String, dateEnd: String,
                     size: Int, val timezone: String, val location: String, val country: String,
                     val participantType: String, val matchType: String, val organization: String,
                     val website: String, val rules: String, val prize: String) :
        Tournament(id, name, status, dateStart, dateEnd, size)