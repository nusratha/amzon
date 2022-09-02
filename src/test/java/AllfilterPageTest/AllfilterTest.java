package AllfilterPageTest;

import AmazonProject.AllfilterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import drivers.utilities;

public class AllfilterTest extends AllfilterPage {

    @BeforeMethod
    void setUp()  {
        launchAmazonPage();
    }
    @Test
    public void validateFilterPage() throws InterruptedException {
        navigateToAllFilter();
    }
    @AfterTest
    void testTeardown()
    {
//        utilities.driver.close();
        utilities.driver.quit();
    }
    }

