package online.tekwillacademy;

import online.tekwillacademy.managers.DataGeneratorManager;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        System.out.println("The current Page Title is: " + driver.getTitle());

        WebElement userDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        userDropDownIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        System.out.println("The current Page Title is: " + driver.getTitle());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("Alex");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Smith");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = DataGeneratorManager.getRandomEmail();
        emailInput.sendKeys(emailData);
        System.out.println("Email:" + emailData);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("Mypass123@");

        WebElement privacyToggle = driver.findElement(By.xpath("//input[@name='agree']"));
        ScrollManager.scrollToElement(privacyToggle);
        privacyToggle.click();

        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        ScrollManager.scrollToElement(continueButton);
        continueButton.click();

        Thread.sleep(5000);

        driver.close();

        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://tekwillacademy-opencart.online/index.php?route=product/product&language=en-gb&product_id=42");
        Thread.sleep(10000);
        driver.quit();

        System.out.println("The driver is closed!");
    }
}