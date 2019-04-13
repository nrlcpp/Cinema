package UI;

import Domain.Client;
import Domain.Film;
import Domain.Reservation;
import Service.ClientService;
import Service.FilmService;
import Service.ReservationService;

import java.util.Scanner;

public class Console {

    private FilmService filmService;
    private ClientService clientService;
    private ReservationService reservationService;

    private Scanner scanner;

    public Console(FilmService filmService, ClientService clientService, ReservationService reservationService) {
        this.filmService = filmService;
        this.clientService = clientService;
        this.reservationService = reservationService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Film CRUD");
        System.out.println("2. Client CRUD");
        System.out.println("3. Reservation CRUD");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runFilmCrud();
                    break;
                case "2":
                    runClientCrud();
                    break;
                case "3":
                    runReservationCrud();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runClientCrud() {
        while (true) {
            System.out.println("1. Add or update a client");
            System.out.println("2. Remove a client");
            System.out.println("3. View all clients");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateClient();
                    break;
                case "2":
                    handleRemoveClient();
                    break;
                case "3":
                    handleViewClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewClients() {
        for (Client client : clientService.getAll()) {
            System.out.println(client);
        }

    }

    private void handleRemoveClient() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            clientService.remove(id);

            System.out.println("Client removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClient() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter last name (empty to not change for update): ");
            String lastName = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP (empty to not change for update): ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            String dateOfRegistration = scanner.nextLine();
            System.out.print("Enter the number of (empty to not change for update): ");
            String points = scanner.nextLine();


            clientService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration, points);

            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runFilmCrud() {
        while (true) {
            System.out.println("1. Add or update a film");
            System.out.println("2. Remove a film");
            System.out.println("3. View all films");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateFilm();
                    break;
                case "2":
                    handleRemoveFilm();
                    break;
                case "3":
                    handleViewFilms();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runReservationCrud() {
        while (true) {
            System.out.println("1. Add or update a transaction");
            System.out.println("2. Remove a transaction");
            System.out.println("3. View all transactions");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateReservation();
                    break;
                case "2":
                    handleRemoveReservation();
                    break;
                case "3":
                    handleViewReservation();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleAddUpdateReservation() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter film id (empty to not change for update): ");
            String idFilm = scanner.nextLine();
            System.out.print("Enter client card (empty to not change for update): ");
            String idClientCard = scanner.nextLine();
            System.out.print("Enter number of items (0 to not change for update): ");
            int numberOfItems = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date (empty to not change for update): ");
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();
            System.out.print("Enter numbers of points (empty to not change for update): ");
            String points = scanner.nextLine();

          Reservation reservation = reservationService.addOrUpdate(id, idFilm, idClientCard, numberOfItems, date, time, points);
            System.out.println(String.format("Added reservation id=%s, paid price=%f, discount=%f%%", reservation.getId()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }


    private void  handleViewReservation() {
        for (Reservation reservation : reservationService.getAll()) {
            System.out.println(reservation);
        }
    }

    private void handleRemoveReservation() {
            try {
                System.out.print("Enter the id to remove:");
                String id = scanner.nextLine();
                ReservationService.remove(id);

                System.out.println("Reservation removed!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }

    private void handleViewFilms() {
        for (Film film : filmService.getAll()) {
            System.out.println(film);
        }
    }

    private void handleRemoveFilm() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            filmService.remove(id);

            System.out.println("Film removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateFilm() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter name (empty to not change for update): ");
            String name = scanner.nextLine();
            System.out.print("Enter the year of aparition (empty to not change for update): ");
            String yearOfAparition = scanner.nextLine();
            System.out.print("Enter price (0 to not change for update): ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter in program (true / false): ");
            boolean inProgram = Boolean.parseBoolean(scanner.nextLine());

            filmService.upsert(id, name, Integer.parseInt(yearOfAparition), price, inProgram);

            System.out.println("Film added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }

    }
}


