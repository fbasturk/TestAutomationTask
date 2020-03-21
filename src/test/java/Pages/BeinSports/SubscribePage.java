/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Websitesinde abone olma işlemleri ve abone olma seçeneklerine göre işlem yapılması
 *             web sayfasının elementlerinin tanımlandığı ve yapılan işlemlerin bulunduğu sınıf.
 */
package Pages.BeinSports;

import Utils.DriverUtils;
import Utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utils.AutomationProcess.Web_Test_Assignment_Create_Page;
import static Utils.AutomationProcess.Web_Test_Assignment_Page_Func;

public class SubscribePage extends DriverUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By loadingPage = By.id("overlay-player");
    By subscriptionNameButtons = By.cssSelector("span[class='subscription-name name detail fz-16 pull-left']");
    By subscriptionAmounts = By.cssSelector("span[class='subscription-price-item price fz-14 fw-bold']");
    By backButton = By.cssSelector("a[class='go-back btn-type-1 mt-20-plus back-button ']");
    By subscriptionPackages = By.cssSelector("div[class='subscription-package open']");
    By packageTitle = By.cssSelector("span[class='name detail fz-16 mb-10-plus']");
    By packageSubscriptionButton = By.cssSelector("a[class='btn-type-2 mt-20-plus bc-subscribe border-none add-card']");

    /// Sayfanın oluşturulması ile extend edilmiş olan DriverUtils sınıfına gerekli yapıları iletmektedir.
    public SubscribePage(WebDriver driver) {
        super(driver);
        Web_Test_Assignment_Create_Page("SubscribePage", "BeinSports");
    }

    // Web sayfası yüklenip elementler tıklanabilir/görünebilir hale gelebilmesine kadar bekleme metodu
    public void waitLoadingPage() {
        Web_Test_Assignment_Page_Func("Wait for the new page to load.", "SubscribePage", "BeinSports");
        waitForElementBy(loadingPage);
        while (true) {
            boolean styleNone = invisibleForElementBy(loadingPage);
            if (styleNone) {
                break;
            }
        }
    }

    // Abonelik için paket seçilmesi ve seçilen paketin fiyat bilgisinin çekilmesi metodu
    public String clickSubscriptionNameButton(String subscriptionName) {
        Web_Test_Assignment_Page_Func("Click on subscription name button.", "SubscribePage", "BeinSports");
        String result = "ERROR_AMOUNT";
        try {
            List<WebElement> subscriptions = waitForElementsBy(subscriptionNameButtons);
            List<WebElement> packageAmountsList = elementsBy(subscriptionAmounts);
            for (WebElement element : subscriptions) {
                if (element.getText().toLowerCase().equals(subscriptionName.toLowerCase())) {
                    result = packageAmountsList.get(subscriptions.indexOf(element)).getText();
                    result=result.substring(result.indexOf("฿")+1);
                    element.click();
                    break;
                }
            }
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // Seçilen paket içerisindeki deneme özelliğinin seçilmesi metodu
    public void clickOneWeekFreeTrial() {
        Web_Test_Assignment_Page_Func("Click on One Week Free Trial package.", "SubscribePage", "BeinSports");
        try {
            List<WebElement> packages = elementsBy(subscriptionPackages);
            for (WebElement element : packages) {
                WebElement tempElement = element.findElement(packageTitle);
                if (tempElement.getText().equals("Monthly Pass with One Week Free Trial")) {
                    moveToClickElement(element.findElement(packageSubscriptionButton));
                    //  element.findElement(packageSubscriptionButton).click();
                    break;
                }
            }
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
