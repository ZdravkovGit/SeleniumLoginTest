package Base;

import Pages.LoginPage;
import Pages.LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginpagePage;
    public LogoutPage logoutPage;

    //U ovom delu BasePage-a dodajemo potrebne elemente, stranice (u ovom slucaju loginpagepage (objekat u ovoj klasi)),
    // kao i dodavanje drajvera (driver,wdwait).

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginpagePage = new LoginPage(driver,wdwait);
        logoutPage = new LogoutPage(driver,wdwait);

        //u BeforeClassi definisemo objekte (druge stranice) kao i definisanje drajvera, jer beforeclass antonacija se koristi
        //za sve elemente koji se ukljucuju pre ostalih klasa i metoda
    }

    @AfterClass
    public void AfterClass() {

        driver.close();
        driver.quit();
        //afterclass antonacija ce se iskorititi jednom (na kraju) kada se izvrse svi testovi
    }
}

