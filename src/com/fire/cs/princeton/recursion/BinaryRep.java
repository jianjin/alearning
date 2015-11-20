package com.fire.cs.princeton.recursion;

public class BinaryRep{
	

	public static void toBinary(int n){
		if(n==0) return;
		toBinary( n / 2);
		System.out.print( n % 2);
	}

	public static void main(String [] args){
		toBinary(10);
		System.out.println();
		toBinary(8);
		System.out.println();
	}


}