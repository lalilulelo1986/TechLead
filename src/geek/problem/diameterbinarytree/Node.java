package geek.problem.diameterbinarytree;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution
{
    //Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        // Your code here
        // return maxLength(root.left, 0, 0) + maxLength(root.right, 0, 0) + 1;
        return traversal(root);
    }

    int traversal(Node node) {
        int curr = 0;
        int left = 0;
        int right = 0;
        if (node != null) {
            curr = maxLength(node.left, 0, 0) + maxLength(node.right, 0, 0) + 1;
            left = traversal(node.left);
            right = traversal(node.right);
        }

        if (curr > left && curr > right)
            return curr;
        else if (left > right)
            return left;
        else
            return right;
    }

    int maxLength(Node node, int current, int max) {
        if (node == null) {
            return max;
        }
        current+=1;
        if (current > max)
            max = current;

        int leftLength = maxLength(node.left, current, max);
        if (leftLength > max)
            max = leftLength;

        int rightLenght = maxLength(node.right, current, max);
        if (rightLenght > max)
            max = rightLenght;

        return max;
    }


}