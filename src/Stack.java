/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class Stack<T extends Nodeable> {
    protected Node<T> head;
    protected int length;

    public Stack(){
        length = 0;
    }
    public void push(T value){
        Node<T> n = new Node<T>();
        n.setValue(value);
        if(head != null){
            n.setNext(head);
            head.setPrev(n);
        }
        length++;
        head = n;
    }

    public void clear(){
        head = null;
        length = 0;
    }

    public T pop(){
        if(head == null){
            return null;
        }
        Node<T> n = head;
        head = head.getNext();
        if(head != null){
            head.setPrev(null);
        }
        length--;
        return n.getValue();
    }

    public T peek(){
        if (head == null){
            return null;
        }
        return head.getValue();
    }

    public int getLength(){
        return length;
    }

    public boolean isInStack(T value){
        return _doesNodeHaveValue(value, head);
    }

    public String getStringRepresentation(){
        String result = "{";
        result += _aggregateStrings(head)+ "}";
        return result;
    }

    private String _aggregateStrings(Node<T> n){
        String delim = ",";
        if(n== null){
            return "";
        }
        if(n.getNext() == null){
            delim = "";
        }
        String s;
        T t = n.getValue();
        if(t == null){
            s = "";
        }
        else{
            s= t.getValueAsString();
        }
        return s + delim + _aggregateStrings(n.getNext());
    }

    private boolean _doesNodeHaveValue(T value, Node<T> n){
        if(n==null){
            return false;
        }
        if(n.getValue().isEqual(value)){
            return true;
        }
        return _doesNodeHaveValue(value, n.getNext());
    }



}
