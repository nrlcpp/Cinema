package UI;

import Domain.Film;
import Service.ClientService;
import Service.FilmService;
import Service.ReservationService;

import java.util.Scanner;

public class NewConsole {
    private FilmService filmService;

    private Scanner scanner;

    public NewConsole(FilmService filmService, ClientService clientService, ReservationService reservationService) {
    this.filmService = filmService;

    this.scanner = new Scanner(System.in);
    }

    public void runMenu() {
        while (true) {
            System.out.println("Enter your option (x for exit)");
            String option =scanner.nextLine();
            String[] s = option.split(",");

            switch (s[0].toLowerCase()) {
                case "addfilm":
                    try {
                        addFilm (s[1], s[2], Integer.parseInt(s[3]), Double.parseDouble(s[4]), Boolean.parseBoolean(s[5]));
                    } catch (ConsoleException cex) {
                        System.out.println("Add film error: " + cex.getMessage ());
                    }
                    break;
                case "updatefilm":
                    try {
                        updateFilm(s[1], s[2], Integer.parseInt(s[3]), Double.parseDouble(s[4]), Boolean.parseBoolean(s[5]));
                    } catch (ConsoleException cex) {
                        System.out.println("Update film error: " + cex.getMessage());
                    }
                    break;
                case "removefilm":
                    try {
                        removeFilm (s[1]);
                    } catch (ConsoleException cex) {
                        System.out.println("Remove film error: " + cex.getMessage());
                    }
                    break;
                case "showallfilms":
                    showAllFilms();
                    break;
                case "x":
                    return;
                    default:
                        System.out.println("Invalid option");
            }
        }
    }

    private void addFilm(String id, String name, int yearOfAparition, double price, boolean inProgram) {
        try{
            this.filmService.upsert(id, name, yearOfAparition, price,inProgram);
            System.out.println("\nFilm successfully added\n");
        } catch (ConsoleException cex) {
            System.out.println("We have an adding error " + cex.getMessage());
        }
    }

    private void updateFilm(String id, String name, int yearOfAparition, double price, boolean inProgram) {
        try {
            this.filmService.upsert(id, name, yearOfAparition, price,inProgram);
            System.out.println("\nFilm successfully updated\n");
        } catch (ConsoleException cex) {
            System.out.println("We have an updating error " + cex.getMessage());
        }
    }

    private void showAllFilms() {
        for (Film film : filmService.getAll()) {
            System.out.println(film);
        }
    }

    private void removeFilm(String id) {
        try {
            filmService.remove(id);
            System.out.println("Film successfully removed\n");
        } catch (ConsoleException cex) {
            System.out.println("We have an updating error " + cex.getMessage());
        }
    }


}
