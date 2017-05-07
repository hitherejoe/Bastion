package co.joebirch.bastion.domain.model;

import java.util.Arrays;

public class Game {

    public int number;
    public String status;
    public Opponent[] opponents;

    public Game() {

    }

    private Game(int number, String status, Opponent[] opponents) {
        this.number = number;
        this.status = status;
        this.opponents = opponents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (number != game.number) return false;
        if (status != null ? !status.equals(game.status) : game.status != null) return false;
        return Arrays.equals(opponents, game.opponents);

    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(opponents);
        return result;
    }

    public static class Builder {

        int number;
        String status;
        Opponent[] opponents;

        Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        Builder setOpponents(Opponent[] opponents) {
            this.opponents = opponents;
            return this;
        }

        Game build() {
            return new Game(number, status, opponents);
        }

    }

}