import java.time.LocalDateTime;

public class show {
    private movie movie;
    private LocalDateTime showTime;
    private int availableSeats;

    public show(movie movie, LocalDateTime showTime, int availableSeats) {
        this.movie = movie;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
    }

    // Getters and setters
    public movie getMovie() {
        return movie;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            throw new IllegalStateException("No seats available.");
        }
    }
}
