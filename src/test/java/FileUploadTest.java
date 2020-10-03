import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:/projects/HerokuApp/src/test/resources/bug.jpg");
        driver.findElement(By.id("file-submit")).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        String actualResult = driver.findElement(By.id("uploaded-files")).getText();
        String expectedResult = "bug.jpg";
        assertEquals(actualResult, expectedResult, "File name should be " + expectedResult);
    }
}
