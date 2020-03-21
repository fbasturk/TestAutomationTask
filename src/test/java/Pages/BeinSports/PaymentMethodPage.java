/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Websitesinde ödeme bilgilerinin yer aldığı işlemler.
 * web sayfasının elementlerinin tanımlandığı ve yapılan işlemlerin bulunduğu sınıf.
 */
package Pages.BeinSports;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.AutomationProcess.Web_Test_Assignment_Create_Page;
import static Utils.AutomationProcess.Web_Test_Assignment_Page_Func;

public class PaymentMethodPage extends DriverUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By loadingPage = By.id("overlay-player");

    By infoFormClose = By.cssSelector("a[class='form-close']");

    By totalAmount = By.id("lblTotalAmount");
    By checkTermsInput = By.cssSelector("label[for='checkTerms']");
    By payNowInput = By.cssSelector("input[name='pay-now']");


    /// Sayfanın oluşturulması ile extend edilmiş olan DriverUtils sınıfına gerekli yapıları iletmektedir.
    public PaymentMethodPage(WebDriver driver) {
        super(driver);
        Web_Test_Assignment_Create_Page("PaymentMethodPage", "BeinSports");
    }

    // Web sayfası yüklenip elementler tıklanabilir/görünebilir hale gelebilmesine kadar bekleme metodu
    public void waitLoadingPage() {
        Web_Test_Assignment_Page_Func("Wait for the new page to load.", "PaymentMethodPage", "BeinSports");
        waitForElementBy(loadingPage);
        while (true) {
            boolean styleNone = invisibleForElementBy(loadingPage);
            if (styleNone) {
                break;
            }
        }
    }


    // Mail adresini doğrulayın bilgi mesajının kapatılması metodu
    public void clickInfoValidationEmailClose() {
        Web_Test_Assignment_Page_Func("Click on info email.", "PaymentMethodPage", "BeinSports");
        waitForElementBy(infoFormClose).click();
    }


    // Seçilmiş olan ürün fiyat bilgisinin çekilmesi metodu
    public String getTotalAmount() {
        Web_Test_Assignment_Page_Func("Get text to total amount.", "PaymentMethodPage", "BeinSports");
        return waitForElementBy(totalAmount).getAttribute("data-total-amount-price");
    }


    // Anlaşmaları kabul ettiğini onayladma butonuna tıklama metodu
    public void clickTermsAndConditions() {
        Web_Test_Assignment_Page_Func("Click on Terms and Conditions.", "PaymentMethodPage", "BeinSports");
        waitForElementBy(checkTermsInput).click();
    }

    /// Ödeme yap butonuna tıklama metodu
    public void clickPayNow() {
        Web_Test_Assignment_Page_Func("Click on pay now.", "PaymentMethodPage", "BeinSports");
        waitForElementBy(payNowInput).click();
    }
}
