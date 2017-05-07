package co.joebirch.bastion.domain.model;

import java.util.Arrays;

public class FullTournament extends Tournament {

    public String name;
    public String timezone;
    public String location;
    public String country;
    public String participantType;
    public String matchType;
    public String organization;
    public String website;
    public String description;
    public String rules;
    public String prize;
    public Stream[] streams;

    public FullTournament() {

    }

    private FullTournament(String id, String name, String status, String dateStart, String dateEnd,
                           int size, String timezone, String location, String country,
                           String participantType, String matchType, String organization,
                           String website, String description, String rules, String prize,
                           Stream[] streams) {
        super(id, name, status, dateStart, dateEnd, size);
        this.name = name;
        this.timezone = timezone;
        this.location = location;
        this.country = country;
        this.participantType = participantType;
        this.matchType = matchType;
        this.organization = organization;
        this.website = website;
        this.description = description;
        this.rules = rules;
        this.prize = prize;
        this.streams = streams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullTournament that = (FullTournament) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null)
            return false;
        if (location != null ? !location.equals(that.location) : that.location != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (participantType != null ? !participantType.equals(that.participantType) : that.participantType != null)
            return false;
        if (matchType != null ? !matchType.equals(that.matchType) : that.matchType != null)
            return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null)
            return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (rules != null ? !rules.equals(that.rules) : that.rules != null) return false;
        if (prize != null ? !prize.equals(that.prize) : that.prize != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(streams, that.streams);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (participantType != null ? participantType.hashCode() : 0);
        result = 31 * result + (matchType != null ? matchType.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rules != null ? rules.hashCode() : 0);
        result = 31 * result + (prize != null ? prize.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(streams);
        return result;
    }

    public static class Builder {

        String id;
        String name;
        String status;
        String dateStart;
        String dateEnd;
        int size;
        String timezone;
        String location;
        String country;
        String participantType;
        String matchType;
        String organization;
        String website;
        String description;
        String rules;
        String prize;
        Stream[] streams;

        Builder setId(String id) {
            this.id = id;
            return this;
        }

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        Builder setDateStart(String dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        Builder setDateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        Builder setSize(int size) {
            this.size = size;
            return this;
        }

        Builder setTimezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        Builder setParticipantType(String participantType) {
            this.participantType = participantType;
            return this;
        }

        Builder setMatchType(String matchType) {
            this.matchType = matchType;
            return this;
        }

        Builder setOrganization(String organization) {
            this.organization = organization;
            return this;
        }

        Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        Builder setRules(String rules) {
            this.rules = rules;
            return this;
        }

        Builder setPrize(String prize) {
            this.prize = prize;
            return this;
        }

        Builder setStreams(Stream[] streams) {
            this.streams = streams;
            return this;
        }

        FullTournament build() {
            return new FullTournament(id, name, status, dateStart, dateEnd, size, timezone,
                    location, country, participantType, matchType, organization, website,
                    description, rules, prize, streams);
        }

    }

}
