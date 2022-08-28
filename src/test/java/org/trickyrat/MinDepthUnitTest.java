package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinDepthUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode input, int expected) {
        int actual = solution.minDepth(input);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createTreeNodeIteratively("3,9,20,null,null,15,7"), 2),
                Arguments.arguments(Utilities.createTreeNodeIteratively("2,null,3,null,4,null,5,null,6"), 5));
    }
}
