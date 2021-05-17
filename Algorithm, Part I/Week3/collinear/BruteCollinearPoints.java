
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    final private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points) {

        if (checkNull(points) || checkSamePoint(points)) {
            throw new IllegalArgumentException();
        }

        int lenPoints = points.length;

        ArrayList<LineSegment> segments = new ArrayList<>();

        Point[] pointCopy = Arrays.copyOf(points, lenPoints);

        Arrays.sort(pointCopy);

        for (int p = 0; p < lenPoints - 3; p++) {
            for (int q = p + 1; q < lenPoints - 2; q++) {
                for (int r = q + 1; r < lenPoints - 1; r++) {
                    if (pointCopy[p].slopeTo(pointCopy[q]) != pointCopy[p].slopeTo(pointCopy[r])) {
                        continue;
                    }

                    for (int s = r + 1; s < lenPoints; s++) {
                        if (pointCopy[p].slopeTo(pointCopy[q]) == pointCopy[p].slopeTo(pointCopy[s])) {
                            segments.add(new LineSegment(pointCopy[p], pointCopy[s]));
                        }
                    }
                }
            }
        }
        lineSegments = segments.toArray(new LineSegment[segments.size()]);
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(lineSegments, numberOfSegments());
    }

    private boolean checkNull(Point[] point) {
        if (point == null) {
            return true;
        }
        for (int i = 0; i < point.length; i++) {
            if (point[i] == null) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSamePoint(Point[] point) {
        for (int i = 0; i < point.length - 1; i++) {
            for (int j = i + 1; j < point.length; j++) {
                if (point[i].compareTo(point[j]) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
