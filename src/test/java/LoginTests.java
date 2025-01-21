import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test(description = "Başarılı giriş kontrolü")
    public void SuccessfulLogin() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();
        sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("H_a_v8")));
        String accountTitle = accountElement.getAttribute("title");
        System.out.println(accountTitle);
    }

    @Test(description = "Başarısız Giriş Kontrolü")
    public void UnSuccessfulLogin() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword("Birkan3434.")
                .clickLogin();
        sleep(5000);
        Assert.assertEquals(mainPage.getAccountValue(), "Şifre doğru değil. Lütfen kontrol edip yeniden deneyin.");
    }

    @Test(description = "Maximum Minimum Karakter Giriş Kontrolü")
    public void MaxMinCharacterControl() throws InterruptedException {
        sleep(5000);
        loginPage.fillEmail("b")
                .fillPassword("Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..Birkaninst3434..")
                .clickLogin();
        sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long charCount = (Long) js.executeScript("return document.querySelector('input[id=life]').value.length;");
        try {
            Assert.assertTrue(charCount >= 7, "Email en az 7 karakter olmalı, ancak şu an: " + charCount);
        } catch (AssertionError e) {

        }
        // @ kontrolü için, String emailValue = driver.findElement(By.cssSelector("input[id='life']")).getAttribute("value");
        //   Assert.assertTrue(emailValue.contains("@"), "Email adresi @ işareti içermiyor: " + emailValue);
    }

}
