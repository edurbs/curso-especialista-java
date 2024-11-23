import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InstallmentCalculator {
    private final CalcModel calcModel;
    private final List<LocalDate> installmentDates = new ArrayList<>();

    public InstallmentCalculator(CalcModel calcModel) {
        this.calcModel = calcModel;
    }

    public void calculate() {
        LocalDate lastInstallment = calcModel.firstInstallment();
        installmentDates.add(lastInstallment);
        for (int i = 0; i < calcModel.numberOfInstallments(); i++) {
            LocalDate nextInstallment = lastInstallment.plusMonths(i + 1);
            installmentDates.add(nextInstallment);
        }
    }

    public void showInstallmentsInfo() {
        for (int i = 0; i < installmentDates.size(); i++) {
            LocalDate installmentDate = installmentDates.get(i);
            String date = installmentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.printf("Parcela %d: %s%n", i, date);
        }
    }
}
