import java.util.ArrayList;

/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class TreeNode implements Nodeable {
    protected String value;
    protected ArrayList<TreeNode> children;
    protected TreeNode parent;


    public void setParent(TreeNode p){
        parent = p;
    }

    public TreeNode getParent(){
        return parent;
    }

    public int getAncestorChainLength(){
        return _getParentChainLength(parent);
    }

    public TreeNode(){
        children = new ArrayList<TreeNode>();
    }

    public TreeNode copy(){
        TreeNode ret = new TreeNode(this.value);
        return new TreeNode(this.value);
    }

    public TreeNode(String s){
        value = new String(s);
        children = new ArrayList<TreeNode>();
    }

    public String getValue(){
        return value;
    }

    public void setValue(String x){
        value = new String(x);
    }

    public void addChild(TreeNode m){
        children.add(m);
    }

    public ArrayList<TreeNode> getChildren(){
        return children;
    }

    @Override
    public boolean isEqual(Nodeable c) {
        if(c instanceof TreeNode){
            return value.equals(((TreeNode) c).getValue());
        }
        return false;
    }

    @Override
    public String getValueAsString() {
        return value;
    }

    private int _getParentChainLength(TreeNode p){
        if(p == null){
            return 0;
        }
        return 1 + _getParentChainLength(p.getParent());
    }
}
