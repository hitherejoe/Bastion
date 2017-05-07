package co.joebirch.bastion.domain.model;

public class Participant {

    public String id;
    public String name;
    public String country;

    public Participant() {

    }

    private Participant(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public static class Builder {

        String id;
        String name;
        String country;

        Builder setId(String id) {
            this.id = id;
            return this;
        }

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        Participant build() {
            return new Participant(id, name, country);
        }

    }

}
