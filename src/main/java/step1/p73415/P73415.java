package step1.p73415;

import java.util.*;

class Point implements Comparable<Point> {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point o) {
        if (o.x() == this.x && o.y() == this.y) {
            return 0;
        }
        return -1;
    }
}

class Route {

    private Point start;
    private Point end;

    public Route(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public boolean isSameRoute(Point inputStart, Point inputEnd) {
        return (isSame(start, inputStart) && isSame(end, inputEnd));
    }

    private boolean isSame(Point alpha, Point beta) {
        return alpha.x() == beta.x() && alpha.y() == beta.y();
    }

}

enum Direction {

    L(new Point(-1, 0)),
    R(new Point(1, 0)),
    U(new Point(0, 1)),
    D(new Point(0, -1));

    private Point point;

    public Point point() {
        return this.point;
    }

    public Point Calculator(Point inputPoint) {
        return new Point(inputPoint.x() + this.point.x(), inputPoint.y() + this.point.y());
    }

    Direction(Point point) {
        this.point = point;
    }

}

class Stage {
    private static final int EDGE_VALUE = 5;
    private static Map<Point, Point> visitMap;

    public boolean isEdge(Point point) {
        return (ABS(point.x()) >= EDGE_VALUE || ABS(point.y()) >= EDGE_VALUE);
    }

    private int ABS(int value) {
        return (value >= 0) ? value : value * -1;
    }

    public void addVisitedRoute(Point start, Point end) {
        visitMap.put(start, end);
    }

//    public boolean checkVisitRoute(Point start, Point end) {
//        return visitMap.co
//    }
}

class Robot {
    private Point point;
    private Stage stage;
    private int moveCount;
    private List<Point> visitList;

    public Robot(Stage stage) {
        this(stage, new Point(0, 0));
    }

    public Robot(Stage stage, Point point) {
        this.stage = stage;
        this.point = point;
        visitList = new ArrayList<>();
    }

    public void move(Direction direction) {
        if (isMovable(point)) {
            point = direction.Calculator(point);

            moveCount++;
        }
    }

    public Point point() {
        return this.point;
    }

    public int moveCount() {
        return this.moveCount;
    }

    private boolean isMovable(Point currentPoint) {
        return !stage.isEdge(currentPoint);
    }

    private boolean isVisitedRoute() {
        return false;
    }


}


class Solution {
    public int solution(String dirs) {
        Stage stage = new Stage();
        Robot robot = new Robot(stage);
        for (int i = 0; i < dirs.length(); i++) {
            String directionStr = String.valueOf(dirs.charAt(i));
            robot.move(Direction.valueOf(directionStr));
        }
        return robot.moveCount();
    }
}

public class P73415 {

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        int result = new Solution().solution(dirs);
        System.out.println(result);
    }
}
