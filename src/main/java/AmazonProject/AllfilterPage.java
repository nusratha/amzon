package AmazonProject;

import java.util.ArrayList;
import drivers.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;

public class AllfilterPage {
    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    WebElement allfilterdropdownbutton;
    @FindBy(xpath = "//div[text()='shop by department']")
    WebElement shopbydepartmentheading;
    @FindBy(xpath = "//div[text()='TV, Appliances, Electronics']")
    WebElement tvelectronicbutton;
    @FindBy(xpath = "//div[text()='tv, audio & cameras']")
    WebElement tvaudiocameraheading;
    @FindBy(linkText = "Televisions")
    WebElement televisionbutton;
    @FindBy(xpath = "//span[text()='Brands']")
    WebElement brandsheading;
    @FindBy(xpath = "//span[text()='Samsung']")
    WebElement samsungbutton;
    @FindBy(xpath = "//span[@class='a-button a-button-dropdown a-button-small']")
    WebElement sortdropdownbutton;
    @FindBy(xpath = "//a[text()='Price: High to Low']")
    WebElement hightolowbutton;
    @FindBy(xpath = "//span[contains(text(),'Samsung 214 cm (85 inches) 4')]")
    WebElement secondhighestitembutton;
    @FindBy(xpath = "//h1[text()=' About this item ']")
    WebElement aboutthisitemheading;

    public AllfilterPage() { PageFactory.initElements(utilities.driver, this);}

    public void launchAmazonPage()
    {
        utilities.driver = new ChromeDriver();
        utilities.driver.get("https://www.amazon.in/");
        utilities.driver.manage().window().maximize();
        System.out.println("Page Title is :" + utilities.driver.getTitle() );
    }

    public void navigateToAllFilter() throws InterruptedException {

        Thread.sleep(2000);
        utilities.driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
        utilities.driver.findElement(By.xpath("//div[text()='shop by department']")).isDisplayed();
        Thread.sleep(2000);
        utilities.driver.findElement(By.xpath("//div[text()='TV, Appliances, Electronics']")).click();
        utilities.driver.findElement(By.xpath("//div[text()='tv, audio & cameras']")).isDisplayed();
        Thread.sleep(2000);
        utilities.driver.findElement(By.linkText("Televisions")).click();
        utilities.driver.findElement(By.xpath("//span[text()='Brands']")).isDisplayed();
        Thread.sleep(2000);
        utilities.driver.findElement(By.xpath("//span[text()='Samsung']")).click();
        utilities.driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown a-button-small']")).click();
        Thread.sleep(2000);
        utilities.driver.findElement(By.xpath("//a[text()='Price: High to Low']")).click();
        Thread.sleep(2000);
        // Keys.Chord string
        String clickl = Keys.chord(Keys.CONTROL,Keys.ENTER);

        // open the link in new tab, Keys.Chord string passed to sendKeys
        utilities.driver.findElement(By.xpath("//span[contains(text(),'Samsung 214 cm (85 inches) 4')]")).click();
        Thread.sleep(2000);

        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(utilities.driver.getWindowHandles());
        //switch to new tab
        utilities.driver.switchTo().window(newTb.get(1));

        System.out.println("Page title of new tab: " + utilities.driver.getTitle());

        String actualString = utilities.driver.findElement(By.xpath("//h1[text()=' About this item ']")).getText();
        String expectedString = "About this item";
        Assert.assertEquals(actualString, expectedString);
        System.out.println("Actual String :" +actualString);
        System.out.println("Expected String :" + expectedString);

//        allfilterdropdownbutton.click();
//        Thread.sleep(2000);
//        shopbydepartmentheading.isDisplayed();
//        Thread.sleep(2000);
//        tvelectronicbutton.click();
//        Thread.sleep(2000);
//        tvaudiocameraheading.isDisplayed();
//        Thread.sleep(2000);
//        televisionbutton.click();
//        Thread.sleep(2000);
//        brandsheading.isDisplayed();
//        Thread.sleep(2000);
//        samsungbutton.click();
//        Thread.sleep(2000);
//        sortdropdownbutton.click();
//        Thread.sleep(2000);
//        hightolowbutton.click();
//        Thread.sleep(2000);

//        // Keys.Chord string
//        String clickl = Keys.chord(Keys.CONTROL,Keys.ENTER);
//
//        // open the link in new tab, Keys.Chord string passed to sendKeys
//        secondhighestitembutton.click();
//        Thread.sleep(2000);
//
//        // hold all window handles in array list
//        ArrayList<String> newTb = new ArrayList<String>(utilities.driver.getWindowHandles());
//        //switch to new tab
//        utilities.driver.switchTo().window(newTb.get(1));
//
//        System.out.println("Page title of new tab: " + utilities.driver.getTitle());
//
//        String actualString = aboutthisitemheading.getText();
//        String expectedString = "About this item";
//        Assert.assertEquals(actualString, expectedString);

    }
}
