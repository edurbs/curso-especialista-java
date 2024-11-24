import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Scheduler {
    private final InputModel inputModel;
    private final List<LocalDate> dates = new ArrayList<>(13);

    public Scheduler(InputModel inputModel) {
        this.inputModel = inputModel;
    }

    public void calc() {
        YearMonth meetingStart = createMeetingStart(inputModel);
        LocalDate date = meetingStart.atDay(1);
        LocalDate firstMonday = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        for (int i = 0; i < 12; i++) {
            dates.add(firstMonday);
            firstMonday = firstMonday
                    .plusMonths(1)
                    .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        }
    }

    private YearMonth createMeetingStart(InputModel inputModel) {
        try {
            return YearMonth.of(
                    Integer.parseInt(inputModel.startYear()),
                    Integer.parseInt(inputModel.startMonth())
            );
        } catch (NumberFormatException | DateTimeException e) {
            throw new IllegalArgumentException("Data incorreta");
        }
    }

    public void showInfo() {
        Locale pt_BR = Locale.of("pt", "BR");
        LocalDate firstDate = dates.getFirst();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("MMMM 'de' yyyy")
                .withLocale(pt_BR);
        String header = "Gerando agenda anual de reuniões desde " + firstDate.format(formatter);
        System.out.println(header);
        for (LocalDate date : dates) {
            formatter = DateTimeFormatter
                    .ofPattern("cccc, d 'de' MMMM 'de' yyyy")
                    .withLocale(pt_BR);
            String info = date.format(formatter);
            System.out.println(info);
        }
    }
}
