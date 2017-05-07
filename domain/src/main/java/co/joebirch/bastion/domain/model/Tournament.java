package co.joebirch.bastion.domain.model;

public class Tournament {

    public String id;
    public String name;
    public String status;
    public String dateStart;
    public String dateEnd;
    public int size;

    public Tournament() {

    }

    Tournament(String id, String name, String status, String dateStart, String dateEnd,
               int size) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tournament that = (Tournament) o;

        if (size != that.size) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (dateStart != null ? !dateStart.equals(that.dateStart) : that.dateStart != null)
            return false;
        return dateEnd != null ? dateEnd.equals(that.dateEnd) : that.dateEnd == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    public static class Builder {

        String id;
        String name;
        String status;
        String dateStart;
        String dateEnd;
        int size;

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

        Tournament build() {
            return new Tournament(id, name, status, dateStart, dateEnd, size);
        }
    }

}
