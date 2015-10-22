/*
*  http://www.careercup.com/question?id=5727804001878016
*  Given an array of positive, unique, increasingly sorted numbers A, e.g. A = [1, 2, 3, 5, 6, 8, 9, 11, 12, 13]. Given a positive value K, e.g. K = 3. Output all pairs in A that differ exactly by K. 
*    e.g. 2, 5 
*    3, 6 
*    5, 8 
*    6, 9 
*    8, 11 
*    9, 12 
*/
public class NumberGap{


	public static int[] findgap(int[] input, int gap){
		int[] result = new int[2 * input.length];
		int ri=0;
		for(int i = 0 ; i < input.length ; i++){
			int a = input[i];
			if(a == -1 ) continue;
			int b = findPair(input, i, gap);
			if(b == -1) continue;
			result[ri++]=a;result[ri++]=b;
		}
		return result;
	}
	private static int findPair(int[] input, int from, int gap){
		for(int i = from + 1 ; i < input.length; i++){
			int c = input[i] - input[from];
			if(c == gap){
				int result = input[i];
				return result;
			}else if(c > gap){
				return -1;
			}
		}
		return -1;
	}

	public static void main(String [] args){
		int[] input1 = {1, 2, 3, 5, 6, 8, 9, 11, 12, 13};
		int[] result = findgap(input1, 3);
		printArray(result);
	}

	private static void printArray(int [] array){
		for(int i : array){
			System.out.print(i + " ");
		}
	}



}