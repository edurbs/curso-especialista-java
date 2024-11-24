import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Scheduler {
    private InputModel inputModel;
    private final List<ZonedDateTime> partyDateTimes = new ArrayList<>(4);
    public Scheduler(InputModel inputModel) {
        this.inputModel = inputModel;
    }

    public void create(){
        LocalDate localDate;
        LocalTime localTime;
        try{
            localDate = LocalDate.parse(inputModel.localDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            localTime = LocalTime.parse(inputModel.localTime(), DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeException e){
            throw new IllegalArgumentException("Data ou hora incorreta");
        }
        ZonedDateTime zonedParty = localDate.atTime(localTime).atZone(ZoneId.systemDefault());
        partyDateTimes.add(zonedParty.withZoneSameInstant(ZoneId.of("America/Sao_Paulo")));
        partyDateTimes.add(zonedParty.withZoneSameInstant(ZoneId.of("Japan")));
        partyDateTimes.add(zonedParty.withZoneSameInstant(ZoneId.of("America/Los_Angeles")));
    }

    public void showInfo(){
        Locale pt_BR = Locale.of("pt", "BR");
        String pattern = "dd 'de' MMMM 'de' yyyy 'às' HH:mm (zzzz)";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, pt_BR);
        for (ZonedDateTime partyDateTime : partyDateTimes) {
            System.out.println(formatter.format(partyDateTime));
        }
    }
}
