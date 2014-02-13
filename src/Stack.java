/**
 * Created by Stephen Yingling on 2/7/14.
 *
 * A Stack implementation
 */
public class Stack<T extends Nodeable> {
    protected Node<T> head; //The top of the stack
    protected int length;   //The length of the stack


    /**
     * Create an empty Stack
     */
    public Stack(){
        length = 0;
    }

    /**
     * Push a value onto the stack
     * @param value The value to push onto the stack
     */
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

    /**
     * Remove this stack's refrences to its Nodes
     */
    public void clear(){
        head = null;
        length = 0;
    }


    /**
     * Removes and returns the top value
     * @return The top value in the stack
     */
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


    /**
     *
     * @return The top value
     */
    public T peek(){
        if (head == null){
            return null;
        }
        return head.getValue();
    }


    /**
     *
     * @return The length of the stack
     */
    public int getLength(){
        return length;
    }


    /**
     *Checks if a value is in the stack
     * @param value The value being checked for
     * @return True if the calue is in the stack, false if not
     */
    public boolean isInStack(T value){
        return _doesNodeHaveValue(value, head);
    }


    /**
     *
     * @return The string representation of this stack
     */
    public String getStringRepresentation(){
        String result = "{";
        result += _aggregateStrings(head)+ "}";
        return result;
    }


    /**
     * Recursively create a string representation of all Nodes further down the stack
     * @param n The current Node
     * @return The string representation of all Nodes further down the stack
     */
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


    /**
     * Check if this Node (or any further down the stack) have a value
     * @param value The value to search for
     * @param n The current Node
     * @return True if the value exists, false if not
     */
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
