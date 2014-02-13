import java.util.ArrayList;

/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class TreeNode implements Nodeable {
    protected String value; //The value of the Node
    protected ArrayList<TreeNode> children; //The children of the Node
    protected TreeNode parent;  //The parent TreeNode of this node as determined by a search algorithm

    //Standard setter for the parent
    public void setParent(TreeNode p){
        parent = p;
    }

    //Standard getter for the parent
    public TreeNode getParent(){
        return parent;
    }

    /**
     * Get the number of ancestors this node has
     * @return The number of parents this node has
     */
    public int getAncestorChainLength(){
        return _getParentChainLength(parent);
    }

    /**
     * Create a new TreeNode
     */
    public TreeNode(){
        children = new ArrayList<TreeNode>();
    }

    /**
     * Copy this TreeNode
     * @return A copy of this TreeNode
     */
    public TreeNode copy(){
        TreeNode ret = new TreeNode(this.value);
        return new TreeNode(this.value);
    }


    /**
     * Create a new TreeNode
     * @param s The value of this TreeNode
     */
    public TreeNode(String s){
        value = new String(s);
        children = new ArrayList<TreeNode>();
    }

    //Standard getter for value
    public String getValue(){
        return value;
    }

    //Standard setter for value
    public void setValue(String x){
        value = new String(x);
    }

    /**
     * Adds a child to the TreeNode
     * @param m The child to add
     */
    public void addChild(TreeNode m){
        children.add(m);
    }

    /**
     *
     * @return All children of this TreeNode
     */
    public ArrayList<TreeNode> getChildren(){
        return children;
    }

    /**
     * Checks if this Node is equal to another Node
     * @param c The other Node
     * @return True if equal, false if not
     */
    @Override
    public boolean isEqual(Nodeable c) {
        if(c instanceof TreeNode){
            return value.equals(((TreeNode) c).getValue());
        }
        return false;
    }

    /**
     *
     * @return The value of this Node
     */
    @Override
    public String getValueAsString() {
        return value;
    }

    /**
     * Recursively determines the number of ancestors a TreeNode has
     * @param p A TreeNode
     * @return The number of ancestors a TreeNode has + 1
     */
    private int _getParentChainLength(TreeNode p){
        if(p == null){
            return 0;
        }
        return 1 + _getParentChainLength(p.getParent());
    }

    /**
     *
     * @return The path to this TreeNode in string format
     */
    public String getPathAsString(){
        return _getParentPath(this);
    }

    /**
     * Recursively creates a string representation of the path to a TreeNode
     * @param t A TreeNode
     * @return The path to T
     */
    private String _getParentPath(TreeNode t){
        String delim = " -> ";
        if(t == null){
            return "";
        }
        if(t.getParent() == null){
            delim = "";
        }
        return t._getParentPath(t.getParent()) + delim + t.getValueAsString();
    }
}
