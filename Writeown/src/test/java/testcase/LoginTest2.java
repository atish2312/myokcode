package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage2;
import testbase.BaseClass;

public class LoginTest2 extends BaseClass {
    @Test(groups = {"smoke"})
    public void loginPageTest2(){
        Assert.fail();
        LoginPage2 loginPage2 = new LoginPage2(driver);
        loginPage2.txtPassword().sendKeys("kumar");
        Assert.assertEquals(loginPage2.txtPassword().getAttribute("value"),"Atish");

    }
}
