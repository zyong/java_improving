package gateway.router;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinHttpRouter implements IHttpRouter {
    static int DELTA = 1;
    static AtomicInteger cnt = new AtomicInteger();

    @Override
    public String route(List<String> endpoints) {
        return endpoints.get(cnt.addAndGet(DELTA) % endpoints.size());
    }
}
