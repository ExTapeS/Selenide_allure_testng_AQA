package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.*;


public class PracticeFormPage extends MainPage {

    private final SelenideElement sbmtBtn = $(By.id("submit"));

    private final SelenideElement lstNameFld = $(By.id("lastName"));

    private final SelenideElement frstNamefld = $(By.id("firstName"));

    private final SelenideElement usrNmbrFld = $(By.id("userNumber"));

    private final SelenideElement gndrMaleBtn = $x("//label[contains(text(),'Male')]");

    private final SelenideElement gndrFmlBtn = $x("//label[contains(text(),'Female')]");

    private final SelenideElement gndrOthrBtn = $x("//label[contains(text(),'Other')]");

    private final SelenideElement dateOfBrthFld = $(By.id("dateOfBirthInput"));

    private final SelenideElement monthSlct = $x("//select[contains(@class,'month-select')]");

    private final SelenideElement yearSlct = $x("//select[contains(@class,'year-select')]");

    public SelenideElement June29th = $x("//div[contains(@aria-label,'June 29th')]");

    private final SelenideElement usrMailFld = $(By.id("userEmail"));

    private final SelenideElement addressFld = $(By.id("currentAddress"));

    private final SelenideElement upldBtn = $(By.id("uploadPicture"));

    @Step("Clicking submit button")
    public PracticeFormPage clckSbmtBtn(){
        sbmtBtn.click();
        return this;
    }

    @Step("Clicking submit button")
    public SubmitFormPage clckSbmtBtnToSubmitPage(){
        sbmtBtn.click();
        return page(SubmitFormPage.class);
    }

    @Step("filling the Name field")
    public PracticeFormPage fillInFrstName(String FirstName){
        frstNamefld.sendKeys(FirstName);
        return this;
    }

    @Step("filling the Second Name field")
    public PracticeFormPage fillInLstName(String LastName){
        lstNameFld.sendKeys(LastName);
        return this;
    }

    @Step("filling the Mobile Number field")
    public PracticeFormPage fillInNmbr(String PhoneNumber){
        usrNmbrFld.sendKeys(PhoneNumber);
        return this;
    }

    @Step("filling the Address field")
    public PracticeFormPage fillInAddress(String address){
        addressFld.sendKeys(address);
        return this;
    }

    @Step("Choosing {gender} gender")
    public PracticeFormPage chooseAGender(String gender) {
        switch (gender) {
            case "male" -> gndrMaleBtn.click();
            case "female" -> gndrFmlBtn.click();
            case "other" -> gndrOthrBtn.click();
            default -> gndrOthrBtn.click();
        }
        return this;
    }

    @Step("Choosing date of birth")
    public PracticeFormPage chooseTheDateOfBirth(int month, int year, SelenideElement day){
        dateOfBrthFld.click();
        Select yearOfBirth = new Select(yearSlct);
        String realYear = Integer.toString(year);
        yearOfBirth.selectByValue(realYear);
        Select monthOfBirth = new Select(monthSlct);
        int actMonth = month-1;
        String realMonth = Integer.toString(actMonth);
        monthOfBirth.selectByValue(realMonth);
        day.click();
        return this;
    }

    @Step("Removing the footer")
    public PracticeFormPage rmvFooter(){
        executeJavaScript("document.getElementsByTagName('footer')[0].remove();");
        return this;
    }
    @Step("Removing the Footer2")
    public PracticeFormPage rmvDiv(){
        executeJavaScript("document.getElementsByTagName('div')[2].remove();");
        return this;
    }

    @Step("Removing the Footer2")
    public PracticeFormPage fillEmail(String email){
        usrMailFld.sendKeys(email);
        return this;
    }

    @Step("Uploading a picture {fileNameInResources}")
    public PracticeFormPage upldAPicture(String fileNameInResources){
        String usrDirectory = System.getProperty("user.dir");
        upldBtn.sendKeys(usrDirectory+"\\src\\main\\resources\\"+fileNameInResources);
        return this;
    }

}
