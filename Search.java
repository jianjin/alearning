class Search{

	public static void main(String [] args){
			
			System.out.println(fib(2000));

	}

	private static int fib(int n){
		int f0 = 0, f1 = 1;
		if( n == 0) return f0;
		if( n == 1) return f1;
		for(int i = 2 ; i < n ; i ++){
			if ( i % 2 == 0) f0 = f0 + f1;
			else f1 = f0 + f1;
		}
		if (n / 2 == 0) return f0;
			else return f1;
	}

}