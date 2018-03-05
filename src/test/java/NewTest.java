import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NewTest {

    private WebDriver driver;
    protected DesiredCapabilities capabilities;
    @BeforeTest
    public void beforeTest() throws Exception {
//        driver = new FirefoxDriver();
//        driver = new ChromeDriver();

        capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        System.setProperty("webdriver.chrome.driver", getClass().getResource("/chromedriver.exe").getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();

        driver.get("http://www.baidu.com");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void f()
    {
        System.out.println("heloo");
        By inputBox = By.id("kw");
        By searchButton = By.id("su");

        //智能等待元素加载出来
        intelligentWait(driver, 10, inputBox);
        //智能等待元素加载出来
        intelligentWait(driver, 10, searchButton);
        driver.findElement(inputBox).sendKeys("中国");
        driver.findElement(searchButton).click();

    }


    /**这是智能等待元素加载的方法*/
    public void intelligentWait(WebDriver driver,int timeOut, final By by) {
        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(by);
                    return element.isDisplayed();
                }
            });


        } catch (TimeoutException e) {
            Assert.fail("超时L !! " + timeOut + " 秒之后还没找到元素 [" + by + "]", e);
        }
    }
}