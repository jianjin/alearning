class Tree{


	static Node constructTree(){
		Node root = Node.c();
		root.left = Node.c();
		root.right = Node.c();
		root.left.left = Node.c();
		root.right.right = Node.c();

		return root;
	}

	static Node constructTree2(){
		Node root = Node.c();
		root.left = Node.c();
		root.right = Node.c();
		root.left.left = Node.c();
		root.right.left = Node.c();

		return root;
	}
	static Node constructTree3(){
		Node root = Node.c();
		root.left = Node.c();
		root.left.left = Node.c();
		root.left.left.left = Node.c();
		root.left.left.left.left = Node.c();
		root.left.left.left.right = Node.c();
		root.right = Node.c();
		root.right.right = Node.c();
		root.right.right.right = Node.c();
		root.right.right.right.right = Node.c();
		root.right.right.right.left = Node.c();

		return root;
	}

	public static void main(String [] args){

		System.out.println(isMirror(constructTree3()));


	}

	private static boolean isMirror2(Node root){
		return false;
	}

	private static boolean isMirror(Node root){

		//travase
		Node rootleft = root.left;
		Stack stackleft = new Stack();
		stackleft.push(rootleft);

		Stack stackright = new Stack();
		Node rootright = root.right;
		stackright.push(rootright);
		
		while(!stackleft.isEmpty() && !stackright.isEmpty()){
			
			System.out.println(rootleft + " "+ rootright);
			if(rootleft != null && rootright != null){
				rootleft = rootleft.left;
				rootright = rootright.right;
			}



			if(rootleft == null || rootright == null){
				if(rootleft !=null || rootright !=null){
					return false;
				}
			}

			if(rootleft !=null && rootright != null){
				stackleft.push(rootleft);
				stackright.push(rootright);
			}

			if(rootleft == null && rootright == null){
				rootleft = stackleft.pop().right;
				rootright = stackright.pop().left;
			}
		}
		return true;


	}

	static class Stack{
		Node [] values = new Node[100];
		int  top = 0;
		void push(Node n){
			values[top++] = n;
		}

		Node pop(){
			return values[--top]; 
		}

		boolean isEmpty(){
			return top == 0;
		}

	}
	static class Node{
		static int i = 0;
		private int id;
		Node left;
		Node right;
		private Node(int i){ id = i;}
		static Node c(){
			return new Node(i++);
		}
		public String toString(){
			return id+"";
		}

	}

}




