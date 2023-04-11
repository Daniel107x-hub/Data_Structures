package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddresses {
    public static void main(String[] args) {
        ArrayList<String> ips = new ArrayList<>();
        String[] ip = {"", "", "", ""};
        validIPAddressesRecursive(ips, ip, "1921680", 0, 0);
        for(String res : ips){
            System.out.println(res);
        }
    }

    public static ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ips = new ArrayList<>();
        String[] ip = {"", "", "", ""};
        return validIPAddressesRecursive(ips, ip, string, 0, 0);
    }

    public static ArrayList<String> validIPAddressesRecursive(ArrayList<String> results, String[] ip, String string, int count, int start){
        if(count == 3){
            String result = string.substring(start);
            if(isValid(result)) {
                ip[count] = result;
                results.add(String.join(".", ip));
            }
            return results;
        }
        for(int i = start + 1 ; i < Math.min(string.length(), start + 4) ; i++){
            String result = string.substring(start, i);
            if(!isValid(result)) continue;
            ip[count] = result;
            validIPAddressesRecursive(results, ip, string, count + 1, i);
        }
        return results;
    }

    public static ArrayList<String> validIPAddressesIterative(String string) {
        ArrayList<String> result = new ArrayList<>();
        if(string.length() < 4) return result;
        for(int i = 1; i < 4; i++){
            String[] ip = {"", "", "", ""};
            String octet = string.substring(0, i);
            if(!isValid(octet)) continue;
            ip[0] = octet;
            for(int j = i + 1 ; j < Math.min(string.length(), i + 4) ; j++){
                octet = string.substring(i, j);
                if(!isValid(octet)) continue;
                ip[1] = octet;
                for(int k = j + 1 ; k < Math.min(string.length(), j + 4) ; k++){
                    octet = string.substring(j, k);
                    String last = string.substring(k);
                    if(!isValid(octet) || !isValid(last)) continue;
                    ip[2] = octet;
                    ip[3] = last;
                    String res = String.join(".", ip);
                    result.add(res);
                }
            }
        }
        return result;
    }

    public static boolean isValid(String octet){
        int intValue = Integer.parseInt(octet);
        return intValue <= 255 && String.valueOf(intValue).length() == octet.length();
    }

}
