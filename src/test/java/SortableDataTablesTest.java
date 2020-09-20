import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortableDataTablesTest extends BaseTest{

    @Test
    public void SortableDataTablesTest() {
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        WebElement lastNameColumn = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        assertEquals(lastNameColumn.getText(),"Smith");
        WebElement firstNameColumn = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        assertEquals(firstNameColumn.getText(),"John");
        WebElement emailColumn = driver.findElement(By.xpath("//table//tr[1]//td[3]"));
        assertEquals(emailColumn.getText(),"jsmith@gmail.com");
    }
}
