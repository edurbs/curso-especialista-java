import com.algaworks.comercial.Cliente;
import com.algaworks.comercial.ServicoDeVenda;
import com.algaworks.comercial.Venda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal7 {

    public static void main(String[] args) {
        var servicoDeVenda = new ServicoDeVenda();
        List<Venda> vendas = servicoDeVenda.obterTodas();
        System.out.println(
                vendas.stream()
                        .filter(Venda::isFechada)
                        .collect(Collectors.groupingBy(
                                venda -> venda.getCliente().nome(),
                                Collectors.counting()
                        ))

        );
    }

}
