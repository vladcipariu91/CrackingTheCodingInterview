import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LinkedListsDetectCyclesTest {

    private LinkedListsDetectCycles.Node head;
    private boolean hasCycles;

    public LinkedListsDetectCyclesTest(LinkedListsDetectCycles.Node head, boolean hasCycles) {
        this.head = head;
        this.hasCycles = hasCycles;
    }

    @Test
    public void detectLoop() {
        assertEquals(hasCycles, LinkedListsDetectCycles.detectLoop(head));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> linkedListProvider() {
        LinkedListGenerator linkedListGenerator = new LinkedListGenerator();
        return Arrays.asList(new Object[][]{
                {linkedListGenerator.generate(new int[]{1, 2, 3}), false},
                {linkedListGenerator.generate(new int[]{1, 2, 3, 2}), true},
                {linkedListGenerator.generate(new int[]{1, 2, 3, 4, 5, 6, 1}), true},
                {linkedListGenerator.generate(new int[]{}), false},
                {linkedListGenerator.generate(null), false}
        });
    }


}