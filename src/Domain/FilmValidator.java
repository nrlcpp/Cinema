package Domain;

public class FilmValidator {
public void validate (Film film) {
    if (film.getPrice()<= 0) {
        throw new RuntimeException("Price must be positive");
    }
    if (film.getYearOfAparition() >= 1900 && film.getYearOfAparition() <=2019){
        throw new RuntimeException("The yearof the apariton must be between  1900 and 2019");
    }
    if (film.getName() == null || film.getName().isEmpty()){
        throw new RuntimeException("Give the name of the film");
    }
}
}
