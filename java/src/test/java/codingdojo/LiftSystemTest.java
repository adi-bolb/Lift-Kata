package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.approvaltests.Approvals.verify;

public class LiftSystemTest {

    private final LiftSystemPrinter liftSystemPrinter = new LiftSystemPrinter();

    private String tickAndVerify(LiftSystem lifts, String toVerify) {
        lifts.tick();
        toVerify += "\n\n";
        toVerify += liftSystemPrinter.print(lifts);
        return toVerify;
    }

    @Test
    public void fulfillRequest() {
        List<Integer> requests = new ArrayList<>();
        requests.add(3);
        Lift liftA = new Lift("A",0, requests, false);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1, 2, 3), Collections.singletonList(liftA), Collections.emptyList());
        String toVerify = liftSystemPrinter.print(lifts);
        toVerify = tickAndVerify(lifts, toVerify);
        toVerify = tickAndVerify(lifts, toVerify);

        verify(toVerify);
    }

    @Test
    public void idleLift() {
        Lift liftA = new Lift("A",0);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1, 2, 3), Collections.singletonList(liftA), Collections.emptyList());
        String toVerify = liftSystemPrinter.print(lifts);
        toVerify = tickAndVerify(lifts, toVerify);

        verify(toVerify);
    }

    @Test
    public void fulfillTwoRequests() {
        List<Integer> requests = new ArrayList<>();
        requests.add(2);
        requests.add(3);
        Lift liftA = new Lift("A",0, requests, false);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1, 2, 3), Collections.singletonList(liftA), Collections.emptyList());
        String toVerify = liftSystemPrinter.print(lifts);
        toVerify = tickAndVerify(lifts, toVerify);

        verify(toVerify);
    }
}
