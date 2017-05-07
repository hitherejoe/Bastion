package co.joebirch.bastion.domain.model;

public class Stage {

    public int number;
    public String name;
    public String type;
    public int size;

    public Stage() {

    }

    private Stage(int number, String name, String type, int size) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stage stage = (Stage) o;

        if (number != stage.number) return false;
        if (size != stage.size) return false;
        if (name != null ? !name.equals(stage.name) : stage.name != null) return false;
        return type != null ? type.equals(stage.type) : stage.type == null;

    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    public static class Builder {

        int number;
        String name;
        String type;
        int size;

        Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setType(String type) {
            this.type = type;
            return this;
        }

        Builder setSize(int size) {
            this.size = size;
            return this;
        }

        Stage build() {
            return new Stage(number, name, type, size);
        }

    }

}