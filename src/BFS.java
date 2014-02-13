/**
 * Created by Stephen Yingling on 2/7/14.
 *
 * An object representing a bredth first search
 */
public class BFS {
    protected Dequeue<TreeNode> open;
    protected Dequeue<TreeNode> closed;

    /**
     * Create  a new BFS object
     */
    public BFS(){
        open = new Dequeue<TreeNode>();
        closed = new Dequeue<TreeNode>();
    }


    /**
     * Search for string s in the tree
     * @param s The string to search for
     * @return The TreeNode containing s if it exists, null if not
     */
    public TreeNode search(String s){

        //Only search if their are node in the open list
        if(open.getLength() > 0){

            System.out.println("\nNext Step:");
            System.out.println("Open List: "+open.getStringRepresentation());
            System.out.println("Closed List: " + closed.getStringRepresentation());

            Node<TreeNode> t = open.getHead();  //Get the first Node
            TreeNode tn = t.getValue();

            System.out.println("Node Being Considered: " + tn.getValueAsString());
            open.removeHead();

            //Return if the current node is the one being searched for
            if(tn.getValue().equals(s)){
                System.out.println("Node Found");
                return tn;
            }

            //Generate children
            for(TreeNode n: tn.getChildren()){
                if(!closed.inQueue(n) && !open.inQueue(n)){
                    n.setParent(tn);
                    if(n.getValue().equals(s)){
                        System.out.println("Node Found");
                        return n;
                    }
                    open.queue(n);
                }

            }
            closed.queue(tn);   //Close the current Node
            return search(s);   //Recurse
        }

        //Node could not be found
        return null;
    }

    /**
     * Set the start point of the tree being searched
     * @param n The start node for the tree being searched
     */
    public void setRoot(TreeNode n){
        open.queue(n);
    }

    /**
     * Run the default search
     * @param args Not used
     */
    public static void main(String args[]){
        TreeNode root = Tree.createTree();
        BFS bfs = new BFS();
        bfs.setRoot(root);
        TreeNode t = bfs.search("M");

        if(t == null){
            System.out.println("Not found");
        }
        else{
            System.out.println("\nPath To Searched Node: "+ t.getPathAsString());
        }
        bfs.printQueues();
    }

    public void printQueues(){
        System.out.println("Open Queue: " + open.getStringRepresentation());
        System.out.println("Closed Queue: " + closed.getStringRepresentation());


    }
}
