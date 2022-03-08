package br.com.avaliacao;

import br.com.avaliacao.testes.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidaSegmentos.class,
        ValidaDistInsumos.class,
        ValidaLojaAgro.class,
        ValidaArmazensGerais.class,
        ValidaProdAgricola.class,
        ValidaSementeira.class,


})

public class TestRunner{

}