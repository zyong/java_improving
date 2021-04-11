import main.java.locks.LockCounter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LockCounterTest {

    @Test
    public void testLockCounter() {
        int loopNum = 100_000;
        LockCounter counter = new LockCounter();
        List<Integer> listOfInteger = new ArrayList<>();
        listOfInteger = IntStream.range(0, loopNum)
                .parallel()
                .limit(10000)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        for (int i=0; i<listOfInteger.size(); i++) {
            System.out.println(listOfInteger.get(i));
        }

    }

}
