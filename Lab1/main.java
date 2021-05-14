package com.LABS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String grammar, input;

    private static int findNextProd(int p) {
        char s = grammar.charAt(p);
        do {
            p = p+3;
        } while (!((p>(grammar.length() - 1)) || (grammar.charAt(p) == s)));
        if (p <= grammar.length() - 1) {
            return p;
        } else {
            return -1;
        }
    }
    private static int findLeftmostProd(int p) {
        char s = grammar.charAt(p);
        int i=0;
        while ( (i<=grammar.length() - 1) && (grammar.charAt(i) != s)) {
            i = i+3;
        }
        if (i <= grammar.length() - 1) {
            return i;
        }
        else {
            return -1;
        }
    }
    private static boolean parse(List al, int pg, int ps) {
        if ((al.isNull()) && (pg == -1))
        {
            return false;
        }
        else if (pg == -1)
        {
            int h = al.head();
            al.tail();
            ps--;
            return parse(al,findNextProd(h),ps);
        }
        else if ((grammar.charAt(pg+1) != input.charAt(ps)) ||
                ((grammar.charAt(pg+2)=='.') && (ps != input.length() - 1)) ||
        ((grammar.charAt(pg+2)!='.') && (ps == input.length() - 1)) )
        {
            return parse(al,findNextProd(pg),ps);
        }
else if ((grammar.charAt(pg+2) == '.') && (ps == input.length() - 1))
        {
            return true;
        }
else {
            al.cons(pg);
            ps++;
            return parse(al,findLeftmostProd(pg+2),ps);
        }
    }
    public static void main(String[] args) throws IOException {
//        Grammar is writen in following form:
//        S -> aS  will be  SaS
//        S -> a   will be  Sa.
        grammar = "SaSSbSScDDbDDcRDa.Rb.";
        System.out.println("Type the string to be checked: ");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        input = reader.readLine();
        List al = new List();
        int pg = 0;
        int ps = 0;
        boolean ans = parse(al,pg,ps);
        if (!ans) {
            System.out.println("Word '"+input+"' is not accepted.");
        }
        else
            System.out.println("Word '"+input+"' is accepted.");

    }
}
