public class ticket {
    private show show;
    private user user;
    private int seatNumber;

    public ticket(show show, user user, int seatNumber) {
        this.show = show;
        this.user = user;
        this.seatNumber = seatNumber;
    }

    // Getters and setters
    public show getShow() {
        return show;
    }

    public user getUser() {
        return user;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
