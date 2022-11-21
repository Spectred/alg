package math.common;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class NthDigit_400 {
    public static void main(String[] args) {
        int nthDigit = new NthDigit_400().findNthDigit(10000000);
        System.out.println(nthDigit);
    }

    public int findNthDigit(int n) {
        String collect = IntStream.range(1, n + 1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(collect);
        char c = collect.charAt(n - 1);
        return Integer.parseInt(Character.toString(c));
    }
}