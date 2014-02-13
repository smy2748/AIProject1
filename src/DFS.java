import java.util.ArrayList;

/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class DFS {
    protected Stack<TreeNode> open; //Open List
    protected Dequeue<TreeNode> closed; //Closed List

    /**
     * Create a new DFS object and initialize the open and closed lists
     * Assumes that it will always be searching on TreeNodes
     */
    public DFS(){
        open = new Stack<TreeNode>();
        closed = new Dequeue<TreeNode>();
    }


    /**
     * Recursively search through the DFS object from the root node set with the setRoot function
     * @param s The String value to search for
     * @return The found TreeNode
     */
    public TreeNode search(String s){

        //Only continue the search if there are nodes in the open list
        if(open.getLength() >0){

            System.out.println("\nNext Step:");
            System.out.println("Open List: "+open.getStringRepresentation());
            System.out.println("Closed List: " + closed.getStringRepresentation());

            TreeNode t = open.pop();    //Get the first thing in open list

            System.out.println("Node Being Considered: " + t.getValueAsString());

            //If t is the value being searched for, return it.
            if(t.getValue().equals(s)){
                System.out.println("Node Found");
                return t;
            }

            //Get the children from t
            ArrayList<TreeNode> tArray = t.getChildren();
            TreeNode p;


            for(TreeNode n : tArray){

                //Set parents for all the nodes so long as they have not already been set
                if(!open.isInStack(n) && !closed.inQueue(n)){
                    n.setParent(t);
                }

                //If any of the children are what is being searched for, return it
                if(n.getValue().equals(s)){
                    System.out.println("Node Found");
                    return n;
                }
            }

            //Push children on the stack in inverse order to match the order defined in the lecture slides
            for(int i= tArray.size(); i>0; i--){
                p=tArray.get(i-1);
                if(!open.isInStack(p) && !closed.inQueue(p)){
                    open.push(p);
                }
            }

            //Close the current node
            closed.queue(t);

            //Continue the search
            return search(s);
        }

        //Their are no more nodes in the open list, so the searched for value is unfindable
        return null;
    }

    /**
     * Sets the start point of the graph being searched
     * @param tn The start point of the searched graph
     */
    public void setRoot(TreeNode tn){
        open.push(tn);
    }

    /**
     * Run the default DFS
     * @param args Not used
     */
    public static void main(String args[]){
        TreeNode root = Tree.createTree();  //Create the graph
        DFS dfs = new DFS();    //Create the search object
        dfs.setRoot(root);      //Set the root
        TreeNode result = dfs.search("M");  //Run the DFS
        if(result == null){
            System.out.println("No path found");
        }
        else{
            System.out.println("\nPath To Searched Node: "+ result.getPathAsString());
        }
        dfs.print();
    }


    /**
     * Prints the contents of the Open and Closed list
     */
    public void print(){
        System.out.println("\nFinal Config: ");
        System.out.println("Open Queue: " + open.getStringRepresentation());
        System.out.print("Closed Queue: " + closed.getStringRepresentation());
    }

}
