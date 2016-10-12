package Hesoes;

import java.util.Scanner;

/**
 * Created by user on 13.09.2016.
 */
public class util {
    public static Integer read(String text) {
        Integer i;
        try {
            System.out.print(text + ">");
            System.out.flush();
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка!!! Введен не верный символ");
            return read(text);
        }
        return i;
    }
}
