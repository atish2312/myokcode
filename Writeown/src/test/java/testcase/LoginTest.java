package testcase;

import org.testng.annotations.Test;
import pageobject.LoginPage;
import testbase.BaseClass;

public class LoginTest extends BaseClass {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.txtUsername().sendKeys("Atish");
    }
}
