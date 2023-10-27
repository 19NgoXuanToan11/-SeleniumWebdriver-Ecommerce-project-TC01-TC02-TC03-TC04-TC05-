package test.T02;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import java.util.List;

@Test
public class ProductPriceVerification {
    public void testProductPriceVerification() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();

        WebElement sonyXperia = driver.findElement(By.xpath("//a[text()='Sony Xperia']//following::span[@class='price']"));
        String costInListPage = sonyXperia.getText();

        driver.findElement(By.linkText("SONY XPERIA")).click();

        WebElement sonyXperiaDetail = driver.findElement(By.xpath("//h1[text()='Sony Xperia']/following::span[@class='price']"));
        String costInDetailPage = sonyXperiaDetail.getText();

        if (costInListPage.equals(costInDetailPage)) {
            System.out.println("Test Passed: Product cost on list page and detail page is equal.");
        } else {
            System.out.println("Test Failed: Product cost on list page and detail page is not equal.");
        }

        driver.quit();
    }
}
