package com.LABS.lab4;

import java.util.*;

class Production{
    int p=0;
    String LHS="";
    ArrayList<String> RHS = new ArrayList<String>();
    Set translationword =new HashSet();
    Set first=new HashSet();
    ArrayList<String> fillFirstset = new ArrayList<String>();
    ArrayList<Integer> fillFirstnu = new ArrayList<Integer>();
    ArrayList<String> tempRHS = new ArrayList<String>();
    int DerivesEmptynumber =0;
    boolean DerivesEmpty = false;
    Set Followtranslationword=new HashSet();
    Set follow = new HashSet();
    ArrayList<String> fillFollowset = new ArrayList<String>();
    ArrayList<String> fillFollowFirstset = new ArrayList<String>();
    ArrayList<Integer> fillFollowFirstnu = new ArrayList<Integer>();
    Set answer = new HashSet();

    void setp(int i){
        p=i;
    }
    void setLHS(String l){
        LHS=l;
    }
}