package model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Direction {
    HORIZONTAL_LEFT,
    HORIZONTAL_RIGHT,
    VERTICAL_UP,
    VERTICAL_DOWN,
    DIAGONAL_UP,
    DIAGONAL_DOWN,
    IRREGULAR;

    public static List<Direction> getOrthogonalDirections() {
        List<Direction> directions = new LinkedList<>();
        directions.addAll(Arrays.asList(
                Direction.VERTICAL_UP, Direction.VERTICAL_DOWN,
                Direction.HORIZONTAL_LEFT, Direction.HORIZONTAL_RIGHT
        ));
        return directions;
    }

    public static List<Direction> getDiagonalDirections() {
        List<Direction> directions = new LinkedList<>();
        directions.addAll(Arrays.asList(
                Direction.DIAGONAL_UP, Direction.DIAGONAL_DOWN
        ));
        return directions;
    }

    public static List<Direction> getAllDirections() {
        List<Direction> directions = new LinkedList<>();
        directions.addAll(getDiagonalDirections());
        directions.addAll(getOrthogonalDirections());
        return directions;
    }

}
