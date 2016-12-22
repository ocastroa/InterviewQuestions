/**
 * Created by oscar on 12/21/2016.
 */
public class linkHashTable {
    private String title;
    private int shelf;
    private linkHashTable next;

    linkHashTable(String title, int shelf){
        this.title = title;
        this.shelf = shelf;
        this.next = null;
    }

    public String getValue() {
        return title;
    }

    public int getKey() {
        return shelf;
    }

    public linkHashTable getNext() {
        return next;
    }

    public void setNext(linkHashTable next) {
        this.next = next;
    }
}