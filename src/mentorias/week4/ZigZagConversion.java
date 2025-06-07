package mentorias.week4;

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }

    public static String convert(String s, int numRows){
        if(s.length() <= 2 || numRows <= 1) return s;
        StringBuilder result = new StringBuilder();
        int offset = 2 * (numRows - 1);
        for(int i = 0 ; i < numRows ; i++){
            int j = i;
            while(j < s.length()){
                result.append(s.charAt(j));
                j += offset;
                if(j % (numRows - 1) != 0 && (j - 2 * j % offset) < s.length()) result.append(s.charAt(j - 2 * j % offset));
            }
        }
        return result.toString();
    }
}
