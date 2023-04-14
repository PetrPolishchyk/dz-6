import java.util.*;

import static java.lang.Integer.sum;

public class Main {
    public static void main(String[] args) {
        //get the string array
        String [] theArrayOfWords = new String[] {"mama", "papa", "eat", "hedgehog", "jell"};
        getTheResult(theArrayOfWords);
    }

    public static void getTheResult(String[] wordsToCheck){

        List<String> myList = new ArrayList<>();

        for (String word : wordsToCheck) {
            char[] charsArray = word.toCharArray();

            Map<Character, Integer> myMap = new HashMap<>();

            for (Character character : charsArray) {
                if (myMap.containsKey(character)) {
                    Integer value = myMap.get(character) + 1;
                    myMap.put(character, value);
                } else {
                    myMap.put(character, 1);
                }
            }

            Collection<Integer> valuesOfTheMap = myMap.values();
            int sumOfAllValues = sumOfMapValues(valuesOfTheMap);
            int mapSize = myMap.size();
            if (sumOfAllValues % 2 == 0 && sumOfAllValues / mapSize == 2){
                myList.add(word);
            }
        }

        Set<Character> mySet = new HashSet<>();
        for (String words : myList){
            for (Character character : words.toCharArray()){
                mySet.add(character);
            }
        }
        //print the list of unique letters
        System.out.println(mySet);
    }

    private static int sumOfMapValues(Collection<Integer> valueSet) {
        int sum = 0;
        for (Integer values : valueSet){
            sum = sum + values;
        }
        return sum;
    }


}
