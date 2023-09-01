package Pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class SubmitFormPage {

    @Step("Gathering a collection of <trS>")
    public ElementsCollection getTheTrCollection(){
        return $$(By.tagName("tr"));
    }

    @Step("Checking the size of <tr> elements")
    public SubmitFormPage checkTrCollectionSize(int SizeNumber){
        getTheTrCollection().shouldHave(size(SizeNumber));
        return this;
    }

}
