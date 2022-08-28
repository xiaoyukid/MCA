package ch1;

/* package codechef; // don't place package name! */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int sum = n1 + n2 + n3;
        Set<Integer> idSet = new HashSet<>();
        Set<Integer> finalSet = new HashSet<>();

        for (int i = 0; i < sum; i++) {
            int voterId = in.nextInt();
            if (!idSet.add(voterId)) {
                finalSet.add(voterId);
            }
        }
        System.out.println(finalSet.size());
        finalSet.stream().sorted().forEach(System.out::println);
    }
}
