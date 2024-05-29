package online.tekwillacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public abstract class Page {

    public Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    protected WebElement userDropDownIcon;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    protected WebElement registerOption;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    protected WebElement loginOption;

    public void navigateToRegisterPage() {
        userDropDownIcon.click();
        registerOption.click();
        System.out.println("The Register Option was Selected!!!");
    }

    public void navigateToLoginBtn (){
        userDropDownIcon.click();
        loginOption.click();
    }

}
