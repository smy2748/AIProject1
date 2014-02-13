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
            System.out.println("\nNext Step:");
            System.out.println("Open List: "+open.getStringRepresentation());
            System.out.println("Closed List: " + closed.getStringRepresentation());
            TreeNode t = open.pop();
            System.out.println("Node Being Considered: " + t.getValueAsString());
            closed.queue(t);
            if(t.getValue().equals(s)){
                System.out.println("Node Found");
                return t;
            }
            ArrayList<TreeNode> tArray = t.getChildren();
            TreeNode p;
            for(int i= tArray.size(); i>0; i--){
                p=tArray.get(i-1);
                if(!open.isInStack(p) && !closed.inQueue(p)){
                    p.setParent(t);
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
        TreeNode result = dfs.search("M");
        if(result == null){
            System.out.println("No path found");
        }
        else{
            System.out.println("\nPath To Searched Node: "+ result.getPathAsString());
        }
        dfs.print();
    }

    public void print(){
        System.out.println("\nFinal Config: ");
        System.out.println("Open Queue: " + open.getStringRepresentation());
        System.out.print("Closed Queue: " + closed.getStringRepresentation());
    }

}
