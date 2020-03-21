/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Websitesinde yeni hesap oluşturma işlemleri için kullanıcı bilgilerinin işlenmesi.
 *              web sayfasının elementlerinin tanımlandığı ve yapılan işlemlerin bulunduğu sınıf.
 */
package Pages.BeinSports;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.AutomationProcess.Web_Test_Assignment_Create_Page;
import static Utils.AutomationProcess.Web_Test_Assignment_Page_Func;

public class CreateAccountPage extends DriverUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By loadingPage = By.id("overlay-player");

    By firstNameInput = By.cssSelector("input[name='FirstName']");
    By lastNameInput = By.cssSelector("input[name='LastName']");
    By emailOrPhoneInput = By.cssSelector("input[name='EmailOrPhone']");
    By passwordInput = By.cssSelector("input[name='Password']");
    By policyInput = By.cssSelector("label[for='chkAllow']");
    By createAccountButton = By.cssSelector("input[data-text='CREATE ACCOUNT']");

    /// Sayfanın oluşturulması ile extend edilmiş olan DriverUtils sınıfına gerekli yapıları iletmektedir.
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        Web_Test_Assignment_Create_Page("CreateAccountPage", "BeinSports");
    }

    // Web sayfası yüklenip elementler tıklanabilir/görünebilir hale gelebilmesine kadar bekleme metodu
    public void waitLoadingPage() {
        Web_Test_Assignment_Page_Func("Wait for the new page to load.", "CreateAccountPage", "BeinSports");
        waitForElementBy(loadingPage);
        while (true) {
            boolean styleNone = invisibleForElementBy(loadingPage);
            if (styleNone) {
                break;
            }
        }
    }

    // Yeni hesap oluşturma için isim yazılması metodu
    public void setTextFirstName(String value) {
        Web_Test_Assignment_Page_Func("Set text to the firstName.", "CreateAccountPage", "BeinSports");
        waitForElementBy(firstNameInput).sendKeys(value);
    }

    // Yeni hesap oluşturma için soyisim yazılması metodu
    public void setTextLastName(String value) {
        Web_Test_Assignment_Page_Func("Set text to the lastName.", "CreateAccountPage", "BeinSports");
        waitForElementBy(lastNameInput).sendKeys(value);
    }

    // Yeni hesap oluşturma için Email yazılması metodu
    public void setTextEmail(String value) {
        Web_Test_Assignment_Page_Func("Set text to the Email.", "CreateAccountPage", "BeinSports");
        if (isValid(value)) {
            waitForElementBy(emailOrPhoneInput).sendKeys(value);
        } else {
            String randomText = getAlphaNumericString(5);
            waitForElementBy(emailOrPhoneInput).sendKeys(randomText+"@"+randomText+".com");
        }

    }

    // Yeni hesap oluşturma için şifre yazılması metodu
    public void setTextPassword(String value) {
        Web_Test_Assignment_Page_Func("Set text to the Password.", "CreateAccountPage", "BeinSports");
        waitForElementBy(passwordInput).sendKeys(value);
    }

    // Yeni hesap oluşturma için gizlilik sözleşmesi onay tıklama metodu
    public void clickPrivacyPolicy(){
        Web_Test_Assignment_Page_Func("Click on Privacy Policy.", "CreateAccountPage", "BeinSports");
        waitForElementBy(policyInput).click();
    }

    // Yeni hesap oluşturma butonu tıklama metodu
    public void clickCreateAccount(){
        Web_Test_Assignment_Page_Func("Click on Create Account.", "CreateAccountPage", "BeinSports");
        moveToClickElement(waitForElementBy(createAccountButton));
    }

    // Verilen yazının email olup olmadığının kontrolünün yapıldığı metod
    private boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    // Verilen rakam uzunluğunda rondam kelime oluşturma metodu
    private String getAlphaNumericString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}

