import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest() {
        driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.findElement(By.id("checkbox"));
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        assertTrue(driver.findElements(By.id("checkbox")).isEmpty(), "Checkbox should not be displayed");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        assertFalse(driver.findElement(By.tagName("input")).isEnabled(), "Input should be disabled");
        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(driver.findElement(By.tagName("input")).isEnabled(), "Input should be enabled");
    }
}
