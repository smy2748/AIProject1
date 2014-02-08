import java.util.HashMap;

/**
 * Created by Stephen Yingling on 2/7/14.
 */
public class Tree {
    protected TreeNode root;

    public Tree(TreeNode root){
        this.root = root;
    }

    public Tree(){
    }

    public void setRoot(TreeNode n){
        root = n;
    }

    public TreeNode getRoot(){
        return root;
    }

    public static TreeNode createTree(){
        HashMap<String, TreeNode> nodeMap = new HashMap<String, TreeNode>();
        int base = 'A';
        TreeNode t;
        String s;
        for(; base <= 'R'; base++){
            s = String.valueOf((char) base);
            t = new TreeNode(s);
            nodeMap.put(s,t);

        }

        //Init a
        nodeMap.get("A").addChild(nodeMap.get("B"));
        nodeMap.get("A").addChild(nodeMap.get("C"));
        nodeMap.get("A").addChild(nodeMap.get("D"));

        //Init b
        nodeMap.get("B").addChild(nodeMap.get("E"));
        nodeMap.get("B").addChild(nodeMap.get("F"));
        nodeMap.get("B").addChild(nodeMap.get("G"));

        //Init c
        nodeMap.get("C").addChild(nodeMap.get("G"));

        //Init d
        nodeMap.get("D").addChild(nodeMap.get("H"));
        nodeMap.get("D").addChild(nodeMap.get("I"));

        //Init E
        nodeMap.get("E").addChild(nodeMap.get("J"));
        nodeMap.get("E").addChild(nodeMap.get("K"));
        nodeMap.get("E").addChild(nodeMap.get("L"));

        //Init F
        nodeMap.get("F").addChild(nodeMap.get("A"));
        nodeMap.get("F").addChild(nodeMap.get("L"));

        //Init G
        nodeMap.get("G").addChild(nodeMap.get("M"));
        nodeMap.get("G").addChild(nodeMap.get("N"));
        nodeMap.get("G").addChild(nodeMap.get("H"));

        //Init H
        nodeMap.get("H").addChild(nodeMap.get("A"));
        nodeMap.get("H").addChild(nodeMap.get("O"));
        nodeMap.get("H").addChild(nodeMap.get("P"));

        //Init I
        nodeMap.get("I").addChild(nodeMap.get("P"));
        nodeMap.get("I").addChild(nodeMap.get("R"));

        return nodeMap.get("A");
    }
}
