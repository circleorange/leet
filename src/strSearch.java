public class strSearch {
    /*
     * Given two strings, return index of the first occurrence of one in the other.
     * -1 if no substring exists.
     * 
     * Example:
     * 
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6, with first being at 0.
     */
    public void run() {
        var result = strStr("sadbutsad", "sad");
        print(result);
        assert result == 0;

        result = strStr("leetcode", "leeto");
        print(result);
        assert result == -1;

        result = strStr("sabutsad", "sad");
        print(result);
        assert result == 5;

        result = strStr("leet", "leeto");
        print(result);
        assert result == -1;

        result = strStr("l", "l");
        print(result);
        assert result == 0;

        result = strStr("f", "l");
        print(result);
        assert result == -1;

        result = strStr("fastandfurious", "and");
        print(result);
        assert result == 4;
    }

    public int strStr(String haystack, String needle) {
        var haylen  = haystack.length();
        var needlen = needle.length();
        if (haylen < needlen) return -1; // Guard clause, substring longer than string
        for (int i=0; i<haylen-(needlen-1); i++) {
            print("Value of string "+haystack.substring(i, i+(needlen-1))+", Value of substring "+needle);
            if (haystack.substring(i, i+needlen).contains(needle)) return i;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        print("----------");
        print("Starting search for substring in string");

        for (int i=0; i<haystack.length(); i++) {
            print("Starting iteration "+i);
            if ((haystack.length()-i) < needle.length()) return -1; // We have insufficient characters to complete the match
            
            var streak = 0; // Current streak of matching characters

            while ((streak < needle.length()) && (haystack.charAt(streak+i) == needle.charAt(streak))) { // Zip two strings until end
                var index = streak+i;
                print("Match found at index "+index+"["+haystack.charAt(streak+i)+"] with character "+streak+"["+needle.charAt(streak)+"]");
                streak++;
            }
            print("Escaped loop on index "+(streak+i)+" with streak "+streak+" for substring of len "+needle.length());
            if (streak == needle.length()) {
                print("Found substring in string");
                return i; // We have reached the end of string and everything matches
            }
        }
        print("Unhandled exception");
        return -1;
    }

    public void print(Object obj) {
        System.out.println(obj);
    }
}
