import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> stringToFrequency = new HashMap<>();
        for (String word : words) {
            if (stringToFrequency.containsKey(word)) {
                stringToFrequency.put(word, stringToFrequency.get(word) + 1);
            } else {
                stringToFrequency.put(word, 1);
            }
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int val = stringToFrequency.get(o2) - stringToFrequency.get(o1);
                if (val == 0) {
                    return o1.compareTo(o2);
                }
                return val;
            }
        });
        for (String word : stringToFrequency.keySet()) {
            maxHeap.add(word);
        }
        List<String> topK = new ArrayList<>();
        while (topK.size() < k && !maxHeap.isEmpty()) {
            String maxFrequent = maxHeap.remove();
            topK.add(maxFrequent);
        }
        return topK;
    }

    @Test
    public void testTopKFrequent() {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> topK = topKFrequent(words, k);
        assertEquals(2, topK.size());
        List<String> expected = new ArrayList<>();
        expected.add("i");
        expected.add("love");
        assertEquals(expected, topK);
    }
    @Test
    public void testTopKFrequent1() {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> topK = topKFrequent(words, k);
        assertEquals(4, topK.size());
        List<String> expected = new ArrayList<>();
        expected.add("the");
        expected.add("is");
        expected.add("sunny");
        expected.add("day");
        assertEquals(expected, topK);
    }
}
