/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class Node<T> {
    protected Node<T> next;
    protected Node<T> prev;
    protected T value;

    public void setNext(Node<T> n){
        next = n;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setPrev(Node<T> l){
        prev = l;
    }

    public Node<T> getPrev(){
        return prev;
    }

    public void setValue(T v){
        value = v;
    }

    public T getValue(){
        return value;
    }



}
