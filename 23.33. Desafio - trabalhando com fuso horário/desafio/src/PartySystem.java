import java.util.Scanner;

public class PartySystem {
    public static void main(String[] args) {
        String localTime;
        String localDate;
        Scanner scanner = new Scanner(System.in);
        boolean mustContinue = true;
        do {
            Scheduler scheduletor;
            try{
                System.out.print("Digite a data local da festa: ");
                localDate = scanner.nextLine();
                System.out.print("Digite o horário local da festa: ");
                localTime = scanner.nextLine();
                InputModel inputModel = new InputModel(localTime, localDate);
                scheduletor = new Scheduler(inputModel);
                scheduletor.create();
                scheduletor.showInfo();
                mustContinue=false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while (mustContinue);
    }
}
