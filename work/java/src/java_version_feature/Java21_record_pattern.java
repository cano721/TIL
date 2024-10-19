package java_version_feature;

public class Java21_record_pattern {
    public static void main(String[] args) {
        Point p = new Point(10, 20);

        // 패턴 매칭을 통한 레코드 분해
        if (p instanceof Point(int x, int y)) {
            System.out.println("x: " + x + ", y: " + y);
        }

        switch (p) {
            case Point(int x, int y) -> System.out.println("Point with x: " + x + ", y: " + y);
            default -> System.out.println("Unknown");
        }

        if (p instanceof Point(int x, int y) && x > 5 && y < 25) {
            System.out.println("x is greater than 5 and y is less than 25");
        } else {
            System.out.println("Point does not match the criteria");
        }

        // 중첩된 레코드 생성
        Line line = new Line(new Point(0, 0), new Point(10, 20));

        // 중첩된 레코드에 대한 패턴 매칭
        if (line instanceof Line(Point(int x1, int y1), Point(int x2, int y2))) {
            System.out.println("Start point: (" + x1 + ", " + y1 + ")");
            System.out.println("End point: (" + x2 + ", " + y2 + ")");
        }

    }

    public record Point(int x, int y) {}

    // 레코드 중첩 정의
    public record Line(Point start, Point end) {}
}
