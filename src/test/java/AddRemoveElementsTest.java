import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addRemoveElementsTest() {
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        List<WebElement> deleteButtonsBefore = driver.findElements(By.xpath("//button[text()='Delete']"));
        assertEquals(deleteButtonsBefore.size(), 2);
        deleteButtonsBefore.get(1).click();
        List<WebElement> deleteButtonsAfter = driver.findElements(By.xpath("//button[text()='Delete']"));
        assertEquals(deleteButtonsAfter.size(), 1);
    }
}
