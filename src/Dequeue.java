/**
 * Created by Stephen Yingling on 2/7/14.
 *
 * A partial implementation of a double ended queue.
 * I found that I didn't really need to ever access the tail
 */
public class Dequeue<T extends Nodeable> {
    protected Node<T> head; //The front of the dequeue
    protected Node<T> tail; //The end of the queue
    int length;             //The length of the queue


    /**
     * Create a Dequeue object
     * Initialize length = 0
     */
    public Dequeue(){
        length =0;
    }

    //Get the head
    public Node<T> getHead(){
        return head;
    }

    //Get the tail
    public Node<T> getTail(){
        return tail;
    }


    /**
     * Adds a value to the queue
     * @param n The value to add
     */
    public void queue(T n){
        Node<T> t= new Node<T>();
        t.setValue(n);
        if(head == null){
            head = t;
            tail = t;
        }
        else{
            tail.setNext(t);
            t.setPrev(tail);
            tail = t;
        }
        length++;
    }

    /**
     * Resets the queue to be blank
     * Might be bad if something causes the Garbage Collection not to clean up the non-referenced nodes
     */
    public void clear(){
        head = null;
        tail = null;
        length = 0;
    }


    /**
     * Remove the first thing from this dequeue
     */
    public void removeHead(){
        if(head != null){
            head = head.getNext();
            length--;
        }
        if(head != null){
            head.setPrev(null);
        }
    }

    /**
     * Check if a calue is in the queue
     * @param val The value to check
     * @return True if the value exists in the queue, false if not
     */
    public boolean inQueue(T val){
        return _isInQueue(val,head);
    }

    /**
     * Recursively determines if a value is in the queue
     * @param val The value to look for
     * @param p The node being currently checked
     * @return True if the value exists in the queue, false if not
     */
    private boolean _isInQueue(T val, Node<T> p){
        if (p == null){
            return false;
        }
        if(p.getValue().isEqual(val)){
            return true;
        }
        return _isInQueue(val,p.getNext());
    }

    /**
     * print the queue
     */
    public void printQueue(){
        String s = "{";
        s += _aggregateNodes(head);
        s+="}";

        System.out.print(s);
    }

    /**
     *
     * @return The string representation of this queue
     */
    public String getStringRepresentation(){
        String s = "{";
        s += _aggregateNodes(head);
        return s +"}";
    }

    /**
     * Recursively create a string representation of a queue
     * @param n The current Node being examined
     * @return The string representation of the queue
     */
    private String _aggregateNodes(Node<T> n){
        String delim = ",";
        if(n == null){
            return "";
        }
        if(n.getNext() == null){
            delim ="";
        }

        return n.getValue().getValueAsString() + delim + _aggregateNodes(n.getNext());
    }

    /**
     *
     * @return The length of the queue
     */
    public int getLength(){
        return length;
    }


}
