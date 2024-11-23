public class Main {
    public static void main(String[] args) {
        String installment1 = "01/01/2021";
        int numberOfInstallments = 12;
        var inputCalc = new InputCalc(installment1, numberOfInstallments);
        var calcModelCreator = new CalcModelCreator(inputCalc);
        var calcModel = calcModelCreator.create();
        var installmentCalculator = new InstallmentCalculator(calcModel);
        installmentCalculator.calculate();
        installmentCalculator.showInstallmentsInfo();
    }

}
