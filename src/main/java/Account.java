import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    /**
     * Выполняется проверка названия аккаунта для банковской карты:
     * <ul>
     * <li>в строке не меньше 3 и не больше 19 символов,
     * <li>в строке есть только один пробел,
     * <li>пробел стоит не в начале и не в конце строки.
     * </ul>
     * @return
     */
    @Step("Проверка имени для эмбоссирования")
    public boolean checkNameToEmboss() {
        if ((name == null) || name.isEmpty()) return false;
        boolean isLengthValid = name.length() >= 3 && name.length() <= 19;
        boolean isSpaceOne = name.indexOf(' ') == name.lastIndexOf(' ');
        boolean isBeginAndEndSpacesNotExist = name.indexOf(' ') > 0 && name.indexOf(' ') + 1 != name.length();
        return isLengthValid && isSpaceOne && isBeginAndEndSpacesNotExist;
    }

}