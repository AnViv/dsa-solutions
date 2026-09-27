//Lexicographically Next Permutation of given String
//https://www.geeksforgeeks.org/cpp/lexicographically-next-permutation-in-cpp/

package gfg.strings;

public class LexicographicallyNextPermutationString {
    public static void main(String[] args) {
        String[] words = {"gfg", "bgedcba", "ggf", "dcba", "fgedcba", "agedcba", "egedcba", "gzedcba"};
        for(String word : words) {
            System.out.println(word+ "->" + getNextPermutation(word));
        }
    }

    private static String getNextPermutation(String word) {
        if(word==null || word.length()<=1) {
            return word;
        }
        StringBuilder result = new StringBuilder(word);
        int len = result.length();
        int i = len-1;
        while(i>0 && result.charAt(i)<=result.charAt(i-1)) {
            i--;
        }
        if(i==0) {
            return "No next permutation";
        }
        int j = len-1;
        while(j>i && result.charAt(i-1)>=result.charAt(j)) {
            j--;
        }
        swap(result, i-1, j);
        reverse(result, i, len-1);

        return result.toString();
    }

    private static void swap(StringBuilder word, int i, int j) {
        char temp = word.charAt(i);
        word.setCharAt(i, word.charAt(j));
        word.setCharAt(j, temp);
    }

    private static void reverse(StringBuilder word, int i, int j) {
        while(i<j) {
            swap(word, i, j);
            i++;
            j--;
        }
    }
}

//output
/*
gfg->ggf
bgedcba->cabbdeg
ggf->No next permutation
dcba->No next permutation
fgedcba->gabcdef
agedcba->baacdeg
egedcba->gabcdee
gzedcba->zabcdeg
 */