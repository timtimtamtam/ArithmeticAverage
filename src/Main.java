import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a;
        int b;
        System.out.println("Введите первое число диапазона. Принимаются только целые числа.");
        if (sc.hasNextInt()) {
            a = sc.nextInt();
            System.out.println("Введите второе число диапазона Принимаются только целые числа.");
            if (sc.hasNextInt()) {
                b = sc.nextInt();
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

        if (a == 0 && b == 0) {
            System.out.println("Нулевой диапазон");
            return;
        }

        // Добавил именно в массив потому что хотел использовать методы max, min.
        int[] d = {a, b};
        System.out.println("Вы ввели: " + a + " " + b);
        int max = IntStream.of(d).max().getAsInt(); //https://ru.stackoverflow.com/questions/436370/
        int min = IntStream.of(d).min().getAsInt();
        System.out.println("Начало диапазона: " + min + ". Конец диапазона: " + max + ".");

        // Но для заполнения диапазона пришлось использовать список, т.к.
        // задать размер массива равный длине диапазона на этом моменте не понял как.

        ArrayList<Integer> numbersList = new ArrayList<>();

        // Перекладываем из массива в список.
        for (int i = min; i <= max; i++) {
            numbersList.add(i);
        }
        System.out.println("Получившийся диапазон: " + numbersList);

        // Задаем размер массива равным размеру списка
        int[] nubmers = new int[numbersList.size()];
        int sizeNumList = numbersList.size();

        // https://javarush.com/groups/posts/2863-java-list-to-array-preobrazuem-spisok-ehlementov-v-massiv

        ArrayList<Integer> numbersList1 = new ArrayList<>();
        // Теперь перекладываем в массив из списка по индексам элементов.
        for (int i = 0; i < sizeNumList; i++) {
            int y = numbersList.get(i);
            nubmers[i] = y;
            if (y % 2 == 0) {
                numbersList1.add(y);
            }
        }

        int[] nubmers1 = new int[numbersList1.size()];

        int sizeNumList1 = numbersList1.size();
        for (int i = 0; i < sizeNumList1; i++) {
            nubmers1[i] = numbersList1.get(i);
        }

        System.out.println("Диапазон четных чисел: " + numbersList1);

        double aveTwo = IntStream.of(nubmers1).average().orElse(0.0);
        double ave = IntStream.of(nubmers).average().orElse(0.0);

        System.out.println("Среднее арифметическое четных чисел из диапазона: " + aveTwo);
        System.out.println("Среднее арифметическое диапазона: " + ave);
    }
}