package mentorias.week1;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("apple", "a2e"));
    }

    public static boolean validWordAbbreviation(String word, String abbr){
        int p1 = 0;
        int p2 = 0;
        while(p1 < word.length() && p2 < abbr.length()){
            if(!Character.isDigit(abbr.charAt(p2))){
                if(word.charAt(p1++) != abbr.charAt(p2++)) return false;
            }else{
                StringBuilder offset = new StringBuilder();
                if(abbr.charAt(p2) == '0') return false;
                while(p2 < abbr.length() && Character.isDigit(abbr.charAt(p2))) offset.append(abbr.charAt(p2++));
                p1 += Integer.parseInt(offset.toString());
            }
        }
        return p1 == word.length() && p2 == abbr.length();
    }
}
