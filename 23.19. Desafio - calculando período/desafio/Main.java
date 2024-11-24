public class Main {
    public static void main(String[] args) {
        String birthday = "21/09/1980";
        AgeCalculator ageCalculator = new AgeCalculator(birthday);
        ageCalculator.calc();
        ageCalculator.showInfo();
    }
}
