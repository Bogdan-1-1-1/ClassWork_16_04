import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("src/test.txt")); //сканнеры для ввода с консоли (1) или из файла (2) (раскомментить нужное)

        int n = in.nextInt();
        ArrayList<Ex2Auditory> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Ex2Auditory time = new Ex2Auditory(in.nextInt(), in.nextInt());
            times.add(time);
        }
        SecondExercise(n, times);

    }

    static void FirstExercise(int inSum) {
        int[] money = {500, 200, 100, 50, 20, 10};

        int currSum  = 0;
        int i = 0, valOfBills = 0;

        while(currSum < inSum) {
            if(currSum + money[i] <= inSum) {
                currSum+= money[i];
                valOfBills++;
            } else i++;
            if(i >= money.length) break;
        }

        System.out.println(currSum == inSum ? valOfBills : -1);
    }
    static void SecondExercise(int n, ArrayList<Ex2Auditory> times) {
        Collections.sort(times);

        ArrayList<Ex2Auditory> lessons = new ArrayList<>();
        lessons.add(times.get(0));

        for (int i = 1; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < lessons.size(); j++) {
                if(times.get(i).begin >= lessons.get(j).end) {
                    lessons.get(j).end = times.get(i).end;
                    flag = false;
                    break;
                }
            }
            if(flag) lessons.add(times.get(i));
        }

        System.out.println(lessons.size());
    }
}
