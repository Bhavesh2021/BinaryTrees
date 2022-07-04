import java.util.*;
public class BinaryTrees
{
	static class Node  // Node class
	{
		int data;
		Node left;
		Node right;
		
		Node(int data) //constructor
		{
			this.data = data;
			this.left = null;    //initially left and right child will be null
			this.right = null;
		}
	}
	
	static class BinaryTree
	{
		static int index = -1;  //for traversing
		public static Node buildTree(int nodes[])  // this function will take all nodes and will return root node
		{
			index++;
			if(nodes[index] == -1)
			{
				return null;
				
			}
			// Recursively after every node there will be left subtree then right subtree
			Node newNode = new Node(nodes[index]);  //creating new node
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			
			return newNode;
		}
	}
	
	public static void preOrder(Node root)  //output - 1 2 4 5 3 6
	{
		/*Preorder Traversal of binary tree - Time Complexity[O(N)]
		Sequence - '[Root comes first that is why sequence name is preorder]'
		Root
		Left Subtree
		Right SubTree
		*/
		if(root == null)  //base case if root==null 
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(Node root)  // output 4 2 5 1 3 6
	{
		/*Inorder Traversal of binary tree - Time Complexity[O(N)]
		Sequence - 
		Left Subtree
		Root
		Right SubTree
		*/
		if(root == null)  //base case if root==null 
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void postOrder(Node root)  // output 4 5 2 6 3 1
	{
		/*postOrder Traversal of binary tree - Time Complexity[O(N)]
		Sequence - 
		Left Subtree
		Right SubTree
		Root
		*/
		if(root == null)  //base case if root==null 
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");

	}
	
	public static void levelOrder(Node root)  //Time Complexity[O(N)] also called as BFS property of BinaryTree
{
	/* output
	1
    2 3 
    4 5 6	
    We will use Queue data structure[FIFO] property first we will add root and null[indicates new line means further no child of that node] 
	then we will print root node, while removing particular node we will add child nodes in queue because we want level wise print.
   */
    if(root == null)  //base case
		return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
        
    while(!q.isEmpty())
    {
	   Node currNode = q.remove();
       if(currNode == null)
        {
			System.out.println();
            if(q.isEmpty())
                break;
            else
                q.add(null);
        }
        else
        {
			System.out.print(currNode.data + " ");
            if(currNode.left!=null)
            {
              q.add(currNode.left);
            }
            if(currNode.right!=null)
            {
              q.add(currNode.right);
            }
        }
    }
}
	
	public static void main(String args[])
	{
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};  // sequence is Preorder
		// -1 represents null node, next child will be null
		// 1 will be root of tree, next(2) will be left child, next(4) wil be right child and so on
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		System.out.println("The root node is" + " " +root.data);
		System.out.println("The PreOrder is - ");
		preOrder(root);
		System.out.println(" ");
		System.out.println("The InOrder is - ");
		inOrder(root);
		System.out.println(" ");
		System.out.println("The PostOrder is - ");
		postOrder(root);
		System.out.println(" ");
		System.out.println("The LevelOrder is - ");
		levelOrder(root);
		
	}
}

