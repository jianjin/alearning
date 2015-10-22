//最长递增子序列
class LIS{

public static int [] input = {1,5,8,2,3,4};

public static void LIS1(){

	int [][] max = new int[2][input.length];
	for(int i = 0 ; i < max.length; i++){
		max[0][i] = 1;
		max[1][i] = i;
	}

	for(int i = 0 ; i < input.length; i++){
		for(int j = 0 ; j < i; j++){
			if(input [i] > input [j]){
				if(max[0][i] < (max[0][j] + 1)){
					max[0][i] = max[0][j]+1;
					max[1][i] = j;
				}
			}
		}
	}

	for(int i = 0 ; i < max[0].length; i++){
		System.out.print(max[0][i]+" ");
	}

	System.out.println("link:");
	for(int i = 0 ; i < max[0].length; i++){
		System.out.print(max[1][i]+" ");
	}

}

public static void LIS2(){

	int [][] max = new int[2][input.length];
	for(int i = 0 ; i < max.length; i++){
		max[0][i] = 1;
		max[1][i] = i;
	}

	


}

public static void main(String [] args){

	LIS1();

}



}