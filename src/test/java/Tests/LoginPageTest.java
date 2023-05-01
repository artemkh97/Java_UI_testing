package Tests;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class LoginPageTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void driver() {
        System.setProperty("webdriven.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void firstTestCase() {
        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Megan");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Smith");

        WebElement emailForm = driver.findElement(By.id("userEmail"));
        emailForm.sendKeys("megantopgirl@yahoo.irl");

        WebElement genderSelector = driver.findElement(By.id("gender-radio-2"));
        genderSelector.click();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("+543576545");

        WebElement datePicker = driver.findElement(By.id("dateOfBirthInput"));
        datePicker.clear();
        datePicker.sendKeys("03 Mar 1991");

        WebElement hobbiesSelector = driver.findElement(By.id("hobbies-checkbox-1"));
        hobbiesSelector.click();

        WebElement addressInput = driver.findElement(By.id("currentAddress"));
        addressInput.sendKeys("34 West South str.");
    }

    @Test
    public void secondTestCase() {
        String url = "https://demoqa.com/checkbox";
        driver.get(url);

        WebElement expandAll = driver.findElement(By.className("rct-icon-expand-close"));
        expandAll.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]")));
//        select all from downloads
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]")).click();

//        select angular
//        select Documents -> Workspace -> angular
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")).click();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")));
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span")));
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span")).click();
    }

    @Test
    public void thirdTestCase() {
        String url = "https://demoqa.com/webtables";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement table = driver.findElement(By.className("rt-tbody"));
        List<WebElement> rows = table.findElements(By.className("rt-tr-group"));

        for (WebElement row : rows){
            for (int i = 1; i < 3; i++){
            WebElement firstName = row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div["+ i + "]/div/div[1]"));
            if(firstName.getText().equals("Cierra")) {
                WebElement rightButton = table.findElement(By.id("edit-record-"+ i));
                rightButton.click();
                wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("modal-content")));
                WebElement lastNameInput = driver.findElement(By.id("firstName"));
                lastNameInput.clear();
                lastNameInput.sendKeys("New_surname");
                WebElement submitButton = driver.findElement(By.id("submit"));
                submitButton.click();
                break;
            }
            }
        }
    }

    @Test
    public void fourthTestCase() {
        String url = "https://demoqa.com/webtables";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement addNewRecord = driver.findElement(By.id("addNewRecordButton"));
        addNewRecord.click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("modal-content")));

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Megan");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Smith");

        WebElement emailForm = driver.findElement(By.id("userEmail"));
        emailForm.sendKeys("megantopgirl@yahoo.irl");

        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("27");

        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("2500");

        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys("HR Operations");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    @Test
    public void fifthTest() {
        String url = "https://demoqa.com/webtables";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement table = driver.findElement(By.className("rt-tbody"));
        List<WebElement> rows = table.findElements(By.className("rt-tr-group"));

        for (WebElement row : rows) {
            for (int i = 1; i < 3; i++) {
                WebElement emailAddress = row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[" + i + "]/div/div[4]"));
                if (emailAddress.getText().equals("alden@example.com")) {
                    WebElement deleteButton = table.findElement(By.id("delete-record-" + i));
                    deleteButton.click();

        String emailAddressString = emailAddress.getText();
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delete-record-2")));
                }
            }
        }
    }



    @AfterEach
    public void closeBrowser() {
        driver.close();
    }



}
