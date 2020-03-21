/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Websitesinde ödeme işlemleri için kredikartı bilgilerinin işlenmesi.
 *             web sayfasının elementlerinin tanımlandığı ve yapılan işlemlerin bulunduğu sınıf.
 */
package Pages.BeinSports;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utils.AutomationProcess.Web_Test_Assignment_Create_Page;
import static Utils.AutomationProcess.Web_Test_Assignment_Page_Func;

public class CardInfoPage extends DriverUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By loadingPage = By.id("overlay-player");

    By cardNameInput = By.id("Ecom_Payment_Card_Name");
    By cardNumberInput = By.id("Ecom_Payment_Card_Number");
    By cardVerificationInput = By.id("Ecom_Payment_Card_Verification");

    By monthSelect = By.id("Ecom_Payment_Card_ExpDate_Month");
    By Months = By.tagName("option");
    By yearSelect = By.id("Ecom_Payment_Card_ExpDate_Year");
    By Years = By.tagName("option");

    By confirmPaymentButton = By.cssSelector("input[name='payment']");

    By paymentResultText = By.tagName("h3");

    /// Sayfanın oluşturulması ile extend edilmiş olan DriverUtils sınıfına gerekli yapıları iletmektedir.
    public CardInfoPage(WebDriver driver) {
        super(driver);
        Web_Test_Assignment_Create_Page("CardInfoPage", "BeinSports");
    }

    // Web sayfası yüklenip elementler tıklanabilir/görünebilir hale gelebilmesine kadar bekleme metodu
    public void waitLoadingPage() {
        Web_Test_Assignment_Page_Func("Wait for the new page to load.", "CardInfoPage", "BeinSports");
        waitForElementBy(loadingPage);
        while (true) {
            boolean styleNone = invisibleForElementBy(loadingPage);
            if (styleNone) {
                break;
            }
        }
    }

    // Kredi kartı isim bölümüne yazı yazılması metodu
    public void setTextCardName(String value) {
        Web_Test_Assignment_Page_Func("Set text to the Card Name.", "CardInfoPage", "BeinSports");
        waitForElementBy(cardNameInput).sendKeys(value);
    }

    // Kredi kartı Numarası bölümüne yazı yazılması metodu
    public void setTextCardNumber(String value) {
        Web_Test_Assignment_Page_Func("Set text to the Card Number.", "CardInfoPage", "BeinSports");
        waitForElementBy(cardNumberInput).sendKeys(value);
    }

    // Kredi kartı son kullanma ay açılır listesine tıklama metodu
    public void clickMonthSelect() {
        Web_Test_Assignment_Page_Func("Click on Months", "CardInfoPage", "BeinSports");
        waitForElementBy(monthSelect).click();
    }

    // Kredi kartı son kullanma ay seçme metodu
    public void selectMonth(String value) {
        Web_Test_Assignment_Page_Func("Set text to the Month.", "CardInfoPage", "BeinSports");
        List<WebElement> monthsList = waitForElementsBy(Months);
        for (WebElement element : monthsList) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    // Kredi kartı son kullanma yıl açılır listesine tıklama metodu
    public void clickYearSelect() {
        Web_Test_Assignment_Page_Func("Click on Years", "CardInfoPage", "BeinSports");
        waitForElementBy(yearSelect).click();
    }

    // Kredi kartı son kullanma yıl seçme metodu
    public void selectYear(String value) {
        Web_Test_Assignment_Page_Func("Set text to the Year.", "CardInfoPage", "BeinSports");
        List<WebElement> yearsList = waitForElementsBy(Years);
        for (WebElement element : yearsList) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    // Kredi kartı güvenlik şifresinin yazılması metodu
    public void setTextCardVerification(String value) {
        Web_Test_Assignment_Page_Func("Set text to the Card Verification.", "CardInfoPage", "BeinSports");
        waitForElementBy(cardVerificationInput).sendKeys(value);
    }

    // Ödeme işlemini tamamlama butonuna tıklama metodu
    public void clickConfirmPayment() {
        Web_Test_Assignment_Page_Func("Click on Confirm Payment.", "CardInfoPage", "BeinSports");
        waitForElementBy(confirmPaymentButton).click();
    }

    // Ödeme işleminin sonucunda çıkan mesaj bilgisinin geçilmesi metodu
    public String getPaymentResultMessage() {
        Web_Test_Assignment_Page_Func("Get text to payment result message.", "CardInfoPage", "BeinSports");
        return waitForElementBy(paymentResultText).getText();
    }

}
