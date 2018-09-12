import java.util.ArrayList;

public class SelectionSort implements Runnable{


    private int[] arrToSort;

    public SelectionSort() {

    }

    public SelectionSort(int[] arr) {
        this.arrToSort = arr;
    }

    public void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int index = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[index]) {
                    index = j;
                }
                int smallerNumber = arr[index];
                arr[index] = arr[i];
                arr[i] = smallerNumber;
            }
        }
        arrToSort = arr;
    }

    public int[] getArray() {
        return arrToSort;
    }


    @Override
    public void run() {
        sort(arrToSort);
    }
}
