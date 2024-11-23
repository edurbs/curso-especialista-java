public class ScheduleSystem {
    public static void main(String[] args) {
        String data = "21/09/1980";
        String hora = "21:59";
        Scheduler scheduler = new Scheduler(data, hora);
        scheduler.schedule();
        scheduler.informSchedule();
    }
}
