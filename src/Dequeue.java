/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class Dequeue<T extends Nodeable> {
    protected Node<T> head;
    protected Node<T> tail;
    int length;

    public Dequeue(){
        length =0;
    }
    public Node<T> getHead(){
        return head;
    }

    public Node<T> getTail(){
        return tail;
    }

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

    public void clear(){
        head = null;
        tail = null;
        length = 0;
    }

    public void removeHead(){
        if(head != null){
            head = head.getNext();
            length--;
        }
        if(head != null){
            head.setPrev(null);
        }
    }

    public boolean inQueue(T val){
        return _isInQueue(val,head);
    }

    private boolean _isInQueue(T val, Node<T> p){
        if (p == null){
            return false;
        }
        if(p.getValue().isEqual(val)){
            return true;
        }
        return _isInQueue(val,p.getNext());
    }

    public void printQueue(){
        String s = "{";
        s += _aggregateNodes(head);
        s+="}";

        System.out.print(s);
    }

    private String _aggregateNodes(Node<T> n){
        if(n == null){
            return "";
        }
        return n.getValue().getValueAsString() + "," + _aggregateNodes(n.getNext());
    }

    public int getLength(){
        return length;
    }


}
