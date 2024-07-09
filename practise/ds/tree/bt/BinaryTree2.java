package com.seena.practise.ds.tree.bt;

public class BinaryTree2 {
    int diameter = 0;
    int maxSum = 0;
    int leftLevel = 0;
    int oddLevel = 0;

    TreeNode deepestLeftNode = null;
    class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val){
            this.data = val;
            left = null;
            right =null;
        }
    }
    private TreeNode creatNode(int data){
        TreeNode node = new TreeNode(data);
        return node;
    }
    public int getDiameter() {
        return diameter;
    }
    public static void main(String[] args){

        BinaryTree2 bt = new BinaryTree2();
        TreeNode root = bt.creatNode(2);
        root.left = bt.creatNode(7);
        root.left.left = bt.creatNode(2);
        root.left.right = bt.creatNode(6);
        root.left.right.left = bt.creatNode(5);
        root.left.right.right = bt.creatNode(11);
        root.right = bt.creatNode(5);
        root.right.right = bt.creatNode(9);
        root.right.right.left = bt.creatNode(4);
        bt.getMaxDiameter(root);
        System.out.println( " Max Diameter " +bt.getDiameter() );
        System.out.println(" Root to all paths");
        bt.rootToLeafPaths(root);
        System.out.println(" Is Height balaned treee "+ bt.isHeightBalancedTree(root));
        bt.maxSumFromRootToLeaf(root,0);
        System.out.println(" Max Sum from Root to Leaf " +bt.getMaxSum());
        System.out.println(" Decimal Numbers formed from Node to each Leaf " );
        bt.formDecimalNumbers(root,0);
        System.out.println(" Deepest left deep node " + bt.leftLevel + bt.deepestLeftNode);
        bt.deepestLeftLeefNode(root, 0, true);
        System.out.println(" Deepest left deep node " + bt.leftLevel + bt.deepestLeftNode.data);

    }

    private void deepestLeftLeefNode(TreeNode node, int level, boolean left){
        if(node == null ){
            return;
        }
        if( node.left== null && node.right==null && left && level > leftLevel){
            leftLevel = level;
            deepestLeftNode = node;
        }
        deepestLeftLeefNode(node.left, level+1, true);
        deepestLeftLeefNode(node.right, level+1, false);
    }

    private void deepestOddLevelLeefNode(TreeNode node , int level){
        if(node == null ){
            return;
        }
        if(node.left == null && node.right == null && (level%2 != 0) && level > oddLevel ){
            oddLevel = level;

        }
        deepestOddLevelLeefNode( node.left , level+1);
        deepestOddLevelLeefNode(node.right, level+1);
    }

    private void formDecimalNumbers(TreeNode node, int number) {
        if(node == null ){
            return;
        }
        // If Leaft node, then end of one number, print that number
        if(node.left == null && node.right == null){
            System.out.print(" " + number*10+node.data);
        }
        formDecimalNumbers(node.left, number*10+node.data);
        formDecimalNumbers(node.right, number*10+node.data);
    }

    private void maxSumFromRootToLeaf(TreeNode node, int sum) {
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null && sum+node.data > maxSum){
            maxSum = sum+node.data;
        }
        maxSumFromRootToLeaf(node.left, sum+node.data);
        maxSumFromRootToLeaf(node.right, sum+node.data);
    }

    private int getMaxDiameter(TreeNode node) {
        if(node == null ){
            return 0;
        }
        if(node.left == null && node.right ==null){
            return 1;
        }
        int lh = getMaxDiameter(node.left);
        int rh = getMaxDiameter(node.right);
        diameter = Math.max(diameter, lh+rh+1);
        return Math.max(lh, rh)+1;
    }

    private int isHeightBalancedTree(TreeNode node){
        if(node == null ){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        int lh = isHeightBalancedTree(node.left);
        int rh = isHeightBalancedTree(node.right);
        if(lh == -1 || rh == -1 || Math.abs(lh-rh)>1){
            return -1;
        }
        return Math.max(lh, rh)+1;
    }

    /*
    Sum = 10, Every visit sum is decreased by node value.
    at the leafe node, if sum matches and leave node value, then root to leaf sum is present.
     */

    private boolean isRootToLeafMatchesSum(TreeNode node ,int sum){
        if(node == null ){
            return false;
        }
        if(node.left == null && node.right == null && sum == node.data){
            return true;
        }
        return isRootToLeafMatchesSum(node.left , sum-node.data) || isRootToLeafMatchesSum(node.right, sum-node.data);
    }

    /*
    to print all the paths from root --> leaf. We need to take array which points the index to each leavel
    if we find leaf, print array from beginning to that index and
     */

    private void rootToLeafPaths(TreeNode root){
        if(root == null){
            return;
        }
        int[] arr = new int[10];
        allPathsFromRootToLeaf(root, arr, 0);
    }

    private void allPathsFromRootToLeaf(TreeNode node, int[] arr, int index) {
        if(node == null ){
            return;
        }
        arr[index] = node.data;
        if(node.left == null && node.right == null){
            printArray(arr, index);
        }
        allPathsFromRootToLeaf(node.left,arr,index+1);
        allPathsFromRootToLeaf(node.right, arr, index+1);
    }

    private void printArray(int[] arr, int index) {
        for(int i = 0; i<=index;i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public int getMaxSum() {
        return maxSum;
    }
}
