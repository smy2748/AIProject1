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
            Node<TreeNode> t = open.getHead();
            TreeNode tn = t.getValue();
            open.removeHead();
            closed.queue(tn);
            if(tn.getValue().equals(s)){
                return tn;
            }
            for(TreeNode n: tn.getChildren()){
                if(!closed.inQueue(n) && !open.inQueue(n)){
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
        bfs.search("M");
        bfs.printQueues();
    }

    public void printQueues(){
        System.out.print("Open Queue: ");
        open.printQueue();
        System.out.print("\n Closed Queue");
        closed.printQueue();

    }
}
