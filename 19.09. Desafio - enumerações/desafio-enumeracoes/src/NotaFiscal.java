public class NotaFiscal {

    private final Integer numero;
    private final String descricao;
    private final double valor;
    private StatusNotaFiscal status = StatusNotaFiscal.NAO_EMITIDA;

    public NotaFiscal(Integer numero, String descricao, double valor) {
        this.numero = numero;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public StatusNotaFiscal getStatus() {
        return status;
    }

    public void cancelar() {
        if (naoPodeCancelar()) {
            throw new IllegalStateException("Não foi possível cancelar a nota fiscal");
        }
        status=StatusNotaFiscal.CANCELADA;
    }

    private boolean naoPodeCancelar() {
        return !getStatus().podeCancelar(getValor());
    }

    public void emitir() {
        if (naoPodeEmitir()) {
            throw new IllegalStateException("Não foi possível emitir a nota fiscal");
        }
        status = StatusNotaFiscal.EMITIDA;
    }

    private boolean naoPodeEmitir() {
        return !getStatus().podeEmitir();
    }

    public String getDescricaoCompleta() {
        String descricaoStatus = getStatus().name();

        return String.format("Nota fiscal #%d (%s) no valor de R$%.2f está %s",
                getNumero(), getDescricao(), getValor(), descricaoStatus);
    }

}
