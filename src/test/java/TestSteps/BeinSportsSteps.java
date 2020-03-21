/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :BDD olarak oluşturduğumuz senaryoları temsil eden kodların bulunduğu sınıf. Senaryolar ile metotları eşlendirilimesi sağlanır.
 */
package TestSteps;

import Pages.BeinSports.*;
import Utils.LogUtil;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static Utils.AutomationProcess.*;
import static org.junit.Assert.assertEquals;


public class BeinSportsSteps extends BaseStep {

    private HomePage homePage;
    private SubscribePage subscribePage;
    private CreateAccountPage createAccountPage;
    private PaymentMethodPage paymentMethodPage;
    private CardInfoPage cardInfoPage;

    @Before
    public void InitializeTest(Scenario scenario) {
        Web_Test_Assignment_Start_Scenario(scenarioCount, scenario.getName(), "BeinSports");

        if (scenario.getName().contains("Base")) {

        } else if (scenario.getName().contains("HomePage")) {
            homePage = new HomePage(driver);
        } else if (scenario.getName().contains("SubscribePage")) {
            subscribePage = new SubscribePage(driver);
        } else if (scenario.getName().contains("CreateAccountPage")) {
            createAccountPage = new CreateAccountPage(driver);
        } else if (scenario.getName().contains("PaymentMethodPage")) {
            paymentMethodPage = new PaymentMethodPage(driver);
        } else if (scenario.getName().contains("CardInfoPage")) {
            cardInfoPage = new CardInfoPage(driver);
        } else {
            createErrorMessage("No page defined for " + scenario.getName() + " Scenario.");
        }

    }

    @After
    public void TearDownTest(Scenario scenario) {
        Web_Test_Assignment_Finish_Scenario(scenarioCount, scenario.getName(),scenario.getStatus().toString());

        scenarioCount++;
    }

    @Given("At BeinSports Start Browser {string} And Test")
    public void at_BeinSports_Start_Browser(String browserName) {
        Web_Test_Assignment_Start();
        Web_Test_Assignment_Start_Browser(browserName);
        startTime = System.currentTimeMillis();
        switch (browserName.toUpperCase()) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "OPERA":
                System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
                driver = new OperaDriver();
                break;
            case "IE":
                System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                createErrorMessage("At Start Browser " + browserName + " step of BeinSports app was not defined");
        }
        driver.manage().window().maximize();
    }

    @Given("At BeinSports GoTo {string}")
    public void at_BeinSports_GoTo(String pageLink) {
        Web_Test_Assignment_Start_BeinSportsTest(pageLink);
        driver.get(pageLink);
    }

    @Given("At BeinSports Click {string}")
    public void at_BeinSports_Click(String purpose) {
        switch (purpose) {
            case "Subscription":
                homePage.waitLoadingPage();
                homePage.clickSubscribeButton();
                break;
            case "ONE MONTH":
                subscribePage.waitLoadingPage();
                packageAmount = subscribePage.clickSubscriptionNameButton("ONE MONTH");
                break;
            case "Monthly Pass with One Week Free Trial Button":
                subscribePage.clickOneWeekFreeTrial();
                break;
            case "Privacy Policy":
                createAccountPage.clickPrivacyPolicy();
                break;
            case "Create Account":
                createAccountPage.clickCreateAccount();
                break;
            case "Close Account Verification Info":
                paymentMethodPage.waitLoadingPage();
                paymentMethodPage.clickInfoValidationEmailClose();
                break;
            case "Agreed to the Terms And Conditions":
                paymentMethodPage.clickTermsAndConditions();
                break;
            case "Pay Now":
                paymentMethodPage.clickPayNow();
                break;
            case "Yes, I CONFIRM MY PAYMENT":
                cardInfoPage.clickConfirmPayment();
                break;
            default:
                createErrorMessage("At Click " + purpose + " step of BeinSports app was not defined");
                break;
        }
    }


    @When("At BeinSports SetText {string} Type {string}")
    public void at_BeinSports_SetText_Type(String purpose, String message) {
        switch (purpose) {
            case "First Name":
                createAccountPage.waitLoadingPage();
                createAccountPage.setTextFirstName(message);
                break;
            case "Last Name":
                createAccountPage.setTextLastName(message);
                break;
            case "Email Or Mobile Number":
                createAccountPage.setTextEmail(message);
                break;
            case "Create A Password":
                createAccountPage.setTextPassword(message);
                break;
            case "Cardholder's name":
                cardInfoPage.setTextCardName(message);
                break;
            case "Card number":
                cardInfoPage.setTextCardNumber(message);
                break;
            case "Card verification code":
                cardInfoPage.setTextCardVerification(message);
                break;
            default:
                createErrorMessage("At SetText " + purpose + " step of BeinSports app was not defined");
                break;
        }
    }

    @When("At BeinSports Select {string} {string}")
    public void at_Select(String selectValue, String purpose) {
        switch (purpose) {
            case "Month":
                cardInfoPage.clickMonthSelect();
                cardInfoPage.selectMonth(selectValue);
                break;
            case "Year":
                cardInfoPage.clickYearSelect();
                cardInfoPage.selectYear(selectValue);
                break;
            default:
                createErrorMessage("At Select " + purpose + " step of BeinSports app was not defined");
                break;
        }
    }

    @Then("At BeinSports Check {string}")
    public void at_BeinSports_Check(String purpose) {
        switch (purpose) {
            case "Validate package price":
                assertEquals("The package price selected is not correct.", packageAmount, paymentMethodPage.getTotalAmount());
                break;
            case "Making Payment":
                assertEquals("", "Payment completed.", cardInfoPage.getPaymentResultMessage());
                break;
            default:
                createErrorMessage("At Check " + purpose + " step of BeinSports app was not defined");
                break;
        }
    }

    @Then("At BeinSports Finish Browser And Test")
    public void at_BeinSports_Finish_Browser_And_Test() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName();

        long testTime = System.currentTimeMillis() - startTime;

        Web_Test_Assignment_Finish_Browser(browserName,testTime);
        driver.quit();
    }


    private void createErrorMessage(String message) {
        LogUtil.error(message);
        throw new IllegalStateException(message);
    }


}
