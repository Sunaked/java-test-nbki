package solutions;

/*
Напишите простую sen программу, которая выводит на экран числа от 1 до 100 включительно.
 При этом вместо чисел, кратных трем, программа должна выводить слово Fizz, а вместо чисел, кратных пяти — слово Buzz.
  Если число кратно и трем, и пяти, то программа должна выводить слово FizzBuzz.
 */

public class Task3 {
    private static int begin = 1;
    private static final int end = 100;


    public static void FizzBuzz() {
        for (; begin < end - 15; begin += 15) {
            System.out.printf("%d\n" + // 1
                    "%d\n"           + // 2
                    "Fizz\n"         + // 3
                    "%d\n"           + // 4
                    "Buzz\n"         + // 5
                    "Fizz\n"         + // 6
                    "%d\n"           + // 7
                    "%d\n"           + // 8
                    "Fizz\n"         + // 9
                    "Buzz\n"         + // 10
                    "%d\n"           + // 11
                    "Fizz\n"         + // 12
                    "%d\n"           + // 13
                    "%d\n"           + // 14
                    "FizzBuzz\n",    // 15
                    begin, begin+1, begin+3, begin+6, begin+7, begin+10, begin+12, begin+13);
        }
        System.out.printf("%d\n" + // 1
                "%d\n"           + // 2
                "Fizz\n"         + // 3
                "%d\n"           + // 4
                "Buzz\n"         + // 5
                "Fizz\n"         + // 6
                "%d\n"           + // 7
                "%d\n"           + // 8
                "Fizz\n"         // 9
                , 91,92,94,98,99,96,97,98,99,100);
    }

    public static void main(String[] args) {
        FizzBuzz();
    }
}
