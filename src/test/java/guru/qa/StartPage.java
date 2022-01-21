package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {

    SelenideElement

    numberInput = $("input[name = 'ctl00$ctl00$cphMain$cphServiceMain$textNum']"),
    buttonSubmit = $("input[type='submit']");


    public StartPage openPage(){
        Selenide.open("https://www.spravportal.ru/Services/PhoneCodes/MobilePhoneInfo.aspx");
        return this;
    }

    public StartPage setTelefonNumber (String testData) {
        numberInput.setValue(testData);
        return this;
    }

    public StartPage startCheck(){
        buttonSubmit.click();
        return this;
    }



    public StartPage assetOperator(String expected){
        $("#lblOp").shouldHave(Condition.text(expected));
        return this;

    }

}
