import java.util.*;
import java.io.*;

public class CheckPermutations {
  public static boolean isPermutation(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    if (a.length != b.length) return false;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) return false;
    }
    return true;
  }
  
  public static boolean isPermutation2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	public static String sort(String str) {
		char[] temp = str.toCharArray();
		java.util.Arrays.sort(temp);
		return new String(temp);
	}
  
  public static void main(String[] args) {
    System.out.println(isPermutation("abc", "cba") ? "It is a permutation" : "It is not a permutation");
    System.out.println(isPermutation("test", "estt") ? "It is a permutation" : "It is not a permutation");
    System.out.println(isPermutation("testt", "estt") ? "It is a permutation" : "It is not a permutation");
    System.out.println(isPermutation2("testy", "ytest") ? "It is a permutation" : "It is not a permutation");
  }
}
