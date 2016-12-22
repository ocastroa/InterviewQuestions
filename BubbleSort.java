/**
 * Created by oscar on 12/16/2016.
 */
public class BubbleSort {
    public int[] bubbleStore(int[] arr){
       for(int i = 0; i < arr.length-1;i++){
           for(int j = 1; j<arr.length; j++){
               if(arr[j-1] > arr[j]){ //if previous element is greater then current element swap
                   int foo = arr[j-1]; // foo stores previous element
                   arr[j-1] = arr[j]; // swap so that previous element gets current element
                   arr[j] = foo; // current element gets previous element
               }
           }
       }
        return arr;
    }

    public void printArray(int[] arr){
        for(Integer element:arr){
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args){
        BubbleSort insert = new BubbleSort();
        int array [] = {7,2,4,1,5,3};
        array = insert.bubbleStore(array);
        insert.printArray(array);
    }
}
