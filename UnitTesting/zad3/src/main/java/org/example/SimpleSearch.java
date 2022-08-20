package org.example;

class SimpleSearch implements StringSearch {
    public int positionOf(String part, String whole) {

        int j=0, i=0;
        for (; j <= whole.length() - part.length(); j++) {
            for (; i < part.length() && part.charAt(i) == whole.charAt(i + j); i++) {
            }
            if (i >= part.length()) {
                return j;
            }
        }
        return -1;
    }
}
