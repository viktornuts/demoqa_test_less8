package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;

public class HomeWork {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.browser = "Chrome";
    }

    static Stream<Arguments> commonSearchTestCsvSource() {
        return Stream.of(
                Arguments.of("89642483134", "Билайн"),
                Arguments.of("89512333371", "МТС"),
                Arguments.of("89049764432", "TELE2")
        );
    }


    @MethodSource("commonSearchTestCsvSource")
    @ParameterizedTest(name = "Тест проверят работу сервиса по определеню оператора по номеру телефона с данными: {0}")
    void numberTest(String testData, String expected) {
        Selenide.open("https://www.spravportal.ru/Services/PhoneCodes/MobilePhoneInfo.aspx");
        $("input[name = 'ctl00$ctl00$cphMain$cphServiceMain$textNum']").setValue(testData);
        $("input[type='submit']").click();
        $("#lblOp").shouldHave(Condition.text(expected));
    }


    @CsvSource(value = {
            "89642483134, Билайн",
            "89512333371, МТС",
            "89049764432, TELE2"
    })
    @ParameterizedTest(name = "Тест проверят работу сервиса по определеню оператора по номеру телефона с данными: {0}")
    void numberTest1(String testData, String expected) {
        Selenide.open("https://www.spravportal.ru/Services/PhoneCodes/MobilePhoneInfo.aspx");
        $("input[name = 'ctl00$ctl00$cphMain$cphServiceMain$textNum']").setValue(testData);
        $("input[type='submit']").click();
        $("#lblOp").shouldHave(Condition.text(expected));
    }


    // Сервис по определению оператора по номеру телефона отрабатывает корректно
    // * потворить для тестовых данных: [Номер 89642483134 Билйна, Номер 89512333371 МТС, Номер 89049764432 TELE2]

    // Открыть сайт сервиса проверки оператора по номеру телефона
    // Вбить в поле поиска {test_data}
    // кликнуть кнопку найти


    // в поле оператор в результате есть слово {test_data}
}
