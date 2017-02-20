/**
*Given a word , rearrange the letters of  to construct another word  in such a way that  is lexicographically greater than . In case of multiple possible answers, find the lexicographically smallest one *among them.
**/


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i=0; i<n; i++) {
            String source = in.next();
            //System.out.println("Source : " + source);
            char[] cSource = source.toCharArray();
            int l = cSource.length;
            //System.out.println("length  : " + l);
            
            if (l == 0 || l == 1) {
                System.out.println("no answer");
                continue;
            }
            int j=0;
            for ( j=l-2; j>=0; j--) {
                if (cSource[j] < cSource[j+1]) {
                    // I have found the answer just rearrange it.
                    int index = j+1;
                    int k = 0;
                    for ( k=j+1; k<l; k++) {
                        if (cSource[k] < cSource[j]) {
                            char temp = cSource[j];
                            cSource[j] = cSource[k-1];
                            cSource[k-1] = temp;
                            break;
                        }
                    }
                    if (k == l) {
                        char temp = cSource[j];
                        cSource[j] = cSource[l-1];
                        cSource[l-1] = temp;
                    } 
                    System.out.println(reverse(cSource, index));
                    break;
                }
            }
            if (j < 0) 
                System.out.println("no answer");
        }
    }
    
    public static String reverse(char[] chars, int index) {
        StringBuilder sb = new StringBuilder();
        int length = chars.length;
        for(int i=0; i<length; i++) {
            if (i < index) {
                sb.append(chars[i]);
            }
            else if (i >= index) {
                sb.append(chars[length-1 - i + index]);
            }
        }
        return sb.toString();
    }
}
