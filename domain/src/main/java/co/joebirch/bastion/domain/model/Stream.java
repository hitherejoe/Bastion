package co.joebirch.bastion.domain.model;

public class Stream {

    public String id;
    public String name;
    public String url;

    public Stream() {
        
    }

    private Stream(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stream stream = (Stream) o;

        if (id != null ? !id.equals(stream.id) : stream.id != null) return false;
        if (name != null ? !name.equals(stream.name) : stream.name != null) return false;
        return url != null ? url.equals(stream.url) : stream.url == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    public static class Builder {

        String id;
        String name;
        String url;

        Builder setId(String id) {
            this.id = id;
            return this;
        }

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        Stream build() {
            return new Stream(id, name, url);
        }
    }
}
