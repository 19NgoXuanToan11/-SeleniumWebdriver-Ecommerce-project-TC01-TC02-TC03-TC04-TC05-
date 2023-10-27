package test.T01;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

@Test
public class loginForm {
    public static void testLoginForm() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/login");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement usernameElem = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#username"))));

            WebElement passwordElem = driver.findElement(By.cssSelector("#password"));

            WebElement loginBtnElem = driver.findElement(By.cssSelector("button[type='submit']"));

            usernameElem.sendKeys("admin");
            passwordElem.sendKeys("12345678");
            loginBtnElem.click();

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
