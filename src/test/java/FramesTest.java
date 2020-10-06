import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Test
    public void framesTest() {
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String actualResult = driver.findElement(By.id("tinymce")).getText();
        String expectedResult = "Your content goes here.";
        assertEquals(actualResult, expectedResult, "Text should be " + expectedResult);
    }
}
