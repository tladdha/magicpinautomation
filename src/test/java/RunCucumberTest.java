import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"01_MagicPinLogin.feature","02_MagicPinUsers.feature","03_MagicPinAdvertisement.feature"},
        glue = {"LoginStepDef.java","UsersStepDef.java","AdvertisementStepDef.java"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {



}