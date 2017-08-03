package com.fmi;

import com.fmi.page.AtlassianBasePage;
import com.fmi.page.LoginPage;
import com.fmi.util.TestConf;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by juan.hernandez on 8/3/17.
 */
public class SearchSteps {

    private WebDriver driver;
    private Object currentPage;

    @Before({"@requires_browser"})
    public void buildDriver(){
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Given("^a JIRA search page$")
    public void a_JIRA_search_page() throws Throwable {
        currentPage = AtlassianBasePage.loadUsing(driver);
        ((AtlassianBasePage)currentPage).setEmail();
        currentPage = ((AtlassianBasePage)currentPage).pressNext();
        ((LoginPage)currentPage).login();
    }

    @When("^I enter the search term \"(.*?)\"Medical Reporting (\\d+)\\.(\\d+)\"(.*?)\"Sprint (\\d+) - Gene U \\((\\d+)/(\\d+)-(\\d+)/(\\d+)\\)\"(.*?)\"$")
    public void i_enter_the_search_term_Medical_Reporting_Sprint_Gene_U(String arg1, int arg2, int arg3, String arg4, int arg5, int arg6, int arg7, int arg8, int arg9, String arg10) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^results should be retrieved$")
    public void results_should_be_retrieved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
