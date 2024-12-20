package CURA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

  protected WebDriver driver;
  protected PageObjects page;

  @BeforeClass
  public void setup(){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--incognito");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();

    page = new PageObjects(driver);
  }

  @BeforeMethod
  public void refresh(){
    driver.manage().deleteAllCookies();
    driver.get("https://katalon-demo-cura.herokuapp.com/");
  }

  @AfterClass
  public void tearDown(){
    if(driver != null){
      driver.quit();
    }
  }

}
