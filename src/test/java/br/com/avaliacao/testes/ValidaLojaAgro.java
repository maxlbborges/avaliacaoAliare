//Classe relacionada ao CT03
package br.com.avaliacao.testes;

import br.com.avaliacao.resources.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;



public class ValidaLojaAgro {
        private WebDriver browser;

        @Before
        public void PreReq() {
            browser = Driver.AbrirDriver();
            Driver.SetupDriver(browser);
            browser.manage().window().maximize();
            browser.findElement(By.linkText("Loja agropecuária")).click();
        }

        @Test
        public void ValidarSegmentoAtivo() {
             //Valida título do segmento selecionado
            String validaSegmento = browser.findElement(By.className("seg-4")).getText();
            assertEquals("Loja agropecuária", validaSegmento);

        }
        //CT03.1
        @Test
        public void ValidaBanner(){
            // Validar que o elemento cujo título está impresso existe e está com o título correto
            browser.findElement(By.linkText("Loja agropecuária")).click();
            String tituloBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.tagName("h2")).getText();
            assertEquals("Softwares para gestão de lojas e varejo agropecuário", tituloBanner);

            //Validar que o elemento cuja descrição está impressa existe e está com a descrição correta
            //Encontrar pela tagName nesse caso não funcionará uma vez que existem duas tags com esse nome, se faz necessário encontrar outro caminho.
            String descBanner = browser.findElement(By.id("segmentos-titulo")).findElement(By.xpath("//*[@id=\"segmentos-titulo\"]/div/div[1]/p[2]")).getText();
            assertEquals("Ganhe agilidade em vendas, confiança nos controles de " +
                    "estoque e custos. Fidelize seu cliente e gerencie sua loja agropecuária de forma " +
                    "completa com o software Siagri.", descBanner);

            //Validar a abertura do formulário
            browser.findElement(By.className("form-open")).click();
            String tituloForm = browser.findElement(By.className("modal-form-body")).findElement(By.tagName("h4")).getText();
            assertEquals("Solicite demonstração das nossas soluções.", tituloForm);

        }
        //CT03.2
        @Test
        public void validaDesafios(){
            // Encontrar os Desafios do Segmento e então encontrar e validar os itens
            browser.findElement(By.linkText("Loja agropecuária")).click();
            String atendimento = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[1]")).getText();
            assertEquals("Agilidade no atendimento", atendimento);

            String operacional = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[2]")).getText();
            assertEquals("Eficiência operacional", operacional);

            String comissionamento = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[3]")).getText();
            assertEquals("Controle de comissionamento", comissionamento);

            String conformidadeFiscal = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[5]")).getText();
            assertEquals("Conformidade fiscal", conformidadeFiscal);

            String fluxoCaixa = browser.findElement(By.className("segmentos-vantagens-grid")).findElement(By.xpath("//*[@id=\"segmentos-vantagens\"]/div/div[2]/div[6]")).getText();
            assertEquals("Eficiência no fluxo de caixa em dia", fluxoCaixa);

        }

        @After
        public void Encerrar() {
            Driver.FecharDriver();
        }
}
