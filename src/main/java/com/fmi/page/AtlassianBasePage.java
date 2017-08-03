package com.fmi.page;

import com.fmi.util.TestConf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by juan.hernandez on 8/3/17.
 */
public class AtlassianBasePage {

    private static final TestConf TEST_CONF = TestConf.getTestConf();
    private static WebDriver driver;



    @FindBy(css = "input[type=email]")
    WebElement email;

    @FindBy(css = "button#login-submit")
    WebElement nextButton;


    public AtlassianBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEST_CONF.getAjaxWaitSeconds()), this);
    }

    public static AtlassianBasePage loadUsing(WebDriver driver){
        driver.get(TEST_CONF.getSearchUrl());
        return new AtlassianBasePage(driver);
    }

    public AtlassianBasePage setEmail(){
        email.sendKeys(TEST_CONF.getEmail());
        return this;
    }

    public LoginPage pressNext(){
        nextButton.click();
        return new LoginPage(driver);
    }




}
