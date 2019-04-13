package Service;

import Domain.Film;
import Repository.FilmRepository;

import java.util.List;

public class FilmService {
    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void upsert(String id, String name, int yearOfAparition, double price, boolean inProgram) {
        Film existing = filmRepository.findById(id);
        if (existing != null) {
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (yearOfAparition == 0) {
                yearOfAparition = existing.getYearOfAparition();
            }
            if (price == 0) {
                price = existing.getPrice();
            }
        }
        Film film = new Film(id, name, yearOfAparition, price, inProgram);
        filmRepository.upsert(film);
    }

    public void remove(String id) {
        filmRepository.remove(id);
    }

    public List<Film> getAll() {
        return filmRepository.getAll();
    }

    public void insert(String id, String name, int yearOfAparition, double price, boolean inProgram) {
        Film film = new Film(id, name, yearOfAparition, price, inProgram);
        filmRepository.insert(film);
    }


    public void update(String id, String name, int yearOfAparition, double price, boolean inProgram) {
        Film film = new Film(id, name, yearOfAparition, price, inProgram);
        filmRepository.update(film);
    }
}
