import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {

    @Test
    public void TyposTest() {
        driver.findElement(By.linkText("Typos")).click();
        String actualResult = driver.findElement(By.xpath("//*[@id='content']/div/p[2]")).getText();
        String expectedResult = "Sometimes you'll see a typo, other times you won't";
        assertEquals(actualResult, expectedResult);
    }
}
