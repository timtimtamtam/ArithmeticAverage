import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
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
            }
        } else {
            System.out.println("Вы ввели некорректный символ");
            sc.close();
        }

        if (a == 0 && b == 0) {
            System.out.println("Нулевой диапазон");
            return;
        }

        // Добавил именно в массив потому что хотел использовать методы max, min.
        int[] d = {a, b};
        System.out.println("Вы ввели: "+ a +" "+ b);
        int max = IntStream.of(d).max().getAsInt(); //https://ru.stackoverflow.com/questions/436370/
        int min = IntStream.of(d).min().getAsInt();
        System.out.println("Начало диапазона: "+ min + ". Конец диапазона: "+ max + ".");

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
        int p = numbersList.size();

        // https://javarush.com/groups/posts/2863-java-list-to-array-preobrazuem-spisok-ehlementov-v-massiv

        // Теперь перекладываем в массив из списка по индексам элементов.
        for (int i = 0; i < p; i++) {
            nubmers[i] = numbersList.get(i);
        }

        double ave = IntStream.of(nubmers).average().orElse(0.0);

        System.out.println("Среднее арифметическое диапазона: " + ave);
    }
}