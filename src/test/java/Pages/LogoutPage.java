package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement loginMessage;
    WebElement logOutButton;

    public LogoutPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
    }

    public WebElement getLoggedinMessage() {
        return driver.findElement(By.cssSelector(".flash.success"));
        //getter za poruku za uspesno prijavljivanje, kako bi mogli da asertujemo da li se poruka prikazuje
    }
    public void clickLogoutButton() {
         driver.findElement(By.cssSelector(".icon-2x.icon-signout")).click();
    }
}
