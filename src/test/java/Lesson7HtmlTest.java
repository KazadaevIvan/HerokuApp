import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Lesson7HtmlTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("file:///Users/kazadaevivan/IdeaProjects/HerokuApp/src/test/resources/Lesson7.html");

    }

    @Test
    public void dataShouldBeFoundInTable() {
        WebElement firstNameColumn = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]"));
        assertEquals(firstNameColumn.getText(), "Иван");
        WebElement lastNameColumn = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        assertEquals(lastNameColumn.getText(), "Иванов");
        WebElement emailColumn = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
        assertEquals(emailColumn.getText(), "i.ivanov@mail.ru");
    }

    @Test
    public void inputShouldBeFilled() {
        WebElement input = driver.findElement(By.id("input"));
        input.sendKeys("Hello world");
    }

    @Test
    public void checkboxShouldBeSelected() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
        checkboxes.get(2).click();
        assertTrue(checkboxes.get(2).isSelected(), "Third checkbox should be selected");
    }

    @Test
    public void dropdownMenuOptionShouldBeSelected() {
        Select dropdownList = new Select(driver.findElement(By.tagName("select")));
        List<WebElement> options = dropdownList.getOptions();
        dropdownList.selectByIndex(2);
        assertTrue(options.get(2).isSelected(), "Element '" + options.get(2).getText() + "' should be selected");
    }

    @Test
    public void buttonShouldBeClicked() {
        WebElement button = driver.findElement(By.id("click_me_button"));
        button.click();
    }

    @Test
    public void imageShouldBeDisplayed() {
        WebElement image = driver.findElement(By.tagName("img"));
        assertTrue(image.isDisplayed(), "Image should be Displayed");
    }

    @Test
    public void linkShouldBeClicked() {
        WebElement link = driver.findElement(By.id("info_link"));
        link.click();
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "http://www.google.com/";
        assertEquals(actualResult, expectedResult, "URL should be " + expectedResult);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
