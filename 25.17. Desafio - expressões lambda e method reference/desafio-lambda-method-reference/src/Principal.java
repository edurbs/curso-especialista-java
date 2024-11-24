import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class Principal {

	public record Funcionario (String nome, BigDecimal salario, boolean ativo) {
		public boolean isInativo() {
			return !ativo;
		}
	}


	private static Funcionario createFuncionario(String nome, String salario) {
		return new Funcionario(nome, new BigDecimal(salario), true);
	}

	private static Funcionario inativar(Funcionario funcionario) {
		return new Funcionario(funcionario.nome(), funcionario.salario(), false);
	}

    public static void main(String[] args) {
		var funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(createFuncionario("João", "19000"));
		funcionarios.add(createFuncionario("Maria", "5000"));
		funcionarios.add(createFuncionario("Manoel", "13000"));
		funcionarios.add(createFuncionario("Sebastião", "12000"));

		Funcionario inativado = inativar(funcionarios.getLast());
		funcionarios.removeLast();
		funcionarios.add(inativado);

		// TODO remover funcionários inativos
		funcionarios.removeIf(Funcionario::isInativo);

		// TODO ordenar funcionários pelo valor do salário
		funcionarios.sort(Comparator.comparing(Funcionario::salario));

		// TODO iterar e imprimir funcionários usando o método estático imprimir
		funcionarios.forEach(Principal::imprimir);
	}

	private static void imprimir(Funcionario funcionario) {
		// TODO implementar a impressão do nome, salário e impostos (20%)
		System.out.println(funcionario.nome() + " - " + funcionario.salario() + " - " + funcionario.salario().multiply(new BigDecimal("0.20")));
	}

}