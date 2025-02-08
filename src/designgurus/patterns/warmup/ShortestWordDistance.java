package designgurus.patterns.warmup;

public class ShortestWordDistance {
    public static void main(String[] args) {
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String word1 = "fox";
        String word2 = "dog";
        System.out.println(shortestDistance(words, word1, word2));
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        String foundWord = null;
        int left = -1;
        int shortestDistance = Integer.MAX_VALUE;
        for(int i = 0 ; i < words.length ; i++){
            String currentWord = words[i];
            if(currentWord.equals(word1) || currentWord.equals(word2)){
                if(foundWord == null){
                    foundWord = currentWord;
                    left = i;
                    continue;
                }
                if(foundWord.equals(currentWord)){
                    left = i;
                    continue;
                }
                foundWord = currentWord;
                shortestDistance = Math.min(i - left, shortestDistance);
                left = i;
            }
        }
        return shortestDistance;
    }
}
