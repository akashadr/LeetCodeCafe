class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> trav = new ArrayList<Integer>();
        Stack<TreeNode> pickup = new Stack<TreeNode>();
        
        if(root == null) return trav;
        TreeNode node = root;
        
        while(node != null || !pickup.isEmpty() ){
          if(node != null ){
              pickup.push(node);
              node = node.left;    
          }else{
              TreeNode temp = pickup.peek().right;
              if(temp == null ){
                  temp = pickup.pop();
                  trav.add(temp.val);
                  
                  while(!pickup.isEmpty() && temp == pickup.peek().right){
                      temp = pickup.pop();
                      trav.add(temp.val);
                  }
              }else
                  node = temp;   
          }      
        }
        return trav;
    }
}
