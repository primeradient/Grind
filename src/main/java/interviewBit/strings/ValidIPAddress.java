package interviewBit.strings;

import java.util.ArrayList;
import java.util.Collections;

/*

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)


 */
public class ValidIPAddress {

    public boolean isValidIP(int ip) {
        return ip >= 0 && ip <= 255;
    }


    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i < A.length(); i++) {
            if ( i > 3) {
                continue;
            }
            for (int j = i + 1; j < A.length(); j++) {
                if ( j - i > 3) {
                    continue;
                }
                for (int k = j+1;  k < A.length(); k++) {
                    if ( k - j  > 3 ) {
                        continue;
                    }
                    if ( A.length() - k > 3) {
                        continue;
                    }
                    int a = Integer.parseInt(A.substring(0,i));
                    int b = Integer.parseInt(A.substring(i,j));
                    int c = Integer.parseInt(A.substring(j,k));
                    int d = Integer.parseInt(A.substring(k, A.length()));

                    if (   isValidIP(a) && isValidIP(b) && isValidIP(c) && isValidIP(d)) {
                        String ipStr = a + "." + b + "." + c + "." + d;
                        if ( !res.contains(ipStr)) {
                            res.add(ipStr);
                        }
                    }
                }
            }
        }

        Collections.sort(res);

        return res;
    }


    public static void main(String [] args) {
        ArrayList<String> ips = new ValidIPAddress().restoreIpAddresses("25525511135");

        for ( String ip : ips) {
            System.out.println(ip);
        }

    }

}
