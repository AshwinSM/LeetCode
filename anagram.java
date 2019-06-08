package com.anagram;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static void main(String[] args) {
		String mainString = "abcabc";
		String anagramString="bac";
		int value;
		int anagramCount = 0;
		char[] mainArray = mainString.toCharArray();
		char[] anagramArray = anagramString.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
		
		
		for(int i = 0;i<anagramArray.length;i++) {
			if(map.containsKey(anagramArray[i])) 
				value = (int)map.get(anagramArray[i]) + 1;
			else 
				 value = 1;
			map.put(anagramArray[i],value);
		}
		tempMap.putAll(map);
		int zeroValueCount = 0;
		int startIndex = 0;
		boolean isAnagramStart = true;
		
		for(int i=0;i<mainArray.length;i++) {
			if(tempMap.containsKey(mainArray[i])) {
				if(isAnagramStart) {
					startIndex = i;
					isAnagramStart = false;
				}
				int occurence = (int)tempMap.get(mainArray[i]);
				if(occurence > 0) {
						tempMap.put(mainArray[i], --occurence);
						if(occurence == 0) {
							zeroValueCount++; 
							if(zeroValueCount == map.size()) {
								anagramCount++;
								i = i - anagramArray.length+1;
								isAnagramStart = true;
								zeroValueCount = 0;
								tempMap.clear();
								tempMap.putAll(map);
							}
						}
				}else {
					int j;
					for(j = startIndex; tempMap.get(mainArray[j]) != tempMap.get(mainArray[i]) ;j++ ) {
						int occrnce = tempMap.get(mainArray[j]);
						tempMap.put(mainArray[j], ++occrnce);
					}
					startIndex = j;
				}
			}
			else {
				isAnagramStart = true;
				zeroValueCount = 0;
				tempMap.clear();
				tempMap.putAll(map);
			}
		}
		
		System.out.println("Anagram Count "+ anagramCount);
		
	}
}
