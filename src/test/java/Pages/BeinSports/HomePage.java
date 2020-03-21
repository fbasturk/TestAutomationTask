/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Websitesinin anasayfasında ki işlemler.
 *             web sayfasının elementlerinin tanımlandığı ve yapılan işlemlerin bulunduğu sınıf.
 */
package Pages.BeinSports;


import Utils.DriverUtils;
import Utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.AutomationProcess.Web_Test_Assignment_Create_Page;
import static Utils.AutomationProcess.Web_Test_Assignment_Page_Func;

public class HomePage extends DriverUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By loadingPage = By.id("overlay-player");
    By subscribeButton = By.cssSelector("li[class='subscribe']");

    /// Sayfanın oluşturulması ile extend edilmiş olan DriverUtils sınıfına gerekli yapıları iletmektedir.
    public HomePage(WebDriver driver) {
        super(driver);
        Web_Test_Assignment_Create_Page("HomePage", "BeinSports");
    }

    // Web sayfası yüklenip elementler tıklanabilir/görünebilir hale gelebilmesine kadar bekleme metodu
    public void waitLoadingPage() {
        Web_Test_Assignment_Page_Func("Wait for the new page to load.", "HomePage", "BeinSports");
        waitForElementBy(loadingPage);
        while (true) {
            boolean styleNone = invisibleForElementBy(loadingPage);
            if (styleNone) {
                break;
            }
        }
    }

    // Abone ol butonuna tıklama metodu
    public void clickSubscribeButton() {
        Web_Test_Assignment_Page_Func("Click on subscribe button.", "HomePage", "BeinSports");
        try {
            waitForElementBy(subscribeButton).click();
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
