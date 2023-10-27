package test.T03;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

@Test
public class ShoppingCartVerification {
    public static void testValidQuantity() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//h2[a[text()='Sony Xperia']]/following-sibling::div/button"));
        addToCartButton.click();

        WebElement quantityInput = driver.findElement(By.xpath("//input[contains(@name, 'qty')]"));
        quantityInput.clear();
        quantityInput.sendKeys("1000");
        WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']"));
        updateButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(), 'The requested quantity for')]"));
        String expectedErrorMessage = "The requested quantity for \"Sony Xperia\" is not available.";
        if (errorMessage.getText().equals(expectedErrorMessage)) {
            System.out.println("Error message is displayed correctly.");
        } else {
            System.out.println("Error message is not displayed correctly.");
        }

        driver.quit();
    }
}
