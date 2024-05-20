package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tekwillacademy-opencart.online/");
        driver.close();

        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://tekwillacademy-opencart.online/index.php?route=product/product&language=en-gb&product_id=42");
        driver.quit();

        System.out.println("The driver is closed!");
    }
}