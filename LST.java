import java.util.ArrayList;
import java.util.Collections;
class LST{

	static String input = "idonotlike";
	static String input2 = "youdododonottlike";

	static class M implements Comparable<M>{
		int i,i2=0;
		int length = 0;

		public int compareTo(M o){
			return (length - o.length);
		}

		public String toString(){
			return i+":"+i2+" "+length+"  s:"+input.substring(i, i+length);
		}


	}

	static ArrayList<M> state = new ArrayList<M>();

	static void build0State(){
		for(int i = 0 ; i < input.length(); i++)
			for(int j = 0 ; j < input2.length(); j++){
				if(input.charAt(i) == input2.charAt(j)){
					M m = new M();
					m.i = i; m.i2 = j; m.length = 1;
					state.add(m);
				}
			}
	}

	static void buildLST(){
		for(M m: state){
			int i = m.i, j = m.i2;

			i++;j++;

			while(i < input.length() && j < input2.length()){
				if(input.charAt(i) == input2.charAt(j)){
				m.length++;
				
				}

				i++;j++;

			}
		}

	}

	static void buildLST2(){

		for(M m: state){
			for(M n:state){
				if( (m.i + 1) == (n.i + 1) && (m.i2 + 1) == (n.i2 + 1) ){
					n..length++;
				}
			}
		}

	}

	public static void main(String [] args){
		build0State();
		
		
		Collections.sort(state);

		System.out.println(state);

	}

	

	
}