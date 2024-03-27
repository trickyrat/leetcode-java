package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.trickyrat.DataStructures.Node;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PostOrderUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(Node root, List<Integer> expected) {
        var actual = solution.postorder(root);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Util.generateNTreeNode("1,null,3,2,4,null,5,6"), Arrays.asList(5,6,3,2,4,1)),
                Arguments.arguments(Util.generateNTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14"), Arrays.asList(2,6,14,11,7,3,12,8,4,13,9,10,5,1)));
    }
}
