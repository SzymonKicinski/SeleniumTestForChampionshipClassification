import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Twelfth {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("win") >= 0) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/resources/drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/java/resources/drivers/chromedriver");
        }
        driver = new ChromeDriver();
    }

    @Test
    public void parentsOkDoctorOkDate2011() {
        driver.get("https://lamp.ii.us.edu.pl/~mtdyd/zawody/");

        // Imie
        WebElement imie = driver.findElement(By.id("inputEmail3"));
        imie.sendKeys("Imie dzbana");
        // Nazwisko
        WebElement nazwisko = driver.findElement(By.id("inputPassword3"));
        nazwisko.sendKeys("Naziwkso dzbana");
        //Data
        WebElement data = driver.findElement(By.id("dataU"));
        data.sendKeys("18-07-2003");

        //Checkbox
        driver.findElement(By.id("rodzice")).click();
//        driver.findElement(By.id("lekarz")).click();

        // Click on button
//        List<WebElement> buttons = driver.findElements(By.cssSelector("input[type='button']"));
        WebElement button = driver.findElement(By.className("btn-default"));
        button.click();
        System.out.println("Dzban");
        // Klik ok on pop up
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        // Klasyfikacja
        WebElement klasyfikacja = driver.findElement(By.id("returnSt"));
        System.out.println(klasyfikacja.getText());
        assertTrue(klasyfikacja.getText().contains("do kategorii Blad danych"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
