class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSize= 0;
		char[] array = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int startIndex = 0;
		for(int i=0 ;i<array.length;i++) {
			if(map.containsKey(array[i]))  {
				int j;
				for(j =startIndex;array[j] != array[i];j++) {
					map.remove(array[j]);
				}
				startIndex = j+1;
			}
			else 
				map.put(array[i], 1);
			if(map.size()>maxSize)
				maxSize = map.size();
		}
		return maxSize;
    }
}