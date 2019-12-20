package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.approvaltests.Approvals.verify;

public class LiftSystemTest {


    @Test
    public void fulfillRequest() {
        List<Integer> requests = new ArrayList<>();
        requests.add(3);
        Lift liftA = new Lift("A",0, requests, false);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1, 2, 3), Collections.singletonList(liftA), Collections.emptyList());
        LiftSystemPrinter liftSystemPrinter = new LiftSystemPrinter();
        String toVerify = liftSystemPrinter.print(lifts);
        lifts.tick();
        toVerify += "\n\n";
        toVerify += liftSystemPrinter.print(lifts);
        lifts.tick();
        toVerify += "\n\n";
        toVerify += liftSystemPrinter.print(lifts);

        verify(toVerify);
    }

    @Test
    public void idleLift() {
        Lift liftA = new Lift("A",0);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1, 2, 3), Collections.singletonList(liftA), Collections.emptyList());
        LiftSystemPrinter liftSystemPrinter = new LiftSystemPrinter();
        String toVerify = liftSystemPrinter.print(lifts);
        lifts.tick();
        toVerify += "\n\n";
        toVerify += liftSystemPrinter.print(lifts);

        verify(toVerify);
    }
}
