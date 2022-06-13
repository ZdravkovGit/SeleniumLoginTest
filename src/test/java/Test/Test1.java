package Test;

import Base.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends BasePage {

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        //beforemethod ce se iskoristiti pre svakog testa, tj metode
    }

    @AfterMethod
    public void AfterMethod() {
        driver.manage().deleteAllCookies();
        //u aftermetodi stavljamo stvario koje hocemo da se dese izmedju svake metode (tj posle svake pre pocetka naredne)
    }

    @Test
    public void PozitivnoTestiranje() throws InterruptedException {
        loginpagePage.getUsername().sendKeys("tomsmith");
        loginpagePage.getPassword().sendKeys("SuperSecretPassword!");
        loginpagePage.clickOnLogginButton();
        Thread.sleep(500);
        Assert.assertTrue(logoutPage.getLoggedinMessage().isDisplayed());
        logoutPage.clickLogoutButton();
        Thread.sleep(500);
        Assert.assertTrue(loginpagePage.getPositiveNotification().isDisplayed());
        Assert.assertEquals(loginpagePage.getPositiveNotification().getText(),"You logged out of the secure area!\n" +
                "×");
        //testiranje happy flow, da li je prikazana poruka za uspesno logovanje, takodje da li je prikazana uspesna poruka za uspesno loggoutovanje

    }

    @Test
    public void TestiranjeSaInvalidUsername() throws InterruptedException {
        loginpagePage.getUsername().sendKeys("dragoljub");
        loginpagePage.getPassword().sendKeys("SuperSecretPassword!");
        loginpagePage.clickOnLogginButton();
        Thread.sleep(500);
        Assert.assertTrue(loginpagePage.getNegativeNotificationError().isDisplayed());
        Assert.assertEquals(loginpagePage.getNegativeNotificationError().getText(),"Your username is invalid!\n" +
                "×");

        //testiranje sa neispravnim username, tesriranje da li se poruka ispise da je username neispravan
    }

    @Test
    public void TestiranjeSaInvalidPass() throws InterruptedException {
        loginpagePage.getUsername().sendKeys("tomsmith");
        loginpagePage.getPassword().sendKeys("supersecretpassword*!");
        loginpagePage.clickOnLogginButton();
        Thread.sleep(500);
        Assert.assertTrue(loginpagePage.getNegativeNotificationError().isDisplayed());
        Assert.assertEquals(loginpagePage.getNegativeNotificationError().getText(),"Your password is invalid!\n" +
                "×");
        //testiranje sa neispravnim username, tesriranje da li se poruka ispise da je password neispravan
    }

    @Test
    public void TestiranjeSaNeispravnimPodacima() throws InterruptedException {
        loginpagePage.getUsername().sendKeys("tomssmith");
        loginpagePage.getPassword().sendKeys("supersecretpassword*!");
        loginpagePage.clickOnLogginButton();
        Thread.sleep(1000);
        Assert.assertTrue(loginpagePage.getNegativeNotificationError().isDisplayed());
        Assert.assertEquals(loginpagePage.getNegativeNotificationError().getText(),"Your username is invalid!\n" +
                "×");

        boolean check = false;

        try {
            check = logoutPage.getLoggedinMessage().isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(check); //Testiramo da li se pojavila notifikacija za uspesno prijavljivanje (nije se pojavila kao sto ni ne treba)
    }
    @Test
    public void LoggedinNakonRefresh() throws InterruptedException {
        loginpagePage.getUsername().sendKeys("tomsmith");
        loginpagePage.getPassword().sendKeys("SuperSecretPassword!");
        loginpagePage.clickOnLogginButton();
        Thread.sleep(500);
        Assert.assertTrue(logoutPage.getLoggedinMessage().isDisplayed());
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertTrue(logoutPage.getLogOutButton().isDisplayed());
        //testrianje da li je korisnik i dalje prijavljen nakon refresh stranice



    }

}
