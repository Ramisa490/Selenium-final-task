import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Download extends Main_Page
{
    String files= "Albert_Einstein.pdf";
    //span[@class='oo-ui-labelElement-label']
    protected final String file = "//span[@class='oo-ui-labelElement-label']";
@Test
public  void download_file()
{
    driver.findElement(By.xpath(file)).click();
}
}
