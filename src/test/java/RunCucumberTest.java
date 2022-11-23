
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"MagicPinLogin.feature", "MagicPinUsers.feature","MagicPinAdvertisement.feature"},
        glue = {"LoginStepDef.java","UsersStepDef.java","AdvertisementStepDef.java"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {



}