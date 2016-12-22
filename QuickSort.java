import java.util.Random;

/**
 * Created by oscar on 12/20/2016.
 */
public class QuickSort {

    public void quickSort(int[] array,int start, int end){
        if(start < end){ // base code
            int partitionIndex = RandomPartition(array,start,end); // function will pick random partition
            quickSort(array,start,partitionIndex-1); // will sort elements to the left of pivot
            quickSort(array,partitionIndex+1, end); // sorts elements to the right of pivot
        }
    }

    public int RandomPartition(int[] array, int start, int end){
        Random random = new Random();
        int pIndex = start + random.nextInt(end-start+ 1); // pick random number
        int pivot = array[pIndex]; // use random number to get random array element
        int swapIndex = array[end];
        array[end] = array[pIndex]; // swap last array element with chosen random element. This prevents from largest or smallest number to be choosen from array which would slow down run time
        array[pIndex] = swapIndex;

//        int pivot = array[end];
        int index = start;
        for(int i=start; i<end; i++){
            if(array[i] <= pivot){ // if array element is less then the pivot, swap with the index element
                int foo = array[i];
                array[i] = array[index];
                array[index] = foo;
                index++; // increment the index pointer
            }
        }
        int swap = array[index]; // this will swap the pivot with the index element. All the numbers left to pivot is less then pivot and numbers right to pivot are greater then pivot
        array[index] = array[end];
        array[end] = swap;
        return index;
    }



    public static void main(String [] args){
        int [] array = {7,2,1,6,8,5,-1,3,4,0,20};
        int start = 0;
        int end = array.length-1;
        QuickSort qs = new QuickSort();
        qs.quickSort(array,start,end);

        for(Integer element:array){
            System.out.print(element + " ");
        }
    }
}
