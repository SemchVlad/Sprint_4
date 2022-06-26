import static com.google.common.base.Preconditions.*;

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
    public boolean checkNameToEmboss() {
        checkNotNull(name);
        if ((name.length() < 3) || (name.length() > 19))
            return false;
        if (name.startsWith(" ") || name.endsWith(" "))
            return false;
        if (!name.contains(" ") || (name.split(" ").length > 2))
            return false;
        return true;
    }

}