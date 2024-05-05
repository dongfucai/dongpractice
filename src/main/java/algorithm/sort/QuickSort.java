package algorithm.sort;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/3/22 下午11:22
 * @Version 1.0
 **/

public class QuickSort {

    static int partion(int arr[], int low, int high) {

        int i = low;
        int j = high;
        int povit = arr[i];

        while(i < j) {
            while(i < j && povit <= arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && povit >= arr[i]) {
                ++i;
            }
            arr[j] = arr[i];
        }
        arr[i] = povit;

        return i;
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partion(arr, low, high);

        quickSort(arr, low, mid - 1);
        quickSort(arr, mid + 1, high);

    }

    static  void bubbleSort(int arr[], int n) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length -1; ++j) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    //swap(arr[i], arr[j]);
                }
            }
        }
    }
    public static void main(String[] args) {


        int a = 'a';

        short s=2; boolean b=s==2;

//        int i=10; short d=i+10;

        int arr[] = {3,4,-34,78,3,5,90};
        //quickSort(arr, 0, arr.length - 1);
        bubbleSort(arr, arr.length);
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }

    }
}
