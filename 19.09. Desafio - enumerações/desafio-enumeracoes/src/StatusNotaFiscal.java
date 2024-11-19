public enum StatusNotaFiscal {
    NAO_EMITIDA ("Não emitida") {
        @Override
        public boolean podeCancelar(double valorPedido){
            return true;
        }

        @Override
        public boolean podeEmitir(){
            return true;
        }
    },
    EMITIDA ("Emitida") {
        @Override
        public boolean podeCancelar(double valorPedido){
            return valorPedido<1_000;
        }

        @Override
        public boolean podeEmitir(){
            return false;
        }

    },
    CANCELADA ("Cancelada") {
        @Override
        public boolean podeCancelar(double valorPedido){
            return false;
        }

        @Override
        public boolean podeEmitir() {
            return false;
        }

    };

    private String descricao;

    StatusNotaFiscal(String descricao) {
        this.descricao = descricao;
    }

    public abstract boolean podeCancelar(double valorPedido);

    public abstract boolean podeEmitir();

}
