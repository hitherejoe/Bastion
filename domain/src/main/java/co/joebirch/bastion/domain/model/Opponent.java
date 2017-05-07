package co.joebirch.bastion.domain.model;

public class Opponent {

    public int number;
    public Participant participant;
    public int result;
    public String score;
    public boolean forfeit;

    public Opponent() {

    }

    private Opponent(int number, Participant participant, int result, String score,
                     boolean forfeit) {
        this.number = number;
        this.participant = participant;
        this.result = result;
        this.score = score;
        this.forfeit = forfeit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Opponent opponent = (Opponent) o;

        if (number != opponent.number) return false;
        if (result != opponent.result) return false;
        if (forfeit != opponent.forfeit) return false;
        if (participant != null ? !participant.equals(opponent.participant) : opponent.participant != null)
            return false;
        return score != null ? score.equals(opponent.score) : opponent.score == null;

    }

    @Override
    public int hashCode() {
        int result1 = number;
        result1 = 31 * result1 + (participant != null ? participant.hashCode() : 0);
        result1 = 31 * result1 + result;
        result1 = 31 * result1 + (score != null ? score.hashCode() : 0);
        result1 = 31 * result1 + (forfeit ? 1 : 0);
        return result1;
    }

    public static class Builder {

        int number;
        Participant participant;
        int result;
        String score;
        boolean forfeit;

        public Builder() {

        }

        Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        Builder setParticipant(Participant participant) {
            this.participant = participant;
            return this;
        }

        Builder setResult(int result) {
            this.result = result;
            return this;
        }

        Builder setScore(String score) {
            this.score = score;
            return this;
        }

        Builder setForfeit(boolean forfeit) {
            this.forfeit = forfeit;
            return this;
        }

        Opponent build() {
            return new Opponent(number, participant, result, score, forfeit);
        }
    }

}
