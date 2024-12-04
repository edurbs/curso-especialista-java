package com.algaworks.arquivos;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algaworks.arquivos.fragmentador.FragmentadorDeArquivo;

public class Principal {

    private static final Logger logger = LoggerFactory.getLogger(Principal.class);

    public static void main(String[] args) {
        try {
            logger.info("INFO: Iniciando programa de fragmentação...");
            var fragmentador = new FragmentadorDeArquivo(
                    Path.of("fotos/picanha.jpg"),
                    1024 * 50);
            fragmentador.fragmentar();
            logger.info("INFO: Fragmentação concluída com sucesso!");
        } catch (Exception e) {
            logger.error("Erro fragmentando arquivo");
            e.printStackTrace();
        }
    }

}
