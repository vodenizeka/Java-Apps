package model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Manoeuvre {
    private Set<Direction> directions;
    private int minRange, maxRange;
    private boolean isJump;

    public Manoeuvre() {
        directions = new TreeSet<>();
    }

    public Manoeuvre(Direction[] directions, int minRange, int maxRange, boolean isJump) {
        this();
        setDirections(directions);
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.isJump = isJump;
    }

    public boolean isInRange(int distance) {
        return distance >= minRange && distance <= maxRange;
    }

    public void setManoeuvre(int minRange, int maxRange, boolean isJump) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.isJump = isJump;
    }

    public boolean containsDirection(Direction direction) {
        return directions.contains(direction);
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public boolean isJump() {
        return isJump;
    }

    public void setDirections(Direction[] directions) {
        this.directions.addAll(Arrays.asList(directions));
    }

    public void setDirections(List<Direction> directions) {
        this.directions.addAll(directions);
    }

    public void setDirection(Direction direction) {
        this.directions.add(direction);
    }

    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public void setJump(boolean isJump) {
        this.isJump = isJump;
    }
}
