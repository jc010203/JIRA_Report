import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by juan.hernandez on 8/3/17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = "junit:target/junit.xml")
public class SearchTest {
}
