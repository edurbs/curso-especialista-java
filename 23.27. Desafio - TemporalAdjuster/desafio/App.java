public class App {
    public static void main(String[] args) {
        String startYear = "2024";
        String startMonth = "11";
        InputModel inputModel = new InputModel(startYear, startMonth);
        Scheduler scheduler = new Scheduler(inputModel);
        scheduler.calc();
        scheduler.showInfo();
    }
}
