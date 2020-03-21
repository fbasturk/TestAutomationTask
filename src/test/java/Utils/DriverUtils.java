/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Belirlenen website elementleri için yapılacak işlemlerin metotlar halinde toplanmasını sağlayan sınıf.
 */
package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DriverUtils {

    private WebDriver driver;
    private WebDriverWait driverWait;

    // işlemler için gerekli driver tanımlanması. Elementlerin görünür hale gelene kadar işlemleri bekletilmesini sağlayan WebDriverWait objesinin oluşturulması.
    public DriverUtils(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 30);
    }

    // By bilgisine sahip elementin görünebilir olmasına kadar beklenmesi ve ardından elementi metodu çağıran kısma iletilmesi metodu
    public WebElement waitForElementBy(By cssSelector) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector));

    }

    // By bilgisine sahip elementlerin görünebilir olmasına kadar beklenmesi ve ardından elementleri liste halinde metodu çağıran kısma iletilmesi metodu
    public List<WebElement> waitForElementsBy(By cssSelector) {
        return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cssSelector));
    }

    public boolean invisibleForElementBy(By cssSelector) {
        return driverWait.until(ExpectedConditions.invisibilityOfElementLocated(cssSelector));

    }

    // By bilgisine sahip elementin driver içinden element bulunması metodu
    public WebElement elementBy(By cssSelector) {
        return driver.findElement(cssSelector);
    }

    // By bilgisine sahip elementlerin driver içinden elementlerin liste halinde bulunması metodu
    public List<WebElement> elementsBy(By cssSelector) {
        return driver.findElements(cssSelector);
    }

    // By bilgisine sahip elemente kadar JavaScript metodu ile kaydırma metodu
    public void ScrollJSElement(By selector){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(selector));
    }

    // By bilgisine sahip elemente kadar kaydırma metodu
    public void moveToElement(By selector){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(selector));
        actions.perform();
    }

    // By bilgisine sahip elemente kadar kaydırma ve ardından tıklama metodu
    public void moveToClickElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

}
