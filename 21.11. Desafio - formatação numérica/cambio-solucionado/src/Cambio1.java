import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Cambio1 {
    public static void main(String[] args) throws ParseException {
        String dolarString = "1,300.00";
        String cotacaoString = "5,34";
        String reaisString = "R$ 6.942,53";

        DecimalFormatSymbols symbolsUS = new DecimalFormatSymbols(Locale.US);

        DecimalFormat formatUS = new DecimalFormat("#,##0.00", symbolsUS);
        formatUS.setParseBigDecimal(true);
        BigDecimal dolar = (BigDecimal) formatUS.parse(dolarString);

        Locale pt_BR = new Locale("pt", "BR");
        DecimalFormatSymbols symbolsBR = new DecimalFormatSymbols(pt_BR);
        DecimalFormat formatBR = new DecimalFormat("#,##0.00", symbolsBR);
        formatBR.setParseBigDecimal(true);
        BigDecimal cotacao = (BigDecimal) formatBR.parse(cotacaoString);

        DecimalFormat formatBRL = new DecimalFormat("¤ #,##0.00", symbolsBR);
        formatBRL.setParseBigDecimal(true);
        BigDecimal reais = dolar.multiply(cotacao);



        if(reais.equals(new BigDecimal("6942.3"))){
            throw new RuntimeException("Erro ao multiplicar");
        }

    }
}
