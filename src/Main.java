import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ВВедите выражение:");
        String exp = scanner.nextLine();
        System.out.println(calc(exp));
    }


    public static String calc(String input) throws Exception {
        int a = 0;
        int b = 0;
        String oper;
        String res;
        boolean isRoman;
        String [] operands = input.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        oper = detOper(input);

        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            a = Roman.conToArab(operands[0]);
            b = Roman.conToArab(operands[1]);
            isRoman = true;
        }

        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            a = Integer.parseInt(operands[0]);
            b = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Используются одновременно разные системы счисления");
        }

        if (a > 10 || b > 10) {
            throw new Exception("Не удовлетворяет условиям задания");
        }

        int arab = calc(a, b, oper);
        if (isRoman) {
            if (arab <= 0) {
                throw new Exception("в римской системе нет отрицательных чисел");
            }
            res = Roman.conToRoman(arab);
        } else {
            res = String.valueOf(arab);
        }
        return res;
    }


    class Roman {
        static String[] romanArray = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C" };
        static boolean isRoman(String val) {
            for (int i = 0; i < romanArray.length; i++) {
                if (val.equals(romanArray[i])) {
                    return true;
                }
            }
            return false;
        }

        static int conToArab(String roman) {
            for (int i = 0; i<romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }

        static String conToRoman(int arab) {
            return romanArray[arab];
        }


    }


    static String detOper(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else return "/";
    }

    static int calc(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a/b;
    }






}