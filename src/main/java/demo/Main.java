package demo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ShuHeng on 2018/3/2.
 *
 * 符合要求的重复排列结果：
 * B C A C A C D A B A true
 *
 */
public class Main {

    public static int[] a = {1, 2, 3, 4};
    public static int n = 10;
    public static int[] intArray = new int[n];
    public static ArrayList<Integer> opArray = new ArrayList<>();
    public static int min = 0;
    public static int max = 0;


    public static void main(String[] args) {
        System.out.println();
        System.out.println("符合要求的重复排列结果：");
        repeatableArrangement(n, a);
    }

    /**
     * 可重复排列
     *
     * @param k   选取的元素个数（k层循环）
     * @param arr 数组
     */
    public static void repeatableArrangement(int k, int[] arr) {
        if (k == 1) {
            for (int i = 0; i < arr.length; i++) {
                opArray.add(arr[i]);
                int[] intArray = getIntArray(opArray);
                boolean result = testAnswer(intArray);
                if (result) {

                    for (int j=0;j<intArray.length ;j++) {
                        System.out.print((char)(intArray[j]+64) + " ");
                    }
                    System.out.println(result);
                }
                opArray.remove(opArray.size() - 1); //移除尾部元素
            }
        } else if (k > 1) {
            for (int i = 0; i < arr.length; i++) {
                opArray.add(arr[i]);
                repeatableArrangement(k - 1, arr); //不去重
                opArray.remove(opArray.size() - 1); //移除尾部元素,不能用remove(Object),因为它会移除头部出现的元素，我们这里需要移除的是尾部元素
            }
        } else {
            return;
        }
    }

    /**
     * 获取数组，损失性能，方便写
     * @param tmpArr
     * @return
     */
    private static int[] getIntArray(ArrayList<Integer> tmpArr) {
        for (int i = 0; i < tmpArr.size(); i++) {
            intArray[i] = tmpArr.get(i);
        }
        return intArray;
    }

    /**
     * 验证是否符合题目
     * @param b
     * @return
     */
    public static boolean testAnswer(int[] b) {
        if (test2(b) && test3(b) && test4(b) && test5(b) && test6(b) && test7(b) && test8(b) && test9(b) && test10(b))
            return true;
        return false;
    }

    public static boolean test2(int[] b) {
        switch (b[i(2)]) {
            case 1:
                if (3 == b[i(5)]) {
                    return true;
                }
                break;
            case 2:
                if (4 == b[i(5)]) {
                    return true;
                }
                break;
            case 3:
                if (1 == b[i(5)]) {
                    return true;
                }
                break;
            case 4:
                if (2 == b[i(5)]) {
                    return true;
                }
                break;

        }
        return false;
    }

    public static boolean test3(int[] b) {
        int val;
        switch (b[i(3)]) {

            case 1:
                val = b[i(6)];
                if (b[i(3)] != val && b[i(2)] == val && b[i(4)] == val) {
                    return true;
                }
                break;
            case 2:
                val = b[i(3)];
                if (b[i(6)] != val && b[i(2)] == val && b[i(4)] == val) {
                    return true;
                }
                break;
            case 3:
                val = b[i(3)];
                if (b[i(2)] != val && b[i(6)] == val && b[i(4)] == val) {
                    return true;
                }
                break;
            case 4:
                val = b[i(3)];
                if (b[i(4)] != val && b[i(6)] == val && b[i(2)] == val) {
                    return true;
                }
                break;

        }

        return false;
    }

    public static boolean test4(int[] b) {
        switch (b[i(4)]) {
            case 1:
                if (b[i(1)] == b[i(5)]) {
                    return true;
                }
                break;
            case 2:
                if (b[i(2)] == b[i(7)]) {
                    return true;
                }
                break;
            case 3:
                if (b[i(1)] == b[i(9)]) {
                    return true;
                }
                break;
            case 4:
                if (b[i(6)] == b[i(10)]) {
                    return true;
                }
                break;

        }
        return false;
    }

