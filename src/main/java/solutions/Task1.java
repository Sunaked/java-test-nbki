package solutions;

/*
Реализуйте метод для замены заданного символа в строке (простой аналог метода replace класса String в Java). На вход метод получает строку и символы, возвращает строку.
 */

public class Task1 {
    public static String replace (String str, char symbolToReplace, char replaceableSymbol) {
        StringBuilder out = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == symbolToReplace){
                    out.append(replaceableSymbol);
                } else {
                    out.append(str.charAt(i));
                }
            }
        return out.toString();
    }
}
