import java.util.*;
import java.util.stream.Collectors;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/200d8d789f9f431999fac795bb094356
 * 来源：牛客网
 * <p>
 * 给定一个数字arr，其中只有有两个数字出现了奇数次，其它数字都出现了偶数次，按照从小到大顺序输出这两个数。
 * <p>
 * 输入描述:
 * 输入包含两行，第一行一个整数n(1 \leq n \leq 10^5)(1≤n≤10
 * 5
 * )，代表数组arr的长度，第二行n个整数，代表数组arr,arr[i]为32位整数。
 * <p>
 * <p>
 * 输出描述:
 * 输出出现奇数次的两个数，按照从小到大的顺序。
 * <p>
 * 4
 * 1 1 2 3
 * <p>
 * 2 3
 * <p>
 * <p>
 * <p>
 * 6
 * 11 22 11 23 23 45
 * <p>
 * 22 45
 */
public class Main {

    public static void main(String[] args) {
        find1(6, List.of(11, 45, 11, 23, 23, 22));

        int[] arr = {11, 45, 11, 23, 23, 22};
        find2(6, arr);
    }

    private static void find1(int count, List<Integer> list) {
        System.out.println("find1: count=" + count + ",list:" + list.toString());
        System.out.println("result:");

        list.stream().collect(Collectors.groupingBy(x -> x))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() % 2 == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .forEach(System.out::println);
    }


    private static void find2(int count, int[] arr) {
        System.out.println("find2: count=" + count + ",arr:" + Arrays.toString(arr));
        System.out.println("result:");
        Arrays.sort(arr);
        Map<Integer, Integer> window = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];
            window.put(k, window.getOrDefault(k, 0) + 1);
            Integer integer = window.get(k);
            if (integer % 2 != 1) {
                window.remove(k);
            }
        }
        window.keySet().forEach(System.out::println);
    }

}