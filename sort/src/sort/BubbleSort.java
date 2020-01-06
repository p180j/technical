package sort;

/**
 * @author pengjw
 * @date 2019年05月27日 14:27
 * @description 冒泡排序
 * @Version 1.0
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] data = new int[]{1, 4, 7, 2, 5};
        data = bubbleSort(data, data.length);
        for (int i : data) {
            System.out.println("data =" + i);
        }

    }

    /**
     * @param data
     * @param n
     * @return int[] 需要排序的数组 n 数组的个数
     * @author pengjw
     * @date 2019/5/27 15:04
     * @description 冒泡是稳定和原地排序算法
     */
    public static int[] bubbleSort(int[] data, int n) {
        if (n <= 1) return data;
        //最外层循环比较的几个元素需要比较，内存元素是每个元素需要比较多少次
        for (int i = 0; i < n; i++) {
            //需要注意的是需要减1，因为j+1会越界
            for (int j = i; j < n - 1; j++) {
                boolean flag = false;
                if (data[j] > data[j + 1]) {
                    int temp;
                    temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                    flag = true;  // 表示有数据交换
                }
                if (!flag) break;
            }
        }
        return data;
    }
}
