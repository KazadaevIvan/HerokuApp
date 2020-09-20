import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void NotificationMessagesTest() {
        driver.findElement(By.linkText("Notification Messages")).click();
        driver.findElement(By.linkText("Click here")).click();
        WebElement notification = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        assertEquals(notification.getText(), "Action successful\n" + "×");
    }
}
