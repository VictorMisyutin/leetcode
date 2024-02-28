import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        HashMap <Character, Integer> totalWord2Map = new HashMap<>();
        for(String word2 : words2){
            HashMap <Character, Integer> sectionWord2Map = new HashMap<>();
            for(char c : word2.toCharArray()){
                if(sectionWord2Map.containsKey(c)) sectionWord2Map.put(c,sectionWord2Map.get(c) + 1);
                else sectionWord2Map.put(c,1);                
            }
            for(char c : word2.toCharArray()){
                if(!totalWord2Map.containsKey(c)) totalWord2Map.put(c,sectionWord2Map.get(c));
                else{
                    if(totalWord2Map.get(c) < sectionWord2Map.get(c)) totalWord2Map.put(c,sectionWord2Map.get(c));
                }
            }
        }
        System.out.println(Arrays.asList(totalWord2Map));

        for(String word1 : words1){
            HashMap <Character, Integer> secondaryMap = new HashMap<>();
            for(char c : word1.toCharArray()){
                if(secondaryMap.containsKey(c))
                    secondaryMap.put(c,secondaryMap.get(c) + 1);
                else
                    secondaryMap.put(c,1);
            }
            boolean addWord = true;
            for(Map.Entry<Character,Integer> entry : totalWord2Map.entrySet()){
                if(!secondaryMap.containsKey(entry.getKey()) || entry.getValue() > secondaryMap.get(entry.getKey())){
                    addWord = false;
                    break;
                }
            }
            if(addWord) result.add(word1);
        }
        return result;
    }
}

// // solution timed out, time limit exceeded
// import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;

// class Solution {
//     public List<String> wordSubsets(String[] words1, String[] words2) {
//         List<String> result = new ArrayList<>();
//         for(String word : words1){
//             HashMap<Character, Integer> wordMap = new HashMap<>();
//             for(int i = 0; i < word.length(); i++){
//                 if(wordMap.containsKey(word.charAt(i))) wordMap.put(word.charAt(i), wordMap.get(word.charAt(i))+1);
//                 else wordMap.put(word.charAt(i), 1);
//             }

//             boolean putWord = true;
//             for(String word2 : words2){
//                 HashMap<Character, Integer> wordMapCopy = new HashMap<>(wordMap);

//                 if(word2.length() > wordMapCopy.size()){
//                     putWord = false;
//                     break;
//                 }
//                 for(int i = 0; i < word2.length(); i++){
//                     if(wordMapCopy.containsKey(word2.charAt(i))) {
//                         wordMapCopy.put(word2.charAt(i), wordMapCopy.get(word2.charAt(i))-1);
//                         if(wordMapCopy.get(word2.charAt(i)) < 0){
//                             putWord = false;
//                             break;
//                         } 
//                     }
//                     else {
//                         putWord = false;
//                         break;
//                     }
//                 }
//             }
//             if(putWord) result.add(word);
//         }
//         return result;
//     }
// }