import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HoversTest extends BaseTest {

    @Test
    public void HoversTest() {
        driver.findElement(By.linkText("Hovers")).click();
        int listSize = driver.findElements(By.className("figure")).size();
        Actions action = new Actions(driver);

        for (int i = 0; i < listSize; i++) {

            List<WebElement> images = driver.findElements(By.className("figure"));

            action.moveToElement(images.get(i)).perform();
            assertEquals(driver.findElement(By.xpath("//div[" + (i+1) + "]/div/h5")).getText(), "name: user" + (i+1));
            driver.findElement(By.linkText("View profile")).click();
            assertEquals(driver.findElement(By.tagName("h1")).getText(), "Not Found");
            driver.navigate().back();
        }
    }
}
