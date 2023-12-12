import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;


public class Main_Page extends Base
{
    String name = "Albert Einstein";
    String files= "Albert_Einstein.pdf";
    private final String Text = "searchInput";

    private final String search = "//i[contains(@class, 'sprite') and text()='Search']";

    private final String tool = "vector-page-tools-dropdown-checkbox";

    private final String download = "//span[text()='Download as PDF']";

    protected final String file = "//span[@class='oo-ui-labelElement-label']";

    protected final String specificfile = String.format(PRECISE_TEXT_XPATH,files);
    protected final String filepath = String.format(RELATIVE_RESOURCE_PATH+specificfile);

    protected final File downloadedfile= new File(filepath);

    protected final String filename= "//div[@class='mw-electronpdfservice-selection-label-desc']";

    @Test
    public void test()
    {
        WebElement inputfield = driver.findElement(By.id(Text));
        inputfield.sendKeys("Albert Einstein");
        Assert.assertEquals(inputfield.getAttribute("value"),name,"Text is not displayed"); // check if the text we input is displayed

        driver.findElement(By.xpath(search)).click();
        driver.findElement(By.id(tool)).click();
        waitMethod();
        WebElement clickable = driver.findElement(By.xpath(download));
        Assert.assertNotNull(clickable, "Element is not present");// check if the element in tools is present
        Assert.assertTrue(clickable.isEnabled(), "Element is not clickable");  // check if the element is enabled (clickable)
        clickable.click();

        driver.findElement(By.xpath(file)).click();
        WebElement element = driver.findElement(By.xpath(specificfile));
        Assert.assertTrue(element.isDisplayed(), "File is not Displayed"); // check if the file is displayed
        Assert.assertFalse(downloadedfile.exists(),"File is not exists"); // check if the file is exits

        WebElement e = driver.findElement(By.xpath(filename));
        Assert.assertEquals(e.getText(),files,"File is incorrect"); // check if the name of file and displayed text is matched

    }
}

