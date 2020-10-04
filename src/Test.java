
import java.util.Scanner;

import static methods.Methods.*;

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
                            System.out.println(Operation(list) + "\n");// функция операций с арабскими числами
                            break;
                        case 1:
                            System.out.println("Ответ:");
                            System.out.println(Operation1(list) + "\n");// функция операций с римскими числами(внутри него
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


}




