import java.util.List;

public class Main{

    private int[] arr;
    private SelectionSort se;

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        se = new SelectionSort(ListGenerator.getNewList(1000));
        System.out.println("UNSORTED LIST : \n");
        ListGenerator.testArray(se.getArray());

        System.out.println("SORTING....");
        TwoThreadSort(se.getArray());
    }

    public void SingleThreadSort(int[] arrToSort) {
        int[] arr = null;
        arr = arrToSort.clone();
        ListGenerator.testArray(arr);
        se.sort(arr);
    }

    public int[] mergeArrays(int[] arr1, int[] arr2) {
        int arrSize = (arr1.length +  arr2.length);
        int[] mergedArray = new int[arrSize];

        for(int i = 0; i < arr1.length; i++) {
            mergedArray[i] = arr1[i];
        }

        for(int i = 0; i < arr2.length; i++) {
            mergedArray[arr2.length + i] = arr2[i];
        }

        se.sort(mergedArray);
        ListGenerator.testArray(mergedArray);

        return mergedArray;
    }

    public void TwoThreadSort(int[] arrToSort) {
        int[] arr = null;
        arr = arrToSort.clone();

        int length = arr.length / 2;

        int[] arrFirstHalf = new int[length];
        int[] arrSecondHalf = new int[length];

        for(int i = 0; i < length; i++) {
            arrFirstHalf[i] = arr[i];
        }

        for(int i = 0; i < length; i++) {
            arrSecondHalf[i] = arr[length + i];
        }

        SelectionSort firstArray = new SelectionSort(arrFirstHalf);
        SelectionSort secondArray = new SelectionSort(arrSecondHalf);

        Thread t1 = new Thread(firstArray);
        Thread t2 = new Thread(secondArray);

        t1.run();
        t2.run();

        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            System.out.println("Something went wrong when joining threads, stack below: " + '\n');
            e.printStackTrace();
        }

        mergeArrays(firstArray.getArray(), secondArray.getArray());
    }

}
