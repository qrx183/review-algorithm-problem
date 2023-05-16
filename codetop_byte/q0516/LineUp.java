package codetop_byte.q0516;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineUp {
    private static int[] suList = new int[10000000];
    static {
        suList[2] = 1;
        for(int i = 3; i <= suList.length; i++) {
            boolean isSu = true;
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    isSu = false;
                    break;
                }
            }
            if(isSu) {
                suList[i] = 1;
            }

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            l.add(i);
        }
        int number = 1;
        int index = 0;
        while(l.size() > 1) {
            if(suList[number] == 1) {
                l.remove(index);
                index -= 1;
            }
            number++;
            index = (index + 1) % l.size();
        }
        System.out.println(l.get(0));


    }
}
