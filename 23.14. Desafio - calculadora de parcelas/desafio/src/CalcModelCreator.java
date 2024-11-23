import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalcModelCreator {
    InputCalc inputCalc;

    public CalcModelCreator(InputCalc inputCalc) {
        this.inputCalc = inputCalc;
    }

    public CalcModel create() {
        if (inputCalc.numberOfInstallments() < 1) {
            throw new IllegalArgumentException("Quantidade de parcelas deve ser maior que 1.");
        }
        try {
            LocalDate date = LocalDate.parse(inputCalc.installment1(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return new CalcModel(date, inputCalc.numberOfInstallments());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Formato da data está incorreto.");
        }
    }
}
