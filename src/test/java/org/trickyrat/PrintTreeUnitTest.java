package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrintTreeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode root, List<List<String>> expected) {
        List<List<String>> actual = solution.printTree(root);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createTreeNode("1,2"),
                        Arrays.asList(
                                Arrays.asList("", "1", ""),
                                Arrays.asList("2", "", ""))),
                Arguments.arguments(Utilities.createTreeNode("1,2,3,null,4"),
                        Arrays.asList(Arrays.asList("", "", "", "1", "", "", ""),
                                Arrays.asList("", "2", "", "", "", "3", ""),
                                Arrays.asList("", "", "4", "", "", "", ""))));
    }
}
