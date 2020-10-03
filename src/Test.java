
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;


        while (true) {
            try {
                System.out.println("Ведите выражение");// По условию нужно было через пробел вводить
                string = scanner.nextLine();
                String[] list = string.split(" ");
                if (list.length == 3 && contains(list[1])) { // проверка что 2 числа и знак, который нам нужен
                    switch (ArAndRom(list[0], list[2])) {//  проверка на сложение разных типов, а так же размер чисел

                        case 0:
                            System.out.println("Ответ:");
                            System.out.println(Operation(list)+"\n");// функция операций с арабскими числами
                            break;
                        case 1:
                            System.out.println("Ответ:");
                            System.out.println(Operation1(list)+"\n");// функция операций с римскими числами(внутри него
                            break;                                //сначала перевожу в арабские и вызываю предыдущий метод

                        case 2:
                            throw new Exception("Неверно введены данные!");


                    }
                } else {
                    throw new Exception("Неверно введены данные!");

                }


            } catch (Exception e) {
                e.printStackTrace();
                break;
            }


        }

    }

    public static boolean contains(String s) {
        boolean b = false;
        String[] operations = {"+", "-", "*", "/"};
        for (String l : operations
        ) {
            if (l.equals(s)) {
                b = true;
                break;

            }
        }

        return b;
    }

    public static int ArAndRom(String s1, String s2) {
        int i1, i2;
        try {
            i1 = Integer.parseInt(s1);
            i2 = Integer.parseInt(s2);
            if (i1 > 0 && i1 < 11 && i2 > 0 && i2 < 11) {
                return 0;
            }
            return 2;
        } catch (Exception e) {
            try {
                Roman r1 = Roman.valueOf(s1);
                Roman r2 = Roman.valueOf(s2);
                if (r1.getArab() > 0 && r1.getArab() < 11 && r2.getArab() > 0 && r2.getArab() < 11) {
                    return 1;
                }
                return 2;
            } catch (Exception l) {
                return 2;
            }
        }

    }

    private static int Operation(String[] s) {
        int i1, i2;
        i1 = Integer.parseInt(s[0]);
        i2 = Integer.parseInt(s[2]);

        if (s[1].equals("+")) {
            return i1 + i2;
        } else if (s[1].equals("-")) {
            return i1 - i2;
        } else if (s[1].equals("*")) return i1 * i2;

        else return i1 / i2;

    }

    private static String Operation1(String[] s) {
        String k = "";
        int res;
        String[] list = {Roman.valueOf(s[0]).getArab() + "", s[1], Roman.valueOf(s[2]).getArab() + ""};
        res = Operation(list);
        if (res==0){
            return 0+k;
        }
        k = Roman.convert(res);
        return k;
    }


}




