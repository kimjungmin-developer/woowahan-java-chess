package chess.model.piece;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Route {
    private final List<String> route;

    public Route(List<String> route) {
        this.route = route;
    }

    public List<String> getRoute() {
        return Collections.unmodifiableList(route);
    }

    public boolean contains(String coordinates) {
        String target = route.get(route.size() - 1);
        if (!coordinates.equals(target)) {
            return route.contains(coordinates);
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route1 = (Route) o;
        return Objects.equals(route, route1.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route);
    }
}
