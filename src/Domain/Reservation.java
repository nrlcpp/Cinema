package Domain;

public class Reservation {
    private String id;
    private String id_movie;
    private String id_card_client;
    private String date;
    private String hour;

    public Reservation(String id, String id_movie, String id_client, String date, String hour) {
        this.id = id;
        this.id_movie = id_movie;
        this.id_card_client = id_card_client;
        this.date = date;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", id_movie='" + id_movie + '\'' +
                ", id_client='" + id_card_client + '\'' +
                ", date='" + date + '\'' +
                ", hour=" + hour +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_movie() {
        return id_movie;
    }

    public void setId_movie(String id_movie) {
        this.id_movie = id_movie;
    }

    public String getId_card_client() {
        return id_card_client;
    }

    public void setId_card_client(String id_card_client) {
        this.id_card_client = id_card_client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getIdFilm() { return getIdFilm();
    }

    public String getIdClientCard() { return getIdFilm();
    }

    public int getNumberOfItems() {return getNumberOfItems();
    }

    public String getTime() {return getTime();
    }
}