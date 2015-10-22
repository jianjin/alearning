// 最长公共子序列
import java.util.ArrayList;
import java.util.Collections;
class LCS{

	static String input = "ADE";
	static String input2 = "ABCDE";

	 static int lcs_length_recursive(int i, int i2){
	 	
	 	if(i == input.length() || i2 == input2.length()) return 0;
	 	System.out.println(i + " " + i2);
	 	if ( input.charAt(i) == input2.charAt(i2)){
	 		//System.out.println(input.charAt(i));
	 		return 1 + lcs_length_recursive(i+1, i2+1);
	 	}else{
	 		int r1 = lcs_length_recursive(i+1, i2);
	 		int r2 = lcs_length_recursive(i, i2+1);
	 		if(r2 > r1) return r2; else return r1;
	 	}
	 }

	 static void lcs_length_dynamic(){
	 	int[][] f = new int[input.length()+1][input2.length()+1];

	 	for(int i = 1 ; i <= input.length(); i++){
	 		for(int j = 1 ; j <= input2.length(); j++){
	 			int l = 0;
	 			if(input.charAt(i-1) == input2.charAt(j-1)) l = 1;
	 			f[i][j] = maximum(f[i-1][j-1]+l, f[i-1][j], f[i][j-1]);
	 		}
	 	}

	 	for( int i = 0 ; i <= input.length() ; i++){
	 		for(int j= 0; j <= input2.length() ; j++){
	 			System.out.print(f[i][j]+" ");
	 		}
	 		System.out.println();
	 	}

	 }

	 static int maximum (int a, int b, int c){
	 	int max = a;
	 	if (max < b) max = b;
	 	if (max < c) max = c;
	 	return max;
	 }

	public static void main(String [] args){
		System.out.println(lcs_length_recursive(0, 0));
		lcs_length_dynamic();

	}

	

	
}