import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        var calculadora = new CalculadoraParcelas(100, "31/01/2001");
        String[] datas = calculadora.calcular();
        for (String data : datas) {
            System.out.println(data);
        }
    }
}
