package Service;

import Domain.Film;
import Repository.FilmRepository;

import java.util.List;

public class FilmService {
    private FilmRepository repository;

    public  FilmService(FilmRepository repository) {this.repository = repository; }

    public void addOrUpdate (String id, String name, int yearOfAparition, double price, boolean inProgram) {
        Film existing = repository.findById(id);
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
            Film film = new Film(id, name, yearOfAparition, price, inProgram);
            repository.upsert(film);
        }
    }
    public void remove(String id) { repository.remove(id); }
    public List<Film> getAll() { return repository.getAll(); }
}
