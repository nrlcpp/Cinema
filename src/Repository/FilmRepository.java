package Repository;

import Domain.Film;
import Domain.FilmValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmRepository {
private Map<String, Film> storage = new HashMap<>();
private FilmValidator validator;

public FilmRepository(FilmValidator validator){this.validator = validator;}

public Film findById(String id) { return storage.get(id);}
        /**
         * Adds or updates a film if it already exists.
         * @param film the film to add or update.
         * @throws RuntimeException if alredy exist a film with this name;
         */
public void upsert(Film film){
    validator.validate(film);
    storage.put(film.getId(),film);
}
/**
 * Removes a film with a given id.
 * @param id the id.
 * @throws RuntimeException if there is no film with the given id.
 */
public void remove(String id) {
    if (!storage.containsKey(id)) {
        throw new RuntimeException("There is no film with the given id to remuve.");
    }
    storage.remove(id);
}
public List<Film> getAll() {return new ArrayList<>(storage.values());
}
}
