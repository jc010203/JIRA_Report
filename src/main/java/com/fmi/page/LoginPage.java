package com.fmi.page;

import com.fmi.util.TestConf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by juan.hernandez on 8/3/17.
 */
public class LoginPage {

    private WebDriver driver;
    private static final TestConf TEST_CONF = TestConf.getTestConf();

    @FindBy(css = "#okta-signin-username")
    WebElement username;

    @FindBy(css = "#okta-signin-password")
    WebElement password;

    @FindBy(css = "#okta-signin-submit")
    WebElement submit;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
        new WebDriverWait(driver, TEST_CONF.getAjaxWaitSeconds())
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#okta-signin-username")));
    }

    public void login(){
        username.sendKeys(TEST_CONF.getUserName());
        password.sendKeys(TEST_CONF.getPassword());
        submit.click();
    }


}
