class DPCoinTry{

	public static void main(String [] args){
		int[] data = {1, 3, 5};
		print(mimum(data, 13));
	}	
	
	private static int[] mimum(int [] inputs, int sum){
		int[] state = new int[sum+1];
		for(int i = 0 ; i < state.length; i++){
			state[i] = -1;
		}
		state[0] = 0;

		for(int cs = 1 ; cs <= sum ; cs++){
			for(int j = 0 ; j < inputs.length ; j++){
				if(inputs[j] <= cs && (state[cs] == -1 || 
					( state[cs - inputs[j]] + 1) < state[cs])){
					state[cs] = state[cs - inputs[j]] + 1;
				}
			}
		}
		return state;
	}

	private static void print(int [] state){
		for(int s : state){
			System.out.print(s + " ");
		}
		System.out.println();
	}

}