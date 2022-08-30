import com.mp.admin.LoginStepDef;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/features/MagicPinLogin.feature",
        glue = {"LoginStepDef.java"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {



}
