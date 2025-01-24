import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class strPeturbations {
    /*
     * Given one larger string and an array of shorter strings (words) of same length, 
     * get all possible peturbations of shorter strings, and
     * find them inside the larger string.
     * Return an array of starting indices of found matches, else empty array.
     * 
     * Examples:
     * 
     * Input:       s = "barfoothefoobarman", words = ["foo","bar"]
     * Output:      [0,9]
     * Explanation: "barfoo" found at 0 and "foobar" found at 9.
     * 
     * Input:       s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     * Output:      [6,9,12]
     * Explanation: Matching permutations; "foobarthe", "barthefoo", "thefoobar"
     * 
     * ["bar","foo","the"] -> "barfoothe", "barthefoo", "foothebar", "foobarthe", "thebarfoo", "thefoobar"
     * 
     * ["bar","foo","the", "not"]
     * -> barfoothenot, barfoonotthe, barthenotfoo, barthefoonot, barnotfoothe, barnotthefoo
     */
    
    public void run() {
        runTests();
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 1) {
            if (s.contains(words[0])) return List.of(0);
            return List.of();
        }
        var permutations    = permute(words);
        var result          = new HashSet<Integer>();
        for (String permutation : permutations) {
            if (s.contains(permutation)) result.add(s.indexOf(permutation));
        }
        print("Resulting int: " + result);
        return new ArrayList<>(result);
    }

    public String[] permuteTwo(String[] nodes) {
        return new String[]{
            nodes[0]+nodes[1], 
            nodes[1]+nodes[0]
        };
    }

    public String[] permute(String[] nodes) {
        /*
         * Recurse selecting each word as root and rest as nodes until nodes have length two.
         * Generate two permutations of those nodes and then combine with the root:
         * Input:           nodes = bar, foo, the, not
         * Recursed Input:  nodes = foo, the, not
         * Recursed Input:  nodes = the, not
         * 
         * Permutations two nodes = thenot, notthe
         * 
         * Combine with root = foothenot, foonotthe, the..., not...
         * Combine with root = barfoothenot, bar..., foo..., the..., not...
         */
        var result = new ArrayList<String>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes.length == 2) return permuteTwo(nodes);                // thenot, notthe // foothenot, foonotthe

            var root         = nodes[i];                                    // bar
            var newNodes     = new String[nodes.length - 1];
            var newNodeIndex = 0;
            for (int j = 0; j < nodes.length; j++) {
                if (nodes[j] != root) newNodes[newNodeIndex++] = nodes[j];  // foo, the, not
            }
            var permutations = permute(newNodes);                           // barfoothenot, barfoonotthe
            for (String permutedNodes : permutations) { result.add(root+permutedNodes); }
        }
        return result.toArray(String[]::new);
    }

    public void runTests() {
        var testNum = 1;

        var s       = "barfoothefoobarman";
        var words   = new String[]{"foo","bar"};
        var result  = findSubstring(s, words);
        print("Has test passed? " + checkResult(List.of(0,9), result));
        testNum++;

        s       = "wordgoodgoodgoodbestword";
        words   = new String[]{"word","good","best","word"};
        result  = findSubstring(s, words);
        print("Has test passed? " + checkResult(List.of(), result));
        testNum++;

        s       = "barfoofoobarthefoobarman";
        words   = new String[]{"bar","foo","the"};
        result  = findSubstring(s, words);
        print("Running test: "+testNum+". Has test passed? " + checkResult(List.of(6,9,12), result));
        testNum++;
    }

    public boolean  checkResult(List<Integer> expected, List<Integer> actual) { return expected.containsAll(actual); }
    public void     print(Object o) { System.out.println(o); } 
}
