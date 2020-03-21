/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Projenin çalışma sürecini takip edilebileceği ve kısayol (Ctrl+B) ile kod kısmına ulaşılmasını sağlayan yardımcı sınıf.
 */
package Utils;

public class AutomationProcess {

    //// 1. Adım
    public static void Web_Test_Assignment_Start() {
        LogUtil.info("1- Digiturk's web test automation begins.");
    }

    ///// 2. Adım
    public static void Web_Test_Assignment_Start_Browser(String driverName) {
        LogUtil.info("2- Browser Name: " + driverName + " The Browser is getting ready to run.");
    }

    //// 3. Adım
    public static void Web_Test_Assignment_Start_BeinSportsTest(String webSite) {
        LogUtil.info("3- " + webSite + " web test started.");
    }

    //// Senaryo başlama Adım
    public static void Web_Test_Assignment_Start_Scenario(int index, String scenarioName, String webSite) {
        LogUtil.info("\tS." + index + "- Scenario Start: " + scenarioName + " Test in " + webSite);
    }

    //// Sayfaları oluşturma adımları
    public static void Web_Test_Assignment_Create_Page(String testPage, String webSite) {
        LogUtil.info(" \t\t" + testPage + " created for " + webSite);
    }

    //// Sayfalarda yapılan işlemlerin adımları
    public static void  Web_Test_Assignment_Page_Func(String funcMessage, String testPage, String webSite) {
        LogUtil.info(" \t\t\t " + funcMessage + " in " + testPage + " for " + webSite);
    }

    //// Senaryo bittirme Adım Fail or Pass
    public static void Web_Test_Assignment_Finish_Scenario(int index, String scenarioName, String status) {
        LogUtil.info("\tS." + index + "- Scenario Finish: " + scenarioName + " STATUS= " + status);
    }

    //// 4. Adım
    public static void Web_Test_Assignment_Finish_Browser(String driverName,long testTime) {
        LogUtil.info("4- The Browser is finish. Browser Name: " + driverName + " Completed Time:"+testTime);
    }


}
