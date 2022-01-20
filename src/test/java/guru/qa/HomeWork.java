package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class HomeWork {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.browser = "Chrome";
    }

    @Test
    @DisplayName("Тест проверят работу сервиса по определеню оператора по номеру телефона")
    void numberTest() {
        Selenide.open("https://www.spravportal.ru/Services/PhoneCodes/MobilePhoneInfo.aspx");
        $("input[name = 'ctl00$ctl00$cphMain$cphServiceMain$textNum']").setValue("89642483134");
        $("input[name='submit']").click();


    }



    // Сервис по определению оператора по номеру телефона отрабатывает корректно
    // * потворить для тестовых данных: [Номер 89642483134 Билйна, Номер 89512333371 МТС, Номер 89049764432 TELE2]

    // Открыть яндекс
    // Вбить в поле поиска {test_data}
    // кликнуть кнопку найти


    // в первом результате есть слово {test_data}
}
