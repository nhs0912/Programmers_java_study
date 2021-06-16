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

    public Point start() {
        return this.start;
    }

    public Point end() {
        return this.end;
    }

    public boolean isSameRoute(Point inputStart, Point inputEnd) {
        return isSameRoute(new Route(inputStart, inputEnd));
    }

    public boolean isSameRoute(Route route) {//서로 바뀌어서 x,y를 비교하는 로직 구현하면 됨
        return (isSame(start, route.start) && isSame(end, route.end)) || (isSame(start, route.end) && isSame(end, route.start));
    }

    private boolean isSame(Point alpha, Point beta) {
        return (alpha.x() == beta.x() && alpha.y() == beta.y());
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


    public boolean outofRange(Point point) {
        int absX = ABS(point.x());
        int absY = ABS(point.y());
        return absX > EDGE_VALUE || absY > EDGE_VALUE;
    }

    private int ABS(int value) {
        return (value >= 0) ? value : value * -1;
    }
}

class Robot {
    private Point currentPoint;
    private Stage stage;
    private int moveCount;
    private List<Route> visitList;

    public Robot(Stage stage) {
        this(stage, new Point(0, 0));
    }

    public Robot(Stage stage, Point currentPoint) {
        this.stage = stage;
        this.currentPoint = currentPoint;
        visitList = new ArrayList<>();
    }

    public void move(Direction direction) {
        Point start = currentPoint;
        Point end = direction.Calculator(start);
        Route route = new Route(start, end);
        if (isMovable(route)) {
            currentPoint = end;
            addRoute(route);
        }
    }

    private void addRoute(Route route) {
        if (!checkDuplicateRoute(route)) {
            visitList.add(route);
            moveCount++;
        }
    }

    public Point point() {
        return this.currentPoint;
    }

    public int moveCount() {
        return this.moveCount;
    }

    private boolean isMovable(Route route) {
        return !stage.outofRange(route.end());
    }

    private boolean checkDuplicateRoute(Route inputRoute) {
        for (Route route : this.visitList) {
            if (inputRoute.isSameRoute(route)) {
                return true;
            }
        }
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
        String dirs = "LULLLLLLU";
        int result = new Solution().solution(dirs);
        System.out.println(result);
    }
}
