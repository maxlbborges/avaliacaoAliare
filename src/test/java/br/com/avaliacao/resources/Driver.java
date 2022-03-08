package br.com.avaliacao.resources;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Driver {
    private  static WebDriver driver;

    Driver(){
    }

    public static WebDriver AbrirDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/br/com/avaliacao/resources/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        return driver;
    }

    public static void SetupDriver(WebDriver driver) {
        driver.get("https://www.siagri.com.br");
        //driver.manage().window().maximize();
        if(driver.findElement(By.className("navbar-toggler")).isDisplayed()){
            driver.findElement(By.className("navbar-toggler")).click();
            WebElement solucoes = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(new By.ByLinkText("Soluções")));
        }
        driver.findElement(By.linkText("Soluções")).click();
        driver.findElement(By.linkText("Segmentos")).click();
    }

    public static void FecharDriver(){
        driver.quit();
    }

}
