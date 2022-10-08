class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> trav = new ArrayList<Integer>();
        Stack<TreeNode> pickup = new Stack<TreeNode>();
        
        TreeNode node = root;
        
        while(true){
            if(node != null){
                pickup.push(node);
                node = node.left;    
            }else{
                if(pickup.isEmpty()) break;

                node = pickup.pop();
                trav.add(node.val);
                node = node.right;
            }
        }
        return trav;
    }
}
