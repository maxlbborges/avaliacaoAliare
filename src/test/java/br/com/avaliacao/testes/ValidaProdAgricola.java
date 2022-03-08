//Classe relacionada ao CT05
package br.com.avaliacao.testes;

import br.com.avaliacao.resources.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;



public class ValidaProdAgricola {
    private WebDriver browser;

    @Before
    public void PreReq() {
        browser = Driver.AbrirDriver();
        Driver.SetupDriver(browser);
        browser.manage().window().maximize();
        browser.findElement(By.linkText("Produtor agrícola")).click();
    }

    @Test
    public void ValidarSegmentoAtivo() {
        //Valida título do segmento selecionado
        String validaSegmento = browser.findElement(By.className("seg-6")).getText();
        assertEquals("Produtor agrícola", validaSegmento);

    }
    //CT05.1
    @Test
    public void ValidaBanner(){
        // Validar que o elemento cujo título está impresso existe e está com o título correto
        browser.findElement(By.linkText("Produtor agrícola")).click();
        String tituloBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("h2")).getText();
        assertEquals("Softwares de gestão para produtores de grãos e algodão", tituloBanner);

        //Validar que o elemento cuja descrição está impressa existe e está com a descrição correta
        String descBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("p")).getText();
        assertEquals("Gestão do planejamento da safra à contabilidade. Com o Grupo Siagri você gerencia seu" +
                " negócio de ponta a ponta, centralizando a gestão administrativa, financeira, fiscal e operacional.", descBanner);

        //Validar a abertura do formulário
        browser.findElement(By.className("form-open")).click();
        String tituloForm = browser.findElement(By.className("modal-form-body")).findElement(By.tagName("h4")).getText();
        assertEquals("Solicite demonstração das nossas soluções.", tituloForm);

    }
    //CT5.2
    @Test
    public void validaDesafios(){
        // Encontrar os Desafios do Segmento e então encontrar e validar os itens
        browser.findElement(By.linkText("Produtor agrícola")).click();
        String planSafra = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]")).getText();
        assertEquals("Planejamento de safra", planSafra);

        String gestEstoque = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]")).getText();
        assertEquals("Gestão de estoque (armazenagem)", gestEstoque);

        String controleCustos = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]")).getText();
        assertEquals("Controle de custos", controleCustos);

        String processos = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[9]")).getText();
        assertEquals("Padronização de processos", processos);

        String gestOrcamentaria = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]")).getText();
        assertEquals("Gestão orçamentária", gestOrcamentaria);

    }

    @After
    public void Encerrar() {
        Driver.FecharDriver();
    }
}
