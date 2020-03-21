/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Projenin ana başlatılma merkezi  JUnit ile BDD senaryolarının bulunduğu paketin ve senaryolara göre yapılması
 * gereken işlemlerin bulunduğu kodları içeren paketin tanımlanması gibi ayarların yapıldığı sınıf.
 */

package Base;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/// BDD yaklaşımına göre Cucumber ayarlarının yapıldığı alan.
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features"},
        glue = {"TestSteps"})
public class BaseTest {

}
