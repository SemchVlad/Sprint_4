import static com.google.common.base.Preconditions.*;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

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