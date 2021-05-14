package com.LABS;

import java.util.ArrayList;
class List {

    public ArrayList<Integer> list;

    public List() {
        list = new ArrayList<>();
    }

    public void cons(int value) {
        list.add(value);
    }

    public int head() {
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        return list.get(list.size() - 1);
    }

    public void tail() {
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        list.remove(list.size() - 1);
    }

    public boolean isNull() {
        return list.isEmpty();
    }

}