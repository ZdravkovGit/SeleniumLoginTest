package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
   public WebDriver driver;
   public WebDriverWait wdwait;

    //u ovom delu samo ubacujemo elemente sa stranice (username,password,loginbutton), i
    // kreiramo driver i wdwait kao i konstruktor za samo drajvere, (kako bi u objektu u base klasi postavili samo drajvere)
    //takodje pravimo gettere za webelemente, (username,pass,loginbutton), kako bi ih dohvatili u test klasi, takodje
    //menjamo default return svakog getera u html adresu tj path,id,klasu ili sta vec izaberemo

    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("radius"));
    }

    public void clickOnLogginButton() {
        getLoginButton().click();
    }

    public WebElement getNegativeNotificationError() {
        return driver.findElement(By.cssSelector(".flash.error")); //notifikacija koja se pojavi kada je neuspesno logovanje (zbog usernema ili passa)
    }

    public WebElement getPositiveNotification() {
        return driver.findElement(By.id("flash")); //notifikacija koja se pojavi kada je uspesno logoutovanje
    }

}