    public static boolean test5(int[] b) {
        switch (b[i(5)]) {
            case 1:
                if (b[i(5)] == b[i(8)]) {
                    return true;
                }
                break;
            case 2:
                if (b[i(5)] == b[i(4)]) {
                    return true;
                }
                break;
            case 3:
                if (b[i(5)] == b[i(9)]) {
                    return true;
                }
                break;
            case 4:
                if (b[i(5)] == b[i(7)]) {
                    return true;
                }
                break;

        }
        return false;
    }

    public static boolean test6(int[] b) {
        switch (b[i(6)]) {
            case 1:
                if (b[i(8)] == b[i(2)] && b[i(8)] == b[i(4)]) {
                    return true;
                }
                break;
            case 2:
                if (b[i(8)] == b[i(1)] && b[i(8)] == b[i(6)]) {
                    return true;
                }
                break;
            case 3:
                if (b[i(8)] == b[i(3)] && b[i(8)] == b[i(10)]) {
                    return true;
                }
                break;
            case 4:
                if (b[i(8)] == b[i(5)] && b[i(8)] == b[i(9)]) {
                    return true;
                }
                break;

        }
        return false;
    }



    public static boolean test7(int[] b) {
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < (b.length + 1); i++) {
            switch (b[i(i)]) {
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
                case 3:
                    c3++;
                    break;
                case 4:
                    c4++;
                    break;
            }
        }
        map.put(c1, 1); map.put(c2, 2);map.put(c3, 3);map.put(c4, 4);
        min = Math.min(Math.min(c1, c2), Math.min(c3, c4));
        max = Math.max(Math.max(c1, c2), Math.max(c3, c4));
        Integer integer = map.get(min);
        switch (b[i(7)]) {
            case 1:
                if (integer == 3) {
                    return true;
                }
                break;
            case 2:
                if (integer == 2) {
                    return true;
                }
                break;
            case 3:
                if (integer == 1) {
                    return true;
                }
                break;
            case 4:
                if (integer == 4) {
                    return true;
                }
                break;

        }
        return false;
    }

    public static boolean test8(int[] b) {
        switch (b[i(8)]) {
            case 1:
                if (Math.abs(b[i(7)] - b[i(1)]) != 1) {
                    return true;
                }
                break;
            case 2:
                if (Math.abs(b[i(5)] - b[i(1)]) != 1) {
                    return true;
                }
                break;
            case 3:
                if (Math.abs(b[i(2)] - b[i(1)]) != 1) {
                    return true;
                }
                break;
            case 4:
                if (Math.abs(b[i(10)] - b[i(1)]) != 1) {
                    return true;
                }
                break;

        }
        return false;
    }

    public static boolean test9(int[] b) {
        switch (b[i(9)]) {
            case 1:
                if (true == false) {

                }
                if ((b[i(1)] == b[i(6)]) == ((b[i(6)] != b[i(5)]))) {
                    return true;
                }
                break;
            case 2:
                if ((b[i(1)] == b[i(6)]) == ((b[i(10)] != b[i(5)]))) {
                    return true;
                }
                break;
            case 3:
                if ((b[i(1)] == b[i(6)]) == ((b[i(2)] != b[i(5)]))) {
                    return true;
                }
                break;
            case 4:
                if ((b[i(1)] == b[i(6)]) == ((b[i(9)] != b[i(5)]))) {
                    return true;
                }
                break;

        }
        return false;
    }

    public static boolean test10(int[] b) {
        int gap = max - min;
        switch (b[i(10)]) {
            case 1:
                if (gap == 3) {
                    return true;
                }
                break;
            case 2:
                if (gap == 2) {
                    return true;
                }
                break;
            case 3:
                if (gap == 4) {
                    return true;
                }
                break;
            case 4:
                if (gap == 1) {
                    return true;
                }
                break;

        }
        return false;
    }

    public static int i(int order) {
        return order - 1;
    }

}


