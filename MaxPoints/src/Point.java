/**
 * Created by xuyuanp on 5/27/14.
 */
public class Point {
    int x, y;
    Point() {
        x = 0;
        y = 0;
    }

    @Override
    public boolean equals(Object o) {
        Point point = (Point)o;
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode() {
        return (x * 100000) + y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
