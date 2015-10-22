public class Combination{



	public static void combine(int[] number, int r){
		int start = 0, layer = r;
		
		doCombine(number, 0, r, "");
		
	}

	public static void doCombine(int[] number, int start, int r, String temp){


		for(;start < number.length - r  ; start++){
			if(r == 0){
				System.out.println(temp+number[start]);
			}else {
				doCombine(number, start+1, r-1, temp+number[start]);
			}
		}

	}

	public static void main(String [] args){
		combine(new int[]{1,2,3,4,5}, 2);
	}


}