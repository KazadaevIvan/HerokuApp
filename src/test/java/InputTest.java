import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InputTest extends BaseTest {

    @Test
    public void inputTest() {
        driver.findElement(By.linkText("Inputs")).click();
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("2");
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "3");
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "2");
        input.sendKeys("a");
        assertEquals(input.getAttribute("value"), "2");
    }
}
