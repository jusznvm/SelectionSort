
public class ListGenerator {

    public static int[] getNewList(int size){
        int[] arrayList = new int[size];

        for (int i = 0; i < size; i++){
            int x = (int) (Math.random() * 100 + 1);
            arrayList[i] = x;
        }

        return arrayList;
    }

    public static void testArray(int[] unsortedList){
        System.out.println("IN testArray METHOD TESTING ARRAY");
        for(int i = 0; i < unsortedList.length; i++){
            System.out.println(unsortedList[i]);
        }
    }
}
