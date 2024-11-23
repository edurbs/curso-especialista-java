import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Scheduler {
    private final InputDateTime inputDateTime;
    private LocalDateTime dateTime;

    public Scheduler(String date, String time) {
        inputDateTime = new InputDateTime(date, time);
    }

    public void schedule() {
        try {
            EventDateTime event = new EventDateTime(
                    new DateTimeConversor(inputDateTime.date()).convertDate(),
                    new DateTimeConversor(inputDateTime.time()).convertTime()
            );
            dateTime = LocalDateTime.of(event.date(), event.time());
        } catch (InvalidDateException | InvalidTimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void informSchedule() {
        //“Evento agendado para domingo, 25 de dezembro de 2022 20:00”
        Locale pt_BR = Locale.of("pt", "BR");
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT)
                .withLocale(pt_BR);
        System.out.printf("Evento agendado para %s.%n",formatter.format(dateTime));
    }
}
