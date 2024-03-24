package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        WebElement search = driver.findElement(By.id("APjFqb"));
        search.sendKeys("calculator");
        WebElement searchbtn = driver.findElement(By.xpath("(//input[@name='btnK'])[1]"));
        searchbtn.click();
        String CURL = driver.getCurrentUrl();
        if (CURL.contains("calculator")) {
            System.out.println("The test case is half passed");
        } else {
            System.out.println("The test case falied ");

        }

        WebElement calc = driver.findElement(By.id("cwos"));
        String num = calc.getText();
        if (num.equals("0")) {
            System.out.println("The test case is full passed since cal is loaded and it contains 0");
        } else {
            System.out.println("The test case is failed");
        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");

        driver.get("https://www.google.com/search?q=calculator");

        WebElement calc = driver.findElement(By.id("cwos"));

        calc("5");
        calc("+");
        calc("7");
        calc("=");

        calc = driver.findElement(By.id("cwos"));

        if (calc.getText().equals("12")) {
            System.out.println("Addition successfull as the displayed result is: " + calc.getText());
        }

        calc("AC");
        calc("1");
        calc("5");
        calc("-");
        calc("8");
        calc("=");

        calc = driver.findElement(By.id("cwos"));
        if (calc.getText().equals("7")) {
            System.out.println("Subtraction successfull as the displayed result is: " + calc.getText());
        }

        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");

        driver.get("https://www.google.com/search?q=calculator");

        calc("1");
        calc("0");
        calc("*");
        calc("3");
        calc("=");

        WebElement calc = driver.findElement(By.id("cwos"));
        if (calc.getText().equals("30")) {
            System.out.println("Multiplication is passed the ans is :" + calc.getText());
        }

        calc("AC");

        calc = driver.findElement(By.id("cwos"));

        if (calc.getText().equals("0")) {
            System.out.println("The AC button is working fine and the input is cleared");
        } else {
            System.out.println("Failed testcase AC button is not working");
        }

        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");

        driver.get("https://www.google.com/search?q=calculator");

        calc("2");
        calc("0");
        calc("/");
        calc("4");
        calc("=");


        WebElement calc = driver.findElement(By.id("cwos"));
        if (calc.getText().equals("5")) {
            System.out.println("Division is passed the ans is :" + calc.getText());
        }

        System.out.println("end Test case: testCase04");
    }

    public void calc(String num) {

        WebElement ele;
        switch (num) {
            case "AC":
                ele = driver.findElement(By.xpath("//div[text()='AC']"));
                ele.click();
                break;

            case "+":
                ele = driver.findElement(By.xpath("//div[text()='+']"));
                ele.click();
                break;

            case "-":
                ele = driver.findElement(By.xpath("//div[text()='−']"));
                ele.click();
                break;

            case "*":
                ele = driver.findElement(By.xpath("//div[text()='×']"));
                ele.click();
                break;

            case "/":
                ele = driver.findElement(By.xpath("//div[text()='÷']"));
                ele.click();
                break;

            case "=":
                ele = driver.findElement(By.xpath("//div[text()='=']"));
                ele.click();
                break;

            case "0":
                ele = driver.findElement(By.xpath("//div[text()='0']"));
                ele.click();
                break;

            case "1":
                ele = driver.findElement(By.xpath("//div[text()='1']"));
                ele.click();
                break;

            case "2":
                ele = driver.findElement(By.xpath("//div[text()='2']"));
                ele.click();
                break;

            case "3":
                ele = driver.findElement(By.xpath("//div[text()='3']"));
                ele.click();
                break;

                case "4":
                ele = driver.findElement(By.xpath("//div[text()='4']"));
                ele.click();
                break;
            case "5":
                ele = driver.findElement(By.xpath("//div[text()='5']"));
                ele.click();
                break;

            case "7":
                ele = driver.findElement(By.xpath("//div[text()='7']"));
                ele.click();
                break;
            case "8":
                ele = driver.findElement(By.xpath("//div[text()='8']"));
                ele.click();
                break;

            default:
                break;
        }

    }

}
