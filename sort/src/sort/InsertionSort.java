package sort;

/**
 * @author pengjw
 * @date 2019年05月27日 15:06
 * @description 插入排序
 * @Version 1.0
 */

public class InsertionSort {

    public static void main(String[] args) {
        int[] arrays = {9, 2, 1, 3, 5};
        arrays = insertionSort(arrays);
        for (int array : arrays) {
            System.out.println("array=" + array);
        }

    }

    /**
     * @param data
     * @return int[]
     * @author pengjw
     * @date 2019/5/27 15:07
     * @description 插入排序
     */
    public static int[] insertionSort(int[] data) {
        int n = data.length;
        if (n <= 1) return data;
        for (int i = 1; i < n; ++i) {
            int value = data[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (data[j] > value) {
                    data[j + 1] = data[j];  // 数据移动
                } else {
                    break;
                }
            }
            data[j + 1] = value; // 插入数据

        }
        return data;
    }

}
