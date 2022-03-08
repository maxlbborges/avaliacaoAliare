//Classe Relacionada ao CT02
package br.com.avaliacao.testes;

import br.com.avaliacao.resources.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class ValidaDistInsumos {
    private WebDriver browser;

    @Before
    public void PreReq() {
        browser = Driver.AbrirDriver();
        Driver.SetupDriver(browser);
        browser.manage().window().maximize();
    }

    @Test
    public void ValidarSegmentoAtivo() {
        //Valida título do segmento selecionado
        String validaSegmento = browser.findElement(By.className("seg-3")).getText();
        assertEquals("Distribuidor de insumos", validaSegmento);

    }
    //CT02.1
    @Test
    public void ValidaBanner(){
        // Validar que o elemento cujo título está impresso existe e está com o título correto
        String tituloBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("h2")).getText();
        assertEquals("Softwares para gestão de distribuidores de insumos agrícolas", tituloBanner);

        //Validar que o elemento cuja descrição está impressa existe e está com a descrição correta
        String descBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("p")).getText();
        assertEquals("Otimize processos, reduza desperdícios e tenha o controle de suas lojas em qualquer" +
                " hora e lugar. Com o Grupo Siagri, você compra melhor, evita perdas no estoque, vende com " +
                "mais eficiência e ainda tem mais segurança nas operações de Barter!", descBanner);

        //Validar a abertura do formulário
        browser.findElement(By.className("form-open")).click();
        String tituloForm = browser.findElement(By.className("modal-form-body")).findElement(By.tagName("h4")).getText();
        assertEquals("Solicite demonstração das nossas soluções.", tituloForm);

    }
    //CT02.2
    @Test
    public void validaDesafios(){
        // Encontrar os Desafios do Segmento e então encontrar e validar os itens
        String estoque = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]")).getText();
        assertEquals("Estoque eficiente", estoque);

        String formacaoPrecos = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]")).getText();
        assertEquals("Formação de preços", formacaoPrecos);

        String gestLogistica = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]")).getText();
        assertEquals("Gestão de logística (expedição)", gestLogistica);

        String mixAtividades = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[8]")).getText();
        assertEquals("Ampliar mix de atividades (armazenagem, Barter etc)", mixAtividades);

        String gestOrcamentaria = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[10]")).getText();
        assertEquals("Gestão orçamentária", gestOrcamentaria);

    }

    @After
    public void Encerrar() {
        Driver.FecharDriver();
    }
}
