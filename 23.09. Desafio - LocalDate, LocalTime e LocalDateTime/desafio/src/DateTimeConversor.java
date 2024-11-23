import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeConversor {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private final String string;

    public DateTimeConversor(String string){
        this.string=string;
    }

    public LocalDate convertDate() throws InvalidDateException {
        try {
            return LocalDate.parse(string, dateFormatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Data inválida.");
        }
    }

    public LocalTime convertTime() {
        try {
            return LocalTime.parse(string, timeFormatter);
        } catch (DateTimeParseException e) {
            throw new InvalidTimeException("Hora Inválida");
        }
    }

}
