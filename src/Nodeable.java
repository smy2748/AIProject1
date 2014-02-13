/**
 * Created by Stephen Yingling on 2/7/14.
 * An interface that values of Node objects in my Dequeues and Stacks should adhere to
 */
public interface Nodeable {
    boolean isEqual(Nodeable c);
    String getValueAsString();
}
