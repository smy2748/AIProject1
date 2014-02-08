import java.util.ArrayList;

/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class TreeNode implements Nodeable {
    protected String value;
    protected ArrayList<TreeNode> children;

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
}
