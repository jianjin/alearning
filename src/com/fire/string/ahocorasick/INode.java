package com.fire.string.ahocorasick;

import java.util.List;

public interface INode {
	
public char getValue();
	
	public void setLevel(int level);
	
	public void setColor(NodeColor color);
	
	public void setValue(char c);
	
	public int getLevel();
	
	public NodeColor getColor();
	
	public INode getSuffixNode();
	
	public INode getDictSuffixNode();
	
	public void setSuffixNode(INode suffix);
	
	public void setDictSuffixNode(INode dictSuffix);
	
	public List<INode> getChilds();
	
	public boolean isEmpty();

}
