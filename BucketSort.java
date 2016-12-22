import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar on 12/19/2016.
 */
public class BucketSort {
    int size;
    int max;
    int min;
    int bucketSize;
    int divider;

    public BucketSort(int [] array){
        this.size = array.length;
        this.bucketSize = 10;
        this.divider = 0;
    }

    public void initialize(int[] array){
        this.max = array[0];
        this.min = array[0];
        for(int i=0; i<size;i++){
            if(array[i] < min){
                min = array[i]; // gets smallest element of array
            }
            else if(array[i] > max){
                max = array[i]; // gets largest element of array
            }
        }
        divider = (int) Math.ceil((max + 1) / bucketSize) + 1; // divider number is the number which will be divided by element of array
        sort(array);
    }

    public void sort(int[] array){
        List<List<Integer>> buckets = new ArrayList<>(bucketSize); // initialize an array list of integers
        for(int i=0; i<bucketSize;i++){
            buckets.add(new ArrayList<>()); // create an array list with no elements
        }

        for(int i =0; i < size; i++){
            int foo = (int)Math.floor(array[i]/divider);
            buckets.get(foo).add(array[i]); // get the index of array list in which the main array's element will be inserted. Ex: if foo outputs 9 then in index 9 of array list insert the value in which index of main array is pointing to
        }
          //  System.out.print(buckets.get(5) + " " + buckets.get(5).size()); // debug
        int index = 0;
        for(int i =0; i < buckets.size(); i++){ // will loop till end of bucket size
            Integer[] bucketArray = new Integer[buckets.get(i).size()]; // make array of type Integer that will have size of list in specified index. Ex: index 0 of bucket array list has  size 2 since there are two list elements
            bucketArray = buckets.get(i).toArray(bucketArray); //get the values in the list, like [8,12], and convert the list into an array
            insertionSort(bucketArray); // send the new array to insertionSort to be sorted

            // add the new sorted elements into main array overriding old elements
            for(int j =0; j < bucketArray.length; j++){
                array[index++] = bucketArray[j];
            }
        }

        for(int element: array){ // print out new sorted array
            System.out.print(element + " ");
        }
    }

    public Integer[] insertionSort(Integer[] arr){
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

    public static void main(String [] args){
        int array[] = {22,45,12,8,10,6,72,81,33,18,50,14};
        BucketSort bs = new BucketSort(array);
        bs.initialize(array);

    }
}
