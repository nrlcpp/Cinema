package Service;

import Domain.Film;
import Domain.Reservation;
import Repository.FilmRepository;
import Repository.ReservationRepository;

import java.util.Date;
import java.util.List;

public class ReservationService {

    private ReservationRepository reservationRepository;
    private FilmRepository filmRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
        this.filmRepository = filmRepository;
    }


    public static void remove(String id) {
        ReservationRepository.remove(id);
    }

    public List<Reservation> getAll() {
        return reservationRepository.getAll();

    }

    public Reservation addOrUpdate(String id, String idFilm, String idClientCard, int numberOfItems, String date, String time, String points) {
        Reservation existing = reservationRepository.findById(id);
        if (existing != null) {
// keep unchanged fields as they were
            if (idFilm.isEmpty()) {
                idFilm = existing.getIdFilm();
            }
            if (idClientCard.isEmpty()) {
                idClientCard = existing.getIdClientCard();
            }
            if (numberOfItems == 0) {
                numberOfItems = existing.getNumberOfItems();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }
        return existing;
    }
}
