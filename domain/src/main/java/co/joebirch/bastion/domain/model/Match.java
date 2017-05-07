package co.joebirch.bastion.domain.model;

import java.util.Arrays;

public class Match {

    public String id;
    public String type;
    public String discipline;
    public String status;
    public String pending;
    public String tournamentId;
    public int number;
    public int stageNumber;
    public int groupNumber;
    public int roundNumber;
    public String date;
    public String timezone;
    public String matchFormat;
    public Opponent[] opponents;

    public Match() {

    }

    private Match(String id, String type, String discipline, String status, String pending,
                  String tournamentId, int number, int stageNumber, int groupNumber,
                  int roundNumber, String date, String timezone, String matchFormat,
                  Opponent[] opponents) {
        this.id = id;
        this.type = type;
        this.discipline = discipline;
        this.status = status;
        this.pending = pending;
        this.tournamentId = tournamentId;
        this.number = number;
        this.stageNumber = stageNumber;
        this.groupNumber = groupNumber;
        this.roundNumber = roundNumber;
        this.date = date;
        this.timezone = timezone;
        this.matchFormat = matchFormat;
        this.opponents = opponents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (number != match.number) return false;
        if (stageNumber != match.stageNumber) return false;
        if (groupNumber != match.groupNumber) return false;
        if (roundNumber != match.roundNumber) return false;
        if (id != null ? !id.equals(match.id) : match.id != null) return false;
        if (type != null ? !type.equals(match.type) : match.type != null) return false;
        if (discipline != null ? !discipline.equals(match.discipline) : match.discipline != null)
            return false;
        if (status != null ? !status.equals(match.status) : match.status != null) return false;
        if (pending != null ? !pending.equals(match.pending) : match.pending != null) return false;
        if (tournamentId != null ? !tournamentId.equals(match.tournamentId) : match.tournamentId != null)
            return false;
        if (date != null ? !date.equals(match.date) : match.date != null) return false;
        if (timezone != null ? !timezone.equals(match.timezone) : match.timezone != null)
            return false;
        if (matchFormat != null ? !matchFormat.equals(match.matchFormat) : match.matchFormat != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(opponents, match.opponents);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (pending != null ? pending.hashCode() : 0);
        result = 31 * result + (tournamentId != null ? tournamentId.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + stageNumber;
        result = 31 * result + groupNumber;
        result = 31 * result + roundNumber;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        result = 31 * result + (matchFormat != null ? matchFormat.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(opponents);
        return result;
    }

    public static class Builder {

        String id;
        String type;
        String discipline;
        String status;
        String pending;
        String tournamentId;
        int number;
        int stageNumber;
        int groupNumber;
        int roundNumber;
        String date;
        String timezone;
        String matchFormat;
        Opponent[] opponents;

        Builder setId(String id) {
            this.id = id;
            return this;
        }

        Builder setType(String type) {
            this.type = type;
            return this;
        }

        Builder setDiscipline(String discipline) {
            this.discipline = discipline;
            return this;
        }

        Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        Builder setPending(String pending) {
            this.pending = pending;
            return this;
        }

        Builder setTournamentId(String tournamentId) {
            this.tournamentId = tournamentId;
            return this;
        }

        Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        Builder setStageNumber(int stageNumber) {
            this.stageNumber = stageNumber;
            return this;
        }

        Builder setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        Builder setRoundNumber(int roundNumber) {
            this.roundNumber = roundNumber;
            return this;
        }

        Builder setDate(String date) {
            this.date = date;
            return this;
        }

        Builder setTimezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        Builder setMatchFormat(String matchFormat) {
            this.matchFormat = matchFormat;
            return this;
        }

        Builder setOpponents(Opponent[] opponents) {
            this.opponents = opponents;
            return this;
        }

        Match build() {
            return new Match(id, type, discipline, status, pending, tournamentId, number,
                    stageNumber, groupNumber, roundNumber, date, timezone, matchFormat, opponents);
        }
    }

}
