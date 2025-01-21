package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    @Step("Şifre Hatası Kontrolü")
    public String getAccountValue(){
        screenshot();
        return driver.findElement(By.cssSelector("[class='alertX t2'] p")).getText();
    }
}
