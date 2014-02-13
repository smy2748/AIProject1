import java.util.ArrayList;

/**
 * Created by Stephen Yingling on 2/8/14.
 *
 * Class that does an iterative deepening search
 */
public class IDS {

    protected Stack<TreeNode> open;
    protected Dequeue<TreeNode> closed;

    /**
     * Create a new IDS object
     */
    public IDS(){
        open = new Stack<TreeNode>();
        closed = new Dequeue<TreeNode>();
    }

    /**
     * Search for value s
     * @param s The value to search for
     * @param root The start point of the graph being searched
     * @param maxDepth The maximum depth to search
     * @return The TreeNode containing s if it exists, null if it doesn't
     */
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

    /**
     * Searches with a depth constraint
     * @param s The string to search for
     * @param depth The current max depth to search at
     * @return The TreeNode containing s if it exists, null if it can't be found given the current depth limit
     */
    protected TreeNode searchAtDepth(String s, int depth){

        //Only continue if there are nodes in the open list
        if(open.getLength() > 0){

            System.out.println("\nNext Step:");
            System.out.println("Open List: "+open.getStringRepresentation());
            System.out.println("Closed List: " + closed.getStringRepresentation());


            TreeNode tn = open.pop();   //Get the first Node off the open list

            System.out.println("Node Being Considered: " + tn.getValueAsString());


            //Return if the value being searched for is found
            if(tn.getValue().equals(s)){
                return tn;
            }


            //Only add children if the number of parents of the
            // current node is < depth
            if(tn.getAncestorChainLength() < depth){
                ArrayList<TreeNode> tArray = tn.getChildren();
                TreeNode p;

                //Add in reverse to maintain order as shown in lecture
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

            closed.queue(tn);   //Close the current node
            return searchAtDepth(s,depth);  //Continue searching
        }

        System.out.println("No result found at depth = " + depth);
        return null;
    }


    /**
     * Run the default IDS search
     * @param args Not used
     */
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
