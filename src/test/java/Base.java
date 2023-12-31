import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

    protected WebDriver driver;
    protected final String URL = "https://www.wikipedia.org/";
    protected final String PRECISE_TEXT_XPATH = "//*[text()='%s']";
    protected final String PARTICULAR_TEXT_XPATH = "//*[contains(text(),'%s')]";
    protected final String RELATIVE_RESOURCE_PATH = "src/test/resources/";

   //time to display element
   public void waitMethod()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown()
    {
        //wait some time to close the window
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
