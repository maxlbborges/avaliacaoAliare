//Classe relacionada ao CT04
package br.com.avaliacao.testes;

import br.com.avaliacao.resources.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class ValidaArmazensGerais {
    private WebDriver browser;

    @Before
    public void PreReq() {
        browser = Driver.AbrirDriver();
        Driver.SetupDriver(browser);
        browser.manage().window().maximize();
        browser.findElement(By.linkText("Armazéns gerais")).click();
    }

    @Test
    public void ValidarSegmentoAtivo() {
        //Valida título do segmento selecionado
        String validaSegmento = browser.findElement(By.className("seg-5")).getText();
        assertEquals("Armazéns gerais", validaSegmento);

    }
    //CT04.1
    @Test
    public void ValidaBanner(){
        // Validar que o elemento cujo título está impresso existe e está com o título correto
        browser.findElement(By.linkText("Armazéns gerais")).click();
        String tituloBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("h2")).getText();
        assertEquals("Softwares para gestão de armazéns gerais e cerealistas", tituloBanner);

        //Validar que o elemento cuja descrição está impressa existe e está com a descrição correta
        String descBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("p")).getText();
        assertEquals("Ganhe eficiência desde o recebimento até a expedição dos " +
                "grãos. Com o Grupo Siagri, você gerencia todos os processos de armazenagem " +
                "de grãos com agilidade e segurança.", descBanner);

        //Validar a abertura do formulário
        browser.findElement(By.className("form-open")).click();
        String tituloForm = browser.findElement(By.className("modal-form-body")).findElement(By.tagName("h4")).getText();
        assertEquals("Solicite demonstração das nossas soluções.", tituloForm);

    }
    //CT4.2
    @Test
    public void validaDesafios(){
        // Encontrar os Desafios do Segmento e então encontrar e validar os itens
        browser.findElement(By.linkText("Armazéns gerais")).click();
        String gestContrato = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]")).getText();
        assertEquals("Gestão de contratos", gestContrato);

        String saldoTerceiros = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]")).getText();
        assertEquals("Controle de saldos de terceiros", saldoTerceiros);

        String retencoesTransgenia = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[4]")).getText();
        assertEquals("Controle de retenções e transgenia", retencoesTransgenia);

        String analiseExposicao = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]")).getText();
        assertEquals("Análise de exposição", analiseExposicao);

        String servicosPrestados = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]")).getText();
        assertEquals("Controle de serviços prestados", servicosPrestados);

    }

    @After
    public void Encerrar() {
        Driver.FecharDriver();
    }
}
