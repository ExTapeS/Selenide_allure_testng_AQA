import Pages.MainPage;
import Pages.PracticeFormPage;
import Pages.SubmitFormPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static Common.Constants.PAGE_WAIT;

public class MainTest {

    protected MainPage mainPage = new MainPage();
    protected PracticeFormPage practiceFormPage = new PracticeFormPage();

    protected SubmitFormPage submitFormPage = new SubmitFormPage();
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.pageLoadTimeout = PAGE_WAIT;
    }

    @BeforeClass
    public void startIt(){
        setUP();
    }

    @AfterClass
    public void quitIt(){
        Selenide.closeWebDriver();
    }

}
