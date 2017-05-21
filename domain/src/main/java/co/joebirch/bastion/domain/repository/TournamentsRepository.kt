package co.joebirch.bastion.domain.repository

import co.joebirch.bastion.domain.model.*
import io.reactivex.Single

interface TournamentsRepository {

    /**
     * Get an [Single] which will emit a [List] of [Tournament] instances.
     */
    fun getTournaments(): Single<List<Tournament>>

    /**
     * Get an [Single] which will emit a [FullTournament] instances.
     */
    fun getTournament(): Single<FullTournament>

    /**
     * Get an [Single] which will emit a [List] of [Match] instances.
     */
    fun getMatches(): Single<List<Match>>

    /**
     * Get an [Single] which will emit a [List] of [Game] instances.
     */
    fun getGames(tournamentId: String?, matchId: String?): Single<List<Game>>

    /**
     * Get an [Single] which will emit a [List] of [Participant] instances.
     */
    fun getParticipants(): Single<List<Participant>>

    /**
     * Get an [Single] which will emit a [List] of [Stage] instances.
     */
    fun getStages(): Single<List<Stage>>

}