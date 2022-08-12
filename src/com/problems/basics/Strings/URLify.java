package com.problems.basics.Strings;

public class URLify {
    public static int countSpaces(char[] s, int len){
        int spaces = 0;
        for(int i = len - 1;i >= 0;i--){
            char current = s[i];
            if(current == ' '){
                spaces++;
            }
        }
        return spaces;
    }

    public static char[] transform(char[] s, int len){
        int spaces = countSpaces(s, len);
        int index = len - 1;
        int displacement = spaces * 2;
        while(spaces > 0){
            char current = s[index];
            if(current != ' '){
                s[index + displacement] = current;
            }else{
                s[index + displacement - 2] = '%';
                s[index + displacement - 1] = '2';
                s[index + displacement] = '0';
                spaces--;
                displacement = spaces * 2;
            }
            index--;
        }
        return s;
    }

    public static void main(String[] args){
        char[] s = {'H','e',' ','i','s',' ','b','a','d',' ',' ',' ',' ',' ',' '};
        char[] result = transform(s, 9);
        System.out.println(result);
    }


}
