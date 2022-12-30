package org.trickyrat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExamRoomUnitTest {
    @Test
    public void test() {
        ExamRoom er = new ExamRoom(10);
        Assertions.assertEquals(0, er.seat());
        Assertions.assertEquals(9, er.seat());
        Assertions.assertEquals(4, er.seat());
        Assertions.assertEquals(2, er.seat());
        er.leave(4);
        Assertions.assertEquals(5, er.seat());
    }

}