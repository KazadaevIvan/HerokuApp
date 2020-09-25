import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdownTest() {
        driver.findElement(By.linkText("Dropdown")).click();
        Select dropdownList = new Select(driver.findElement(By.tagName("select")));
        List<WebElement> options = dropdownList.getOptions();
        for (int i = 1; i < options.size(); i++) {
            dropdownList.selectByIndex(i);
            assertTrue(options.get(i).isSelected(), "Element '" + options.get(i).getText() + "' should be selected");
        }
    }
}
