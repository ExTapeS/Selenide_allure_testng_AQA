package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

public class MainPage {

    @Step("Opening a web site {url}")
    public MainPage openAWebsite(String url){
        Selenide.open(url);
        return this;
    }

    @Step("Maximizing the window")
    public MainPage maximizeTheWindow(){
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }



}
