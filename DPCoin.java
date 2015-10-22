public class DPCoin{

	public static void main(String [] args){
		int [] input = {1 ,3 , 5};
		int s = 13;
		System.out.println(minumCoin(input, s));
	
	}

	public static int minumCoin(int [] input, int s){
		int[] min = new int[s+1];
		for(int i = 1; i < s+1; i++){
			min[i] = 1000;
		}

		for(int i = 1 ; i < s+1 ; i++)
			for(int j = 0 ; j < input.length ; j++)
			{
				if ( input[j] <= i && (min[i - input[j]] + 1) < min[i])
					min[i] = min[i - input[j]] + 1;
			}

		return min[s];
	}

}
