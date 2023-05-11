package Tests;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.List;
public class LoginPageTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void driver() {
        System.setProperty("webdriven.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
    }


    @Test
    public void firstTestCase() {
//        Task 1
//        Fill in all necessary fields, and submit the form.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Megan");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Smith");

        WebElement emailForm = driver.findElement(By.id("userEmail"));
        emailForm.sendKeys("megantopgirl@yahoo.irl");

        WebElement genderSelector = driver.findElement(By.cssSelector("[for='gender-radio-2']"));
        genderSelector.click();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("+543576545");

        wait.until(ExpectedConditions.elementToBeClickable(By.className("react-datepicker__input-container")));
        WebElement datePicker = driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        Select monthPicker = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        monthPicker.selectByValue("4");

        Select yearPicker = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        yearPicker.selectByValue("1988");

        WebElement chooseDate = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]"));
        chooseDate.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("hobbies-checkbox-3")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("hobbies-checkbox-1")));
//
//        WebElement hobbiesSelector = driver.findElement(By.id("hobbies-checkbox-1"));
//        hobbiesSelector.click();

        WebElement addressInput = driver.findElement(By.id("currentAddress"));
        addressInput.sendKeys("34 West South str.");

    }

    @Test
    public void secondTestCase() {
//        task 2
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
//        task 3.1
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
//        task 3.2
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
//        task 3.3
        String url = "https://demoqa.com/webtables";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement table = driver.findElement(By.className("rt-tbody"));
        wait.until(ExpectedConditions
                .visibilityOf(table));
        List<WebElement> rows = table.findElements(By.className("rt-tr-group"));

        for (WebElement row : rows) {
            for (int i = 1; i < 3; i++) {
                WebElement emailAddress = row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[" + i + "]/div/div[4]"));
                System.out.println(emailAddress.getText());
                if (emailAddress.getText().equals("alden@example.com")) {
                    WebElement deleteButton = table.findElement(By.id("delete-record-" + i));
                    deleteButton.click();
                    break;
                }

            }
            break;
        }
    }

    @Test
    public void sixthTest() {
//        task 4
//        check text in modals
        String url = "https://demoqa.com/modal-dialogs";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement showSmallModal = driver.findElement(By.id("showSmallModal"));
        WebElement showLargeModal = driver.findElement(By.id("showLargeModal"));

        showSmallModal.click();
        WebElement modal = driver.findElement(By.className("modal-content"));
        WebElement closeModal = driver.findElement(By.id("closeSmallModal"));
        WebElement modalBodyText = driver.findElement(By.className("modal-body"));

        modal.isDisplayed();
        Assertions.assertTrue(modalBodyText.getText().contains("This is a small modal. It has very less content"));
        closeModal.click();
        wait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.className("modal-content")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        showLargeModal.click();
        WebElement largeModal = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("modal-content")));
        largeModal.isDisplayed();
        Assertions.assertTrue(largeModal.getText().contains("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
    }

    @Test
    public void seventhTest() {
//        task 5
//        Open the accordion “Where does it come from?” and check that text contains
        String url = "https://demoqa.com/accordian";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement sectionToClose = driver.findElement(By.id("section1Heading"));
        sectionToClose.click();

        WebElement sectionToOpen = driver.findElement(By.id("section2Heading"));
        wait.until(ExpectedConditions.elementToBeClickable(sectionToOpen));
        sectionToOpen.click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".card > .collapse.show")));

        WebElement sectionContent = driver.findElement(By.id("section2Content"));
        Assertions.assertTrue(sectionContent.getText().contains("Hampden-Sydney College"));
    }

    @Test
    public void eightTest() {
//        task 6
//        Press the “Hide button” and check whether other buttons are visible
        String url = "http://uitestingplayground.com/visibility";
        driver.get(url);

        WebElement hideButton = driver.findElement(By.id("hideButton"));
        hideButton.click();
        try{
                    driver.findElement(By.id("removedButton"));
                    driver.findElement(By.id("zeroWidthButton"));
                    driver.findElement(By.id("overlappedButton"));
        } catch (NoSuchElementException ex) {
            System.out.println("Elements are not visible");
        }
        }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
