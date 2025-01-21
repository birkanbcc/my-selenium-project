package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

    @Step("E-posta alanı doldurulur")
    public LoginPage fillEmail(String text) {
        driver.findElement(By.cssSelector("input[id='life']")).sendKeys(text);
        return this;

    }

    @Step("Parola alanı doldurulur")
    public LoginPage fillPassword(String text) {
        driver.findElement(By.cssSelector("input[name='lifp']")).sendKeys(text);
        return this;
    }
@Step("Login butonuna tıklanır")
    public LoginPage clickLogin(){
        driver.findElement(By.cssSelector("input[value='Giriş yap']")).click();
        return this;
    }

}
