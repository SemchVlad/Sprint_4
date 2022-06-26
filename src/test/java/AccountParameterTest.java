import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

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
                { "Грегорий Туманский", true},
                { "Д И", true},
                { "Ди", false},
                { " Тимоти Шаламе", false},
                { "Тимоти Шаламе ", false},
                { "ТимотиШаламе", false},
                { "Тимоти Ди Шаламе", false},
        };
    }

    @Test
    public void paramTest() {
        Account account = new Account(nameAccount);
        assertEquals("Полученный результат валидации имени "+ nameAccount +" отличается от ожидаемого!",
                expectedValidation, account.checkNameToEmboss());
    }

}
