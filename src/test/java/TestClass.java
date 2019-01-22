import Pages.Initial;
import Pages.Main;
import Pages.SignIn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
    private ChromeDriver driver;
    private String baseUrl = "http://192.168.1.56:9031/";

    Initial initial;
    SignIn signIn;
    Main main;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "normal");
        options.addArguments("start-maximized");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        initial= PageFactory.initElements(driver,Initial.class);
        signIn=PageFactory.initElements(driver,SignIn.class);
        main=PageFactory.initElements(driver,Main.class);

    }
    @Test
    public void Test() {
        Assert.assertEquals(true,true);
        initial.toSignPage();
        signIn.signin("admin@dgroops.com", "admin");

    }

    @AfterTest
    public void exit(){
        driver.quit();
    }
}