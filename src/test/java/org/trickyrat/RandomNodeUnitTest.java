package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RandomNodeUnitTest {
    @Test
    public void test() {
        List<Integer> results = Arrays.asList(1,2,3,4);
        RandomNode node = new RandomNode(Utilities.createListNode(new int[]{1, 2, 3}));
        Assertions.assertTrue(results.contains(node.getRandom()));
        Assertions.assertTrue(results.contains(node.getRandom()));
        Assertions.assertTrue(results.contains(node.getRandom()));
        Assertions.assertTrue(results.contains(node.getRandom()));
        Assertions.assertTrue(results.contains(node.getRandom()));
    }
}