package mentorias.week3;

public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("a"));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int wordStart = s.length() - 1;
        int wordEnd = s.length() - 1;
        while(wordStart >= 0){
            while(wordStart >= 0 && s.charAt(wordStart) == ' '){
                wordStart--;
                wordEnd--;
            }
            if(wordStart == -1 && wordEnd == -1) break;
            while(wordStart >= 0 && s.charAt(wordStart) != ' ') wordStart--;
            StringBuilder currentWord = new StringBuilder();
            for(int i = wordStart + 1 ; i <= wordEnd ; i++) currentWord.append(s.charAt(i));
            if(!sb.isEmpty()) sb.append(' ');
            sb.append(currentWord);
            wordEnd = wordStart;
        }
        return sb.toString();
    }
}
