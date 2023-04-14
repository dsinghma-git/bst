
import java.util.Scanner;
public class BSTNode {
	public int info;
	public BSTNode left;
	public BSTNode right;

	public BSTNode()
	{
		info = 0;
		left = null;
		right = null;
	}
	
	public static BSTNode root = null;
	
	public BSTNode insert(BSTNode node, int data)
	{
		if(node == null)
		{
			node = new BSTNode();
			node.info = data;
			node.left = null;
			node.right = null;
		}
		else
		{
			if(node.info == data)
				System.out.println("\n Node cannot be inserted. Duplicate Element.");
			else if(data < node.info)
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}
	
	public boolean search(BSTNode node, int key)
	{
		boolean b= false;
		if(node==null) {
			System.out.println("The key does not exists.");
			return false;
				}
		else if(node.info==key)
			return true;
		else if(key < node.info )
			b = search(node.left, key);
		else if(key > node.info)
		    b = search(node.right, key);
		return b;
	}	
	
	BSTNode delnode(BSTNode root, int item)
	  {
	      BSTNode temp;
	      if(root==null)
	      {
	    	  System.out.println(" item is not present");
	    	  
	     }
	    else if(item<root.info)
	    	root.left = delnode(root.left, item);
	      
	    else if(item>root.info)
	    	root.right=delnode(root.right, item);
	      
	    else if(root.left!=null  && root.right!=null)      //node has two children
	    {   
	    		temp=findmin(root.right);
	    		root.info=temp.info;       
	    		root.right=delnode(root.right, root.info);
	    }
	    else
	    {
	    	temp=root;
	    	if(root.left==null)
	    		root=root.right;
	    	else if(root.right==null)
	    		root=root.left;
	    }
	    	return(root);
  	}

	BSTNode findmin( BSTNode root)
	{
		if(root==null)
		      return null;
		else if(root.left==null)
		      return root;
		else
		      return(findmin(root.left));
	}
	
	
	public void preorder(BSTNode r)
	{
		if(r!=null)
		{
			System.out.print(r.info + " ");
			preorder(r.left);
			preorder(r.right);
		}
	}
	
	public void inorder(BSTNode r)
	{
		if(r!=null)
		{
			inorder(r.left);
			System.out.print(r.info + " ");
			inorder(r.right);		
		}
	}
	
	public void postorder(BSTNode r)
	{
		if(r!=null)
		{
			postorder(r.left);
			postorder(r.right);		
			System.out.print(r.info + " ");
		}
	}
	
	public static void main (String [] args) {
		int choice;
		int item;
		Scanner sc = new Scanner(System.in);
		BSTNode bt = new BSTNode();
		
		do {
			
			System.out.println("\n\n  Binary Search Tree Operations: ");
			System.out.println("=================");
		
			System.out.println("1.Insert ");
			System.out.println("2.Search ");
			System.out.println("3.Delete ");
			System.out.println("4.PreOrder Traversal: ");
			System.out.println("5.Inorder Traversal: ");
			System.out.println("6.Postorder Traversal : ");
					
		
				System.out.println("\n\n Enter your choice: ");
				choice = sc.nextInt();
				
				switch(choice)
				{
				case 1: 
					System.out.println(" Enter a number to insert: ");
					item = sc.nextInt();
					root = bt.insert(root,item);
					System.out.println("\n element "+ item + " is inserted.");
					break;
				case 2:
					System.out.println(" Enter a number to search: ");
				    item = sc.nextInt();
					if(bt.search(root,item))
						System.out.println("Search Successful !");
					else
						System.out.println("Search Unsuccessful !");
					break;
				case 3:
					System.out.println(" Enter a number to delete: ");
				    item = sc.nextInt();
					root = bt.delnode(root,item);
					if(root !=null)
					System.out.println(" Node" + item + " is deleted.");
					break;
				case 4:
					   System.out.println("Preorder Traversal : !");
					   bt.preorder(root);
					   break;
				case 5: 
					 System.out.println("Inorder Traversal : !");
					   bt.inorder(root);
					   break;
				case 6:
					 System.out.println("Post order Traversal : !");
					   bt.postorder(root);
					   break;
				  
				default:
					System.out.println("Invalid Choice !!!");
		    	}
		
	     } while(choice < 8);
   }
	
}
