import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar on 12/19/2016.
 */
public class MergeSort  {
    public int[] mergesort(int[] C){
        int foo = 0;
        int len = C.length;
        if(len <= 1){ // base case when length of array is 1
            return C;
        }
        int x=(int) Math.floor(len/2); // convert to int after taking floor
        int [] left = new int[x]; // first half of array
        int [] right = new int[len - x]; // second half of array
        for(int i=0; i<x;i++){ // insert elements in left side of array
            left[i] = C[i];
        }
        for(int i=x; i<len;i++){ // insert elements in right side of array
            right[foo++] = C[i];
        }
        int [] leftSort = mergesort(left); // recursive call of left side of array
        int [] rightSort = mergesort(right);
        return merge(C,leftSort,x,rightSort,len-x); // merge left and right side of array
    }

    public int[] merge(int[] C,int[]leftSort,int leftCount, int[] rightSort, int rightCount){ // leftCount is size of left array and rightCount is size of right array
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftCount && j < rightCount){ // while both indexes of array is less then its corresponding array's size
            if(leftSort[i] < rightSort[j]){ // if left element is less then right element of array
                C[k] = leftSort[i]; // main array gets value of array's left element
                i++;
            }
            else{
                C[k] = rightSort[j]; // else main array gets value of array's right element
                j++;
            }
            k++; // increment index of main array
        }
        // in case not all elements were iterating in while loop
        while(i <leftCount) C[k++] = leftSort[i++]; // if there's still elements not iterated in left side then main array gets that element
        while(j <rightCount) C[k++] = rightSort[j++]; // else main array gets element of right side of array that were not iterated
        return C; // return the modified main array
    }

    public static void main(String [] args){
        int [] foo = {2,4,1,9,10,6,8,5,3,7,20};
        MergeSort ms = new MergeSort();
        ms.mergesort(foo);
        for(Integer element:foo){
            System.out.print(element + " ");
        }
    }
}
