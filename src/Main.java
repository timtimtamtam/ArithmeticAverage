import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int firstInputInt;
        int secondInputInt;

        System.out.println("Введите первое число диапазона. Принимаются только целые числа.");
        if (sc.hasNextInt()) {
            firstInputInt = sc.nextInt();
            System.out.println("Введите второе число диапазона Принимаются только целые числа.");
            if (sc.hasNextInt()) {
                secondInputInt = sc.nextInt();
                sc.close();
            } else {
                System.out.println("Вы ввели некорректный символ");
                sc.close();
                return;
            }
        } else {
            System.out.println("Вы ввели некорректный символ");
            sc.close();
            return;
        }

        if (firstInputInt == secondInputInt) {
            System.out.println("Диапазон из одного числа");
            System.out.println(firstInputInt);
            return;
        }

        int[] d = {firstInputInt, secondInputInt};

        System.out.println("Вы ввели: " + firstInputInt + " " + secondInputInt);
        int max = IntStream.of(d).max().getAsInt();
        int min = IntStream.of(d).min().getAsInt();
        System.out.println("Начало диапазона: " + min + ". Конец диапазона: " + max + ".");


        double totalSum = 0;
        double evenSum = 0;
        double totalCount = 0;
        double evenCount = 0;

        for (int i = min; i <= max; i++) {
            totalSum += i;
            if (i%2==0) {
                evenSum += i;
                evenCount += 1;
            }
            totalCount +=1;
        }

        double average = totalSum / totalCount;
        double evenAverage = evenSum / evenCount;

        System.out.println("Среднее арифметическое четных чисел из диапазона: " + evenAverage);
        System.out.println("Среднее арифметическое диапазона: " + average);
    }
}