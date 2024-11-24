import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgeCalculator {
    private final String birthday;
    private Period period;

    public AgeCalculator(String birthday) {
        this.birthday = birthday;
    }

    public void calc() {
        LocalDate birthDayDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            birthDayDate = LocalDate.parse(birthday, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Data inválida");
        }
        LocalDate now = LocalDate.now();
        period = Period.between(birthDayDate, now);
    }

    public void showInfo() {
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        String text = "O paciente tem " +
                years + " ano" + (years > 1 ? "s" : "") + ", " +
                months + " mês" + (months > 1 ? "es" : "") +
                " e " + days + " dia" + (days > 1 ? "s" : "") + ".";
        System.out.println(text);
    }

}
