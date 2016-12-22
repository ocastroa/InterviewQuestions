import java.util.Random;

/**
 * Created by oscar on 12/21/2016.
 * Creates a hash table with chains. The hash table corresponds to bookshelves.
 */
public class hashTable {

    private final int shelfSize = 11;
    linkHashTable[] shelves;

    hashTable(){ // constructor
        shelves = new linkHashTable[shelfSize]; // initialize an array of size shelfSize
        for(int i=1; i< shelfSize; i++){ // make an array of size 10 filled with null values. Elements of array will have first entry of linked list once new values are inserted
            shelves[i] = null;
        }
    }

    public void insertToShelf(String word){
        int hash = word.hashCode() % shelfSize; // output a hash number from function
        if(hash < 0){
            hash = (-1 * hash); // if hash value is negative convert to positive since hash value will correspond to array index
        }
        else if(hash == 0){
            hash++;
        }
        if(shelves[hash] == null){ // if element of array index is null, the new element is the word. The next pointer is set to null
            shelves[hash] = new linkHashTable(word,hash);
        }
        else{
            linkHashTable curr = shelves[hash]; // curr gets value of shelves[hash]
            while(curr.getNext() != null){ // goes down the chain of array index
                curr = curr.getNext(); // if next value is not null then keep going down the chain
            }
            curr.setNext(new linkHashTable(word,hash)); // create a new node with new value and place it down the chain
        }
    }

    public void getShelfNumber(String word){
        int hash = word.hashCode() % shelfSize; // get hash code
      //  int row = (int)(Math.random() * 4 + 1);
        Random ran = new Random();
        int row = ran.nextInt((4) + 1) + 1;
        if(hash < 0){
            hash = (-1 * hash);
        }
        if(shelves[hash] == null){
           return;
        }
        else{
            linkHashTable curr = shelves[hash];
            while(curr.getValue() != word){
                curr = curr.getNext();
                if(curr == null){ // if the word is not found then output below message
                    System.out.println(word+ " is not found on any shelf");
                    return;
                }
            }
            System.out.println(curr.getValue() + " is on shelf " + curr.getKey() + " row " + row);
        }
    }

    public void removeFromShelf(String word){
        int hash = word.hashCode() % shelfSize;
        if(hash < 0){
            hash = (-1 * hash);
        }
        if(shelves[hash] == null){
            return;
        }
        else{
            linkHashTable prev = null;
            linkHashTable curr = shelves[hash];
            while(curr.getNext() != null && curr.getValue() != word){ // go down the chain as long as there is a next node and the word has not been found
                prev = curr; // previous gets values from current node
                curr = curr.getNext(); // current node is shifted to node down chain
            }
            if(curr.getValue() == word){ // if the word is found
                if(prev == null){ // if previous is node which means that value is in the array and not in a chain
                    shelves[hash] = curr.getNext(); // new array value becomes the value of next node
                }
                else{
                    prev.setNext(curr.getNext()); // else previous value becomes currents next value
                }
                curr = null; // current value becomes null
            }
        }
    }

    public static void main(String [] args){
        hashTable ht = new hashTable();
        ht.insertToShelf("Harry Potter and the Sorcerer's Stone");
        ht.insertToShelf("Harry Potter and the Goblet of Fire");
        ht.insertToShelf("Narnia");
        ht.insertToShelf("The Great Gatsby");
        ht.insertToShelf("Harry Potter and the Order of the Phoenix");
        ht.insertToShelf("Harry Potter and the Prisoner of Azkaban");
        ht.insertToShelf("Narnia two");
        ht.insertToShelf("Of Mice and Men");
        ht.insertToShelf("The Wolf of Wall Street");
        ht.insertToShelf("A Child call It");
        ht.insertToShelf("Of River and Time");
        ht.insertToShelf("War and Peace");
        ht.insertToShelf("Fantastic Beasts and where to find them");
        ht.insertToShelf("Surely you're joking Mr. Feynman");
        ht.insertToShelf("The Invisible Man");
        ht.insertToShelf("Huckleberry Finn");
        ht.insertToShelf("Death of a Salesman");
        ht.insertToShelf("Hamlet");
        ht.insertToShelf("Romeo and Juliet");
        ht.insertToShelf("Oedipus Rex");

        ht.getShelfNumber("Of River and Time");
        ht.getShelfNumber("Hamlet");
        ht.getShelfNumber("Narnia two");
        ht.getShelfNumber("Oedipus Rex");
        ht.getShelfNumber("Johnson");
        ht.getShelfNumber("A Child call It");
        ht.getShelfNumber("The Wolf of Wall Street");
        ht.getShelfNumber("The Great Gatsby");
        ht.getShelfNumber("Surely you're joking Mr. Feynman");

       // ht.removeFromShelf("Of Mice and Men");

      //  ht.getShelfNumber("Of Mice and Men");



    }

}
















