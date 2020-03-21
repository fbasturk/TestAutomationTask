/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Her senaryo için baştan başlatılmaması ve ortak kullanılması gerekn değişkenlerin tanımlanması için oluşturulan sınıf.
 */
package TestSteps;

import org.openqa.selenium.WebDriver;

public class BaseStep {
    public static WebDriver driver;
    public static int scenarioCount=1;
    public static long startTime;

    public static String packageAmount;
}
