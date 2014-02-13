/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class BFS {
    protected Dequeue<TreeNode> open;
    protected Dequeue<TreeNode> closed;

    public BFS(){
        open = new Dequeue<TreeNode>();
        closed = new Dequeue<TreeNode>();
    }

    public TreeNode search(String s){
        if(open.getLength() > 0){
            System.out.println("\nNext Step:");
            System.out.println("Open List: "+open.getStringRepresentation());
            System.out.println("Closed List: " + closed.getStringRepresentation());
            Node<TreeNode> t = open.getHead();
            TreeNode tn = t.getValue();
            System.out.println("Node Being Considered: " + tn.getValueAsString());
            open.removeHead();
            closed.queue(tn);
            if(tn.getValue().equals(s)){
                System.out.println("Node Found");
                return tn;
            }
            for(TreeNode n: tn.getChildren()){
                if(!closed.inQueue(n) && !open.inQueue(n)){
                    n.setParent(tn);
                    open.queue(n);
                }

            }
            return search(s);
        }
        return null;
    }

    public void setRoot(TreeNode n){
        open.queue(n);
    }


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
