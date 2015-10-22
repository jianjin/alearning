package com.fire.string.ahocorasick;

/**
 * Created by jianjin on 9/2/15. implementation the algorithm :
 * https://en.wikipedia.org/wiki/Aho%E2%80%93Corasick_algorithm
 */
public class AhoCorasick {

	Node root;
	String[] _inputs;

	private AhoCorasick() {

	}

	public static AhoCorasick init() {
		AhoCorasick ahoCorasick = new AhoCorasick();
		ahoCorasick.root = new Node((char) 0);
		return ahoCorasick;
	}

	public AhoCorasick construct(String... inputs) {
		_inputs = inputs;
		constructTrie();
		constructSuffixlink();
		constructDictSuffixlink();
		return this;

	}

	private void constructTrie() {
		for (String input : _inputs) {
			INode s = root;
			for (char c : input.toCharArray()) {
				boolean matched = false;
				for (INode child : s.getChilds()) {
					if (child.getValue() == c) {
						s = child;
						matched = true;
						break;
					}
				}
				if (!matched) {
					Node add = new Node(c);
					add.level = s.getLevel() + 1;
					s.getChilds().add(add);
					s = add;
				}
			}
			if (s != root)
				s.setColor(NodeColor.BLUE);
		}
	}

	private void constructSuffixlink() {
		constructSuffixlink(root);
	}

	private void constructSuffixlink(INode node) {
		for (INode child : node.getChilds()) {
			if (node.getSuffixNode().isEmpty()) // Initialize root.
				child.setSuffixNode(node);
			else
				constructSuffixlink(node.getSuffixNode(), child);
		}

		for (INode child : node.getChilds()) {
			constructSuffixlink(child);
		}
	}

	private void constructSuffixlink(INode parentSuffix, INode node) {
		if (parentSuffix.isEmpty())
			return;
		boolean found = false;
		for (INode child : parentSuffix.getChilds()) {
			if (child.getValue() == node.getValue()) {
				node.setSuffixNode(child);
				found = true;
				return;
			}
		}
		if (!found) {
			constructSuffixlink(parentSuffix.getSuffixNode(), node);

		}

	}

	private void constructDictSuffixlink() {
		constructDictSuffixlink(root);
	}

	private void constructDictSuffixlink(INode node) {
		constructDictSuffixlink(node, node.getSuffixNode());
		for (INode child : node.getChilds()) {
			constructDictSuffixlink(child);
		}

	}

	private void constructDictSuffixlink(INode node, INode suffix) {
		if (suffix.isEmpty())
			return;
		if (suffix.getColor().equals(NodeColor.BLUE)) {
			node.setDictSuffixNode(suffix);
		} else {
			constructDictSuffixlink(node, suffix.getSuffixNode());
		}
	}

	public void printTrie() {
		printAllChild(root);
	}

	private void printAllChild(INode s) {
		System.out.print(s.getLevel() + " " + s.getValue() + " -> ");
		for (INode child : s.getChilds()) {
			System.out.print(child);
		}
		System.out.println();

		for (INode child : s.getChilds()) {
			printAllChild(child);

		}
	}
}
