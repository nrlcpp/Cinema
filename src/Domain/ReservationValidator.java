package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationValidator {

    public void validate(Reservation reservation) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatHour = new SimpleDateFormat("hh.mm");
        try {
            format.parse(reservation.getDate());
        } catch (ParseException pe) {
            throw new RuntimeException("Date is not in a correct format!");
        }
        try {
            formatHour.parse(reservation.getHour());
        } catch (ParseException pe) {
            throw new RuntimeException("Hour is not in a correct format!");
        }
    }
}