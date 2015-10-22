//Edit Distance

class EditDistance{

	static String input = "polynomial";
	static String input2 = "exponential";

	static void lcs_length_dynamic(){
	 	int[][] f = new int[input.length()+1][input2.length()+1];
	 	for(int i = 0 ; i < input2.length()+1; i++){
	 		f[0][i] = i;
	 	}
	 	for(int i = 0 ; i < input.length()+1; i++){
	 		f[i][0] = i;
	 	}
	 	for(int i = 1 ; i <= input.length(); i++){
	 		for(int j = 1 ; j <= input2.length(); j++){
	 			int l = 0;
	 			if(input.charAt(i-1) != input2.charAt(j-1)) l = 1;
	 			f[i][j] = minimum(f[i-1][j-1]+l, f[i-1][j]+1, f[i][j-1]+1);
	 		}
	 	}

	 	for( int i = 0 ; i <= input.length() ; i++){
	 		for(int j= 0; j <= input2.length() ; j++){
	 			System.out.print(f[i][j]+"   ");
	 		}
	 		System.out.println();
	 	}

	 }

	 static int minimum (int a, int b, int c){
	 	int mim = a;
	 	if (mim > b) mim = b;
	 	if (mim > c) mim = c;
	 	//System.out.println(a + " " + b + " " + c + " " +mim);
	 	return mim;
	 }

	public static void main(String [] args){
		//System.out.println(lcs_length_recursive(0, 0));
		lcs_length_dynamic();

	}


}