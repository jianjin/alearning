package com.fire.string.ahocorasick;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jianjin on 9/2/15.
 */
public class Node implements INode{
    int level = 0;
    INode suffixlink = EmptyNode.getEmptyNode();
    INode dictSuffixLink = EmptyNode.getEmptyNode();
    List<INode> childs =  new LinkedList<INode>();
    NodeColor color = NodeColor.GRAY;
    char value = 0;


    public Node(char v){
        value = v;
    }



    @Override
    public String toString(){
     return "("+level+" : "+value+ " " + color + " suffix: "
             + suffixlink.getLevel() + " "+ suffixlink.getValue() + " " + suffixlink.getColor()+
             " DictSuffix: "
             + dictSuffixLink.getLevel() + " "+ dictSuffixLink.getValue() + " " + dictSuffixLink.getColor()+")";
//        return "("+color+","+value+":"+suffixlink.value+","+suffixlink.color+":"+dictSuffixLink.value+")";
    }



	@Override
	public char getValue() {
		return value;
	}



	@Override
	public INode getSuffixNode() {
		return suffixlink;
	}



	@Override
	public INode getDictSuffixNode() {
		return dictSuffixLink;
	}



	@Override
	public List<INode> getChilds() {
		return childs;
	}



	@Override
	public boolean isEmpty() {
		return false;
	}



	@Override
	public int getLevel() {
		
		return level;
	}



	@Override
	public NodeColor getColor() {
		
		return color;
	}



	@Override
	public void setLevel(int level) {
		this.level = level;
	}



	@Override
	public void setColor(NodeColor color) {
		this.color = color;
	}



	@Override
	public void setValue(char c) {
		this.value = c;
	}



	@Override
	public void setSuffixNode(INode suffix) {
		this.suffixlink = suffix;
	}



	@Override
	public void setDictSuffixNode(INode dictSuffix) {
		this.dictSuffixLink = dictSuffix;
	}

}
