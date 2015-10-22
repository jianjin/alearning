public class MaxDrop{


	public static int maxDrop(int [] inputs){
		if(inputs.length < 2) return -1;
		int nodrop = -1;
		// int currentvalue = inputs[0];
		int drop = nodrop;
		for(int i = 1 ;i < inputs.length ; i++){
			int diff = inputs[i - 1] - inputs[i];
			if( diff > 0 && diff > drop) drop = diff;
		}
		return drop;


	}

	public static void main(String [] args){
		System.out.println(maxDrop( new int[]{1,2,3}));
		System.out.println(maxDrop( new int[]{100,2,300, 1, -1000}));
	}



}