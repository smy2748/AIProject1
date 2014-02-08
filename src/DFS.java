import java.util.ArrayList;

/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class DFS {
    protected Stack<TreeNode> open;
    protected Dequeue<TreeNode> closed;

    public DFS(){
        open = new Stack<TreeNode>();
        closed = new Dequeue<TreeNode>();
    }

    public TreeNode search(String s){
        if(open.getLength() >0){
            TreeNode t = open.pop();
            closed.queue(t);
            if(t.getValue().equals(s)){
                return t;
            }
            ArrayList<TreeNode> tArray = t.getChildren();
            TreeNode p;
            for(int i= tArray.size(); i>0; i--){
                p=tArray.get(i-1);
                if(!open.isInStack(p) && !closed.inQueue(p)){
                    open.push(p);
                }
            }
            return search(s);
        }

        return null;
    }

    public void setRoot(TreeNode tn){
        open.push(tn);
    }

    public static void main(String args[]){
        TreeNode root = Tree.createTree();
        DFS dfs = new DFS();
        dfs.setRoot(root);
        dfs.search("M");
        dfs.print();
    }

    public void print(){
        System.out.print("Open Queue:");
        System.out.print(open.getStringRepresentation());
        System.out.print("\nClosed Queue: ");
        closed.printQueue();
    }

}
