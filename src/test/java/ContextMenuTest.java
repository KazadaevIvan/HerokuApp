import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.findElement(By.linkText("Context Menu")).click();
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        Alert alert = driver.switchTo().alert();
        String expectedResult = "You selected a context menu";
        assertEquals(alert.getText(), expectedResult, "Alert message should be " + expectedResult);
        alert.accept();
    }
}
