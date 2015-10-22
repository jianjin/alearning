import java.util.Arrays;

/*
*   http://www.careercup.com/question?id=5124942133723136
*   Write a function to check if a string matches a regex patter. Note that you only have to deal with patterns containing "*". Also, note that the pattern can't start with "*". 
*
*   Some examples: 
*   isMatch(“aa”,”a”) → false 
*   isMatch(“aa”,”aa”) → true 
*   isMatch(“aaa”,”aa”) → false 
*   isMatch(“aa”, “a*”) → true 
*   isMatch(“aa”, “*”) → true 
*   isMatch(“ab”, “*”) → true 
*   isMatch(“ab”, “*”) → true 
*   isMatch(“b*a”, “a”) → true 
*   isMatch(“a*a”, “a”) → true 
*   isMatch(“aab”, “c*a*b”) → true
*/

public class Pattern{

	/*
	*   Use recursive call to keep the state for choice, because only support *, so it is much easier. 
	*/
	public static boolean match2(char [] pattern, char[] input){
		if(pattern.length == 0 && input.length == 0) return true;
		if(pattern.length == 0 || input.length ==0 ) return false;
		if(pattern.length >=2 && pattern[1] == '*'){
			if(match2(Arrays.copyOfRange(pattern, 2, pattern.length), input)) return true;
			if(pattern[0] == input[0] && match2(pattern, Arrays.copyOfRange(input, 1, input.length ))) return true;
			return false;
		}else{
			if(pattern[0] == input[0]) 
				return match2(Arrays.copyOfRange(pattern, 1, pattern.length), Arrays.copyOfRange(input, 1, input.length ));
			else
				return false;
		}
	}
 
 	/*
 	*  Try to use N state to go ahead at the same time for all choice.
 	*  https://swtch.com/~rsc/regexp/regexp1.html
 	*  I believe http://introcs.cs.princeton.edu/java/72regular/Wildcard.java.html is the implementation for it
 	*/
    public static boolean match3(char[] pattern, char[] input){

    	boolean [] states = new boolean[pattern.length + 1];
    	states[0] = true; //start point

    	for(int i = 0 ; i < input.length ; i++){
    		char c = input[i];
    		boolean[] steps = new boolean[pattern.length + 1];
    		boolean progress = false;
    		for(int j = 0; j < pattern.length ; j++){
    			int indexstate = j + 1;
    			if(states[indexstate - 1] && pattern[j] ==  c) {steps[ indexstate ] = true;}
    			if(pattern[j] == '*' && states[indexstate - 1]) {steps[indexstate] = true;}
    			if(pattern[j] == '*' && states[indexstate - 2]) {states[indexstate] = true; steps[indexstate] = true;}
    			// if(pattern[j] == c && j >=3 && pattern[j - 1] == '*' && states[indexstate - 3] ) {steps[indexstate] = true;}
    		}
    		states = steps;

    	}
    	return states[pattern.length];
    }

    public static boolean match4(char[] pattern, char[] input){
    	return false;
    }

	

	public static void main(String [] args){
		System.out.println(Pattern.match2("abc".toCharArray(),"abc".toCharArray()));
		System.out.println(Pattern.match2("a*c".toCharArray(),"aac".toCharArray()));
		System.out.println(Pattern.match2("a*ac".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match2("a*aaac".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match2("a*aaac".toCharArray(),"aaaaac".toCharArray()));
		System.out.println(Pattern.match2("a*bc".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match2("ac".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match2("aa*c".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match2("aa*\0".toCharArray(),"aa\0".toCharArray())); // add \0 to avoid edge check and * is the laster character
		System.out.println("=========================================== match3 =========================================");
		System.out.println(Pattern.match3("abc".toCharArray(),"abc".toCharArray()));
		System.out.println(Pattern.match3("a*c".toCharArray(),"aac".toCharArray()));
		System.out.println(Pattern.match3("a*ac".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match3("a*aaac".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match3("a*aaac".toCharArray(),"aaaaac".toCharArray()));
		System.out.println(Pattern.match3("a*bc".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match3("ac".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match3("aa*c".toCharArray(),"aaac".toCharArray()));
		System.out.println(Pattern.match3("aa*\0".toCharArray(),"aa\0".toCharArray()));
	}

}