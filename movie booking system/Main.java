import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<movie> movies = new ArrayList<>();
        List<show> shows = new ArrayList<>();
        List<ticket> tickets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Sample movies
        movies.add(new movie("Inception", "Sci-Fi", 148));
        movies.add(new movie("The Godfather", "Crime", 175));

        // Sample shows
        shows.add(new show(movies.get(0), LocalDateTime.of(2024, 6, 10, 19, 0), 100));
        shows.add(new show(movies.get(1), LocalDateTime.of(2024, 6, 10, 20, 0), 100));

        System.out.println("Welcome to the Movie Ticket Booking System!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        user user = new user(name, email);

        System.out.println("\nAvailable Shows:");
        for (int i = 0; i < shows.size(); i++) {
            show show = shows.get(i);
            System.out.println((i + 1) + ". " + show.getMovie().getTitle() + " at " + show.getShowTime() + " (" + show.getAvailableSeats() + " seats available)");
        }

        System.out.print("\nSelect a show (1-" + shows.size() + "): ");
        int showIndex = scanner.nextInt() - 1;

        show selectedShow = shows.get(showIndex);
        System.out.print("Enter number of seats to book: ");
        int seatsToBook = scanner.nextInt();

        if (seatsToBook <= selectedShow.getAvailableSeats()) {
            for (int i = 0; i < seatsToBook; i++) {
                selectedShow.bookSeat();
                tickets.add(new ticket(selectedShow, user, selectedShow.getAvailableSeats() + 1));
            }
            System.out.println("Booking successful! " + seatsToBook + " seats booked for " + selectedShow.getMovie().getTitle() + " at " + selectedShow.getShowTime());
        } else {
            System.out.println("Booking failed! Not enough seats available.");
        }

        scanner.close();
    }
}
