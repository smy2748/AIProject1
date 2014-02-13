/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class Node<T> {
    protected Node<T> next; //Next Node
    protected Node<T> prev; //Previous Node
    protected T value;      //Value of this Node

    /**
     * Set the Next Node
     * @param n The next node
     */
    public void setNext(Node<T> n){
        next = n;
    }

    /**
     *
     * @return The next Node or null if no next Node
     */
    public Node<T> getNext(){
        return next;
    }

    /**
     * Sets the previous Node
     * @param l The previous Node
     */
    public void setPrev(Node<T> l){
        prev = l;
    }

    /**
     * Gets the previous Node
     * @return The previous Node
     */
    public Node<T> getPrev(){
        return prev;
    }

    /**
     * Set this Node's value
     * @param v This node's value
     */
    public void setValue(T v){
        value = v;
    }

    /**
     *
     * @return This Node's value
     */
    public T getValue(){
        return value;
    }



}
