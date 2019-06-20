package chess.model;

import java.util.List;
import java.util.Objects;

public class Vector {
    private Direction direction;
    private Magnitude magnitude;

    public Vector(List<Coordinate> coordinates) {
        if (Objects.isNull(coordinates) || coordinates.isEmpty()) {
            throw new NullPointerException();
        }
        direction = Direction.findDirection(coordinates);
        magnitude = new Magnitude(coordinates, direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }
}