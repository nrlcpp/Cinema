import Domain.ClientValidator;
import Domain.FilmValidator;
import Domain.ReservationValidator;
import Repository.ClientRepository;
import Repository.FilmRepository;
import Repository.ReservationRepository;
import Service.ClientService;
import Service.FilmService;
import Service.ReservationService;

import UI.Console;
import UI.NewConsole;

public class Main {

    public static void main(String[] args) {

        FilmValidator filmValidator = new FilmValidator();
        ClientValidator clientValidator = new ClientValidator();
        ReservationValidator reservationValidator = new ReservationValidator();

        FilmRepository filmRepository = new FilmRepository(filmValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        ReservationRepository reservationRepository = new ReservationRepository(reservationValidator);

        FilmService filmService = new FilmService(filmRepository);
        ClientService clientService = new ClientService(clientRepository);
        ReservationService reservationService = new ReservationService(reservationRepository);

       // Console console = new Console(filmService, clientService, reservationService);
       // console.run();

             NewConsole console = new NewConsole( filmService, clientService,reservationService);
      console.runMenu();
    }
}
