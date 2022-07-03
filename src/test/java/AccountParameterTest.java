import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountParameterTest {

    private final String nameAccount;
    private final boolean expectedValidation;

    public AccountParameterTest(String nameAccount, boolean expectedValidation) {
        this.nameAccount = nameAccount;
        this.expectedValidation = expectedValidation;
    }

    @Parameterized.Parameters(name = "Проверка имени \"{0}\" для печати на банковской карте. Ожидаемы результат проверки: {1}")
    public static Object[][] dataForTest() {
        return new Object[][] {
                { "Тимоти Шаламе", true},
                { "Владимир Труманский ", false},
                { "Грегорий Труманский", true},
                { "Грегорий Водоканалов", false},
                { "Д И", true},
                { "Ди", false},
                { " Тимоти Шаламе", false},
                { "Тимоти Шаламе ", false},
                { "ТимотиШаламе", false},
                { "Тимоти Ди Шаламе", false},
                { null, false},
                { "", false}
        };
    }

    @Test
    @Description("Вызов проверки вводимой строки имени на соответствие условиям эмбоссирования")
    public void paramTest() {
        Account account = new Account(nameAccount);
        assertEquals("Полученный результат валидации имени "+ nameAccount +" отличается от ожидаемого!",
                expectedValidation, account.checkNameToEmboss());
    }
}
