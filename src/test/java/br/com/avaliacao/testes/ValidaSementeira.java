//Classe relacionada ao CT06
package br.com.avaliacao.testes;

import br.com.avaliacao.resources.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;




public class ValidaSementeira {
    private WebDriver browser;

    @Before
    public void PreReq() {
        browser = Driver.AbrirDriver();
        Driver.SetupDriver(browser);
        browser.manage().window().maximize();
        browser.findElement(By.linkText("Sementeira")).click();
    }

    @Test
    public void ValidarSegmentoAtivo() {
        //Valida título do segmento selecionado
        String validaSegmento = browser.findElement(By.className("seg-7")).getText();
        assertEquals("Sementeira", validaSegmento);

    }
    //CT06.1
    @Test
    public void ValidaBanner(){
        // Validar que o elemento cujo título está impresso existe e está com o título correto
        browser.findElement(By.linkText("Sementeira")).click();
        String tituloBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("h2")).getText();
        assertEquals("Softwares para gestão de sementeiras", tituloBanner);

        //Validar que o elemento cuja descrição está impressa existe e está com a descrição correta
        String descBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("p")).getText();
        assertEquals("Ganhe eficiência no processo de beneficiamento de " +
                "sementes. Com as soluções Siagri, você gerencia desde o recebimento do grão, " +
                "até o embarque de sementes.", descBanner);

        //Validar a abertura do formulário
        browser.findElement(By.className("form-open")).click();
        String tituloForm = browser.findElement(By.className("modal-form-body")).findElement(By.tagName("h4")).getText();
        assertEquals("Solicite demonstração das nossas soluções.", tituloForm);

    }
    //CT6.2
    @Test
    public void validaDesafios(){
        // Encontrar os Desafios do Segmento e então encontrar e validar os itens
        browser.findElement(By.linkText("Sementeira")).click();
        String gestSementes = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]")).getText();
        assertEquals("Gestão de recebimento, produção e expedição de sementes", gestSementes);

        String controleLotes = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]")).getText();
        assertEquals("Controle de lotes", controleLotes);

        String gestVenda = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]")).getText();
        assertEquals("Gestão de vendas das semente", gestVenda);

        String embarque = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[4]")).getText();
        assertEquals("Logística de embarque", embarque);

        String gestGraos = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]")).getText();
        assertEquals("Gestão da colheita e armazenagem de grãos", gestGraos);

    }

    @After
    public void Encerrar() {
        Driver.FecharDriver();
    }

}
