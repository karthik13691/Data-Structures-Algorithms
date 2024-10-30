package MovieSeatBooking.model;

import java.util.Date;

/**
 * The Seat class represents a movie seat in the theater.
 * It stores information about the seat number, booking status, booking date, and cancellation status.
 */
public class Seat {
    private String seatNumber;
    private boolean isBooked;
    private Date bookingDate;
    private boolean isCanceled;

    /**
     * Constructs a new Seat object with the given seat number.
     * Initially, the seat is not booked and not canceled.
     *
     * @param seatNumber The seat number of the seat.
     */
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.isCanceled = false;
    }

    /**
     * Returns the seat number of the seat.
     *
     * @return The seat number.
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * Sets the seat number of the seat.
     *
     * @param seatNumber The new seat number.
     */
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Returns whether the seat is booked or not.
     *
     * @return true if the seat is booked, false otherwise.
     */
    public boolean isBooked() {
        return isBooked;
    }

    /**
     * Sets the booking status of the seat.
     *
     * @param booked true if the seat is booked, false otherwise.
     */
    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    /**
     * Returns the booking date of the seat, if it is booked.
     *
     * @return The booking date, or null if the seat is not booked.
     */
    public Date getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the booking date of the seat.
     *
     * @param bookingDate The booking date.
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * Returns whether the seat booking has been canceled or not.
     *
     * @return true if the seat booking is canceled, false otherwise.
     */
    public boolean isCanceled() {
        return isCanceled;
    }

    /**
     * Sets the cancellation status of the seat booking.
     *
     * @param cancelled true if the seat booking is canceled, false otherwise.
     */
    public void setCanceled(boolean cancelled) {
        isCanceled = cancelled;
    }

    /**
     * Returns a string representation of the Seat object.
     *
     * @return A string containing the seat number, booking status, booking date, and cancellation status.
     */
    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", isBooked=" + isBooked +
                ", bookingDate=" + bookingDate +
                ", isCanceled=" + isCanceled +
                '}';
    }
}