public class Praktikum {

    public static void main(String[] args) {
        System.out.println("Пример работы программы: Для печати передана строка \"Тимоти Шаламе\"");
        Account account = new Account("Тимоти Шаламе");
        //печать банковской карты
        if (account.checkNameToEmboss())
            System.out.println("Банковская карта на имя: " + account);
        else
            System.out.println("Напечатать карту невозможно! Проверьте строку на соответствие требованиям:\n" +
                    "- в строке не меньше 3 и не больше 19 символов;\n" +
                    "- в строке есть только один пробел;\n" +
                    "- пробел стоит не в начале и не в конце строки;");
    }

}