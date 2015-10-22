package com.fire.string.ahocorasick;

import org.junit.Test;

/**
 * Created by jianjin on 9/2/15.
 */
public class TestAhoCorasick {

    @Test
    public void testTrieConstruction(){
        AhoCorasick.init().construct("abc", "ab", "abcd", "bc").printTrie();
        
        System.out.println("--------------");
        
        AhoCorasick.init().construct("a", "ab", "bab", "bc", "bca", "c" , "caa").printTrie();

    }
}
