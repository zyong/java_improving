package gateway.router;

import java.util.List;

public interface IHttpRouter {
    public String route(List<String> endpoints);
}
