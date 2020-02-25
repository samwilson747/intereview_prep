import java.util.*;

class BTZigZagTraversal {
   /*
   ex: tree: [3,9,20,null,null,15,7]
          3
         / \
        9  20
          /  \
         15   7
   return: zig zag order traversal
   [
      [3],
      [20,9],
      [15,7]
   ]
   */

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      //BFS traversal through tree
        List<List<Integer>> levels = new ArrayList();
        if(root == null) return levels; //tree is empty, return []
        LinkedList<TreeNode> q = new LinkedList();
        int level = 1;
        q.add(root); //begin BFS with root node given
        while(!q.isEmpty()) { //run while there are still nodes to be processed
            levels.add(new LinkedList());
            int level_size = q.size();
            for(int i = 0; i < level_size; i++) {
                TreeNode node = q.remove();
                if(level%2 == 1)  //odd level
                    levels.get(level-1).add(node.val); //add to the back
                else { //even level
                    levels.get(level-1).add(0,node.val); //add to the front of the list
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            level++;
        }
        return levels;
    }
}

}
