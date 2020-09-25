import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkboxTest() {
        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        assertFalse(checkboxes.get(0).isSelected(), "First checkbox should NOT be selected");
        checkboxes.get(0).click();
        assertTrue(checkboxes.get(0).isSelected(), "First checkbox should be selected");
        assertTrue(checkboxes.get(1).isSelected(), "Second checkbox should be selected");
        checkboxes.get(1).click();
        assertFalse(checkboxes.get(1).isSelected(), "Second checkbox should NOT be selected");
    }
}
