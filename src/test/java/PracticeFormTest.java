import Pages.MainPage;
import Pages.PracticeFormPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeFormTest extends MainTest {


    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Story("Creating a new user with Name, Last Name, Address amd Email")
    public void registerAUser() {
        mainPage.openAWebsite("https://demoqa.com/automation-practice-form/").maximizeTheWindow();
        practiceFormPage.rmvFooter()
                .rmvDiv()
                .chooseAGender("male")
                .fillInAddress("Kekestan")
                .fillInNmbr("9999999999")
                .fillInFrstName("Kekeslav")
                .fillInLstName("Kekesov")
                .fillEmail("mail@mail.com")
                .chooseTheDateOfBirth(6, 1994, practiceFormPage.June29th)
                .upldAPicture("pic.png")
                .clckSbmtBtnToSubmitPage()
                .checkTrCollectionSize(11);
    }
}
