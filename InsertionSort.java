/**
 * Created by oscar on 12/16/2016.
 */
public class InsertionSort {
    public int[] insertStore(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int j = i; // j get value of i
            int foo = arr[i]; // foo gets value of element arr[i]
            while(j > 0 && arr[j-1] > foo){
                arr[j] = arr[j-1]; //swap current element with previous element
                j--; // decrement j
            }
            arr[j] = foo; // previous element gets value of current element that was stored in foo
        }
        return arr;
    }

    public void printArray(int[] arr){
        for(Integer element:arr){
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args){
        InsertionSort insert = new InsertionSort();
        int array [] = {7,2,4,1,5,3};
        array = insert.insertStore(array);
        insert.printArray(array);

    }
}
