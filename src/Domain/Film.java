package Domain;

import java.util.Objects;

public class Film {
    private String id, name;
    private int yearOfAparition;
    private double price;
    private boolean inProgram;

    public Film(String id, String name, int yearOfAparition, double price, boolean inProgram) {
        this.id = id;
        this.name = name;
        this.yearOfAparition = yearOfAparition;
        this.price = price;
        this.inProgram = inProgram;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,yearOfAparition,price,inProgram);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Film film = (Film) obj;
        return id.equals(film.id);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", yearOfAparition=" + yearOfAparition + '\'' +
                ", price=" + price +
                ", inProgram=" + inProgram +
                '}';
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getYearOfAparition() { return yearOfAparition; }

    public void setYearOfAparition(int yearOfAparition) { this.yearOfAparition = yearOfAparition; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public boolean isInProgram() { return inProgram; }

    public void setInProgram(boolean inProgram) { this.inProgram = inProgram; }
}
