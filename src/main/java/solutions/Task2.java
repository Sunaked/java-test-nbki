package solutions;

/*
Реализуйте 2 метода для преобразования строки:
- один - в целочисленное значение элементарного типа (int)
- другой метод - в число с плавающей запятой (double), так же элементарного типа.
Необходимо реализовать собственные методы, без использования аналогичных методов из Java (если знаете аналогичные Java методы, пожалуйста, перечислите их).

 */

/*
Аналогичные методы в Java для int:
- Integer.valueOf(String in)
- Integer.parseInt(String in)
- Integer.decode(String in)
- NumberUtils.toInt(String in)

Аналогичные методы в Java для double:
- Double.parseDouble(String in)
 */

import java.util.HashMap;

public class Task2 {
    private static final HashMap<Character, Integer>  numMap = new HashMap<>();
    public static void InitMap() {
        numMap.put('0', 0);
        numMap.put('1', 1);
        numMap.put('2', 2);
        numMap.put('3', 3);
        numMap.put('4', 4);
        numMap.put('5', 5);
        numMap.put('6', 6);
        numMap.put('7', 7);
        numMap.put('8', 8);
        numMap.put('9', 9);
    }

    public static int convertInt(String number) {
        if (number.length() == 0) {
            System.out.println("zero len\n");
            return -1;
        }
        InitMap();

        int out = 0, i = 0;
        boolean negative = false;

        try {
            if (number.equals(" ") || number.charAt(0)==0 || (number.charAt(0)=='-' && number.charAt(1)==0)) return -1; // если пусто || если число == нулю || если число == -0
            if (number.charAt(0)=='-') {negative = true; i = 1;} //если число отрицательное, начинаем цикл со след. элемента
            for (; i < number.length(); i++) {
                int j = numMap.get(number.charAt(i));
                out += j * Math.pow(10, number.length() - i-1); //прибавляем к out порядками: 1000 * n + 100 * t + ...
            }
        } catch (Exception e) {
            throw e;
        }
        return !negative ? out : -out;
    }

    public static double convertDouble(String number) {
        if (number.length() == 0) {
            return -1;
        }
        InitMap();
        boolean negative = false;
        int i = 0;
        if (number.charAt(0) == '-') {
            negative = true;
            i = 1;
        }
        double out = 0d;
        boolean isDot = false;
        int count = 1;
            for (; i < number.length(); i++) {
                if (number.charAt(i) == '.') {
                    isDot = true;
                    i++;
                }
                if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                    if (isDot) {
                        out += numMap.get(number.charAt(i)) / Math.pow(10, count++);
                    } else {
                        out += numMap.get(number.charAt(i));
                        if (number.charAt(i) == '0' || number.charAt(i + 1) == '.') continue;
                        out *= 10;
                    }

                }

        }
        return !negative ? out : -out;
    }
}
