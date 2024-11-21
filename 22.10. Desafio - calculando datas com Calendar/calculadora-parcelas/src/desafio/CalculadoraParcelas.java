import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculadoraParcelas {
    private final int quantidade;
    private final String dataInicial;
    public CalculadoraParcelas(int quantidade, String dataInicial){
        this.quantidade = quantidade;
        this.dataInicial = dataInicial;
    }
    public String[] calcular() throws ParseException {
        String formato = "dd/MM/yyyy";
        SimpleDateFormat formatador = new SimpleDateFormat(formato);
        Calendar calendar = Calendar.getInstance();
        Date parcelaInicial = formatador.parse(dataInicial);
        calendar.setTime(parcelaInicial);
        int diaParcelaInicial = calendar.get(Calendar.DAY_OF_MONTH);

        String[] datasParcelas = new String[quantidade];
        datasParcelas[0] = formatador.format(parcelaInicial);
        int diferenca=0;
        for(int i = 1; i<quantidade; i++){
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, diferenca);
            Date dataParcela = calendar.getTime();
            datasParcelas[i]=formatador.format(dataParcela);
            int diaParcela = calendar.get(Calendar.DAY_OF_MONTH);
            if(diaParcela!=diaParcelaInicial){
                diferenca = diaParcelaInicial-diaParcela;
            }else{
                diferenca=0;
            }
        }
        return datasParcelas;
    }
}
