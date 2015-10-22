class LongestSequence{


	public static void main(String [] args){
		int[] inputs = {5, 3, 4, 8, 6, 7};
		print(longest(inputs));
	}

	private static int [] longest(int [] data){
		int[]  s = new int[data.length];
		for(int i = 0 ; i < s.length ; i++){
			s[i] = 1;
		}
		for(int si=1 ; si < s.length; si++){
			for(int di = 0 ; di < si ; di++){
				if(data[si] > data[di] && (s[si] < s[di] + 1)){
					s[si] = s[si] + 1;
				}
			}
		}
		return s;
	}

	private static void print(int [] inputs){
		for(int i: inputs){
			System.out.print(i + ", ");
		}
		System.out.println();
	}

}