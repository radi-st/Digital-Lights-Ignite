package org.example;

class KnuthMorrisPrattSearch implements StringSearch{
    private void buildKMPTable(String part, int [] kmp_table){
        int i = 0;
        int j = -1;
        int part_len=part.length();
        kmp_table[0]=-1; // end of window marker
        while ( i < part_len-1 ) {
            while ( j > -1 && part.charAt(i) != part.charAt(j)) {
                j = kmp_table[j];
            }
            i++;
            j++;
            if ( part.charAt(i)== part.charAt(j))
                kmp_table[ i ]= kmp_table[ j ];
            else kmp_table[ i ]= j;
        }
    }
    public int positionOf(String part, String whole) {
        if(part.length()==0){
            return 0;
        }
        int [] kmp_table=new int [part.length()+1];
        buildKMPTable(part,kmp_table);
        int whole_len=whole.length();
        int part_len=part.length();
        int i=0, j=0;
        while(j<whole_len){
            while(i>-1 && part.charAt(i)!=whole.charAt(j)){
                i=kmp_table[i];
            }
            i++;
            j++;
            if(i>=part_len){
                return j-i;
            }
        }
        return -1;
    }

}