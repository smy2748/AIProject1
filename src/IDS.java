import java.util.ArrayList;

/**
 * Created by Stephen Yingling on 2/8/14.
 */
public class IDS {

    protected Stack<TreeNode> open;
    protected Dequeue<TreeNode> closed;

    public IDS(){
        open = new Stack<TreeNode>();
        closed = new Dequeue<TreeNode>();
    }

    public TreeNode search(String s, TreeNode root, int maxDepth){
        TreeNode tn;

        for(int depth= 0; depth < maxDepth; depth++){
            open.push(root);
            System.out.println("\nSearching at depth: " + depth);
            tn = searchAtDepth(s, depth);
            if(tn != null){
                return tn;
            }
            open.clear();
            closed.clear();
        }

        return null;

    }

    protected TreeNode searchAtDepth(String s, int depth){
        if(open.getLength() > 0){
            System.out.println("\nNext Step:");
            System.out.println("Open List: "+open.getStringRepresentation());
            System.out.println("Closed List: " + closed.getStringRepresentation());
            TreeNode tn = open.pop();
            System.out.println("Node Being Considered: " + tn.getValueAsString());
            closed.queue(tn);
            if(tn.getValue().equals(s)){
                return tn;
            }
            if(tn.getAncestorChainLength() < depth){
                ArrayList<TreeNode> tArray = tn.getChildren();
                TreeNode p;
                for(int i=tArray.size(); i>0; i--){
                    p = tArray.get(i-1);
                    if(!open.isInStack(p) && !closed.inQueue(p)){
                        p.setParent(tn);
                        open.push(p);
                    }
                }
            }
            else{
                System.out.println("Can't add children due to deepness constraint.");
            }
            return searchAtDepth(s,depth);
        }
        System.out.println("No result found at depth = " + depth);
        return null;
    }

    public static void main(String args[]){
        IDS ids = new IDS();
        TreeNode root = Tree.createTree();
        TreeNode tn = ids.search("M",root,10);

        if(tn == null){
            System.out.println("Not found");
        }
        else{
            System.out.println("\nPath To Searched Node: "+ tn.getPathAsString());
        }

    }
}
