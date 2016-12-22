/**
 * Created by oscar on 12/16/2016.
 */
public class SelectionSort {
    public int[] selectStore(int[] arr){
        for(int i = 0; i < arr.length - 1; i++) {
            int min = arr[i]; // min is the element of current array pointer
            int minInd = i; // mindInd is the index of current array pointer
            for(int j = i+1; j< arr.length; j++){
                if(arr[j] < min){ // if j pointer element is less then min
                    min = arr[j]; // min get value of current j pointer element
                    minInd = j; // mindInd gets index of current j pointer element
                }
            }
            //swap arr[i] with arr[mindInd]
            arr[minInd] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    public void printArray(int[] arr){
        for(Integer element:arr){
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args){
        SelectionSort insert = new SelectionSort();
        int array [] = {7,2,4,1,5,3};
        array = insert.selectStore(array);
        insert.printArray(array);
    }
}
