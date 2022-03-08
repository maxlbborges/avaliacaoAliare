//Classe relativa ao CT01.
package br.com.avaliacao.testes;

import br.com.avaliacao.resources.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class ValidaSegmentos {
    private WebDriver browser;

    @Before
    public void PreReq() {
        browser = Driver.AbrirDriver();
        Driver.SetupDriver(browser);
        browser.manage().window().maximize();
    }

    @Test
    public void ValidarSegmentos() {

        //Variáveis que serão utilizadas para verificar se existem elementos com o nome de classe definido.
        //Caso não exista retornam true (tendo tamanho = 0), caso exista retornam false.
        Boolean existeAntes = browser.findElements(By.className("seg-2")).size() == 0;
        Boolean existeDepois = browser.findElements(By.className("seg-9")).size() == 0;

        //1. Distribuidor de insumos;
        String distInsumos = browser.findElement(By.className("seg-3")).getText();
        assertEquals("Distribuidor de insumos", distInsumos);

        //2. Loja agropecuária;
        String lojaAgro = browser.findElement(By.className("seg-4")).getText();
        assertEquals("Loja agropecuária", lojaAgro);

        //3. Armazéns gerais;
        String amzGeral = browser.findElement(By.className("seg-5")).getText();
        assertEquals("Armazéns gerais", amzGeral);

        //4. Produtor agrícola;
        String prodAgricola = browser.findElement(By.className("seg-6")).getText();
        assertEquals("Produtor agrícola", prodAgricola);

        //5. Sementeira;
        String sementeira = browser.findElement(By.className("seg-7")).getText();
        assertEquals("Sementeira", sementeira);

        //6. Outros;
        String outros = browser.findElement(By.className("seg-8")).getText();
        assertEquals("Outros", outros);

        //Verifica se há elementos antes ou depois do intervalo adotado para nomeação da lista;
        if(existeAntes == false || existeDepois == false){
            Assert.fail();
        }

    }

    @After
    public void Encerrar() {
        Driver.FecharDriver();
    }
}