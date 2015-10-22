package com.fire.string.ahocorasick;

import java.util.Collections;
import java.util.List;

public class EmptyNode implements INode {

	private final static INode node = new EmptyNode();
	
	public static INode getEmptyNode(){
		return node;
	}
	
	private EmptyNode(){
		
	}
	
	@Override
	public char getValue() {
		
		return 0;
	}

	@Override
	public INode getSuffixNode() {
		
		return node;
	}

	@Override
	public INode getDictSuffixNode() {
		
		return node;
	}

	@Override
	public List<INode> getChilds() {
		
		return Collections.emptyList();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int getLevel() {
		return -1;
	}

	@Override
	public NodeColor getColor() {
		return NodeColor.GRAY;
	}

	@Override
	public void setLevel(int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(NodeColor color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSuffixNode(INode suffix) {
		
	}

	@Override
	public void setDictSuffixNode(INode dictSuffix) {
		
	}

}
