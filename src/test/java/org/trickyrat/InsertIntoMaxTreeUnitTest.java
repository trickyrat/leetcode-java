package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InsertIntoMaxTreeUnitTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("getData")
    public void test(TreeNode root, int val, TreeNode expected) {
        TreeNode actual = solution.insertIntoMaxTree(root, val);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.arguments(Utilities.createTreeNodeIteratively("4,1,3,null,null,2"), 5,
                        Utilities.createTreeNodeIteratively("5,4,null,1,3,null,null,2")),
                Arguments.arguments(Utilities.createTreeNodeIteratively("5,2,4,null,1"), 3,
                        Utilities.createTreeNodeIteratively("5,2,4,null,1,null,3")),
                Arguments.arguments(Utilities.createTreeNodeIteratively("5,2,3,null,1"), 4,
                        Utilities.createTreeNodeIteratively("5,2,4,null,1,3"))
        );
    }
}