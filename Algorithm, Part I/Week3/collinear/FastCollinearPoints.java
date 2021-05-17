import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FastCollinearPoints {

    final private ArrayList<LineSegment> lineSegments;

    final private ArrayList<ArrayList<Point>> checkExistSegment;

    public FastCollinearPoints(Point[] points) {

        if (checkNull(points) || checkSamePoint(points)) {
            throw new IllegalArgumentException();
        }

        lineSegments = new ArrayList<>();

        checkExistSegment = new ArrayList<>();

        int lenPoints = points.length;

        Point[] pointCopy = Arrays.copyOf(points, lenPoints);

        Arrays.sort(pointCopy);

        for (int i = 0; i < lenPoints; i++) {
            Point[] tempPoints = Arrays.copyOf(pointCopy, lenPoints);
            Point root = pointCopy[i];
            Arrays.sort(tempPoints, root.slopeOrder());

            ArrayList<Point> listPointInSegment = new ArrayList<>();
            double prevSlope = Double.NEGATIVE_INFINITY;
            for (int j = 1; j < lenPoints; j++) {
                double currSlope = root.slopeTo(tempPoints[j]);
                if (prevSlope == currSlope) {
                    listPointInSegment.add(tempPoints[j]);
                } else {
                    if (listPointInSegment.size() > 2) {
                        addSegment(listPointInSegment, root);
                    }
                    listPointInSegment.clear();
                    listPointInSegment.add(tempPoints[j]);
                }
                prevSlope = currSlope;
            }
            if (listPointInSegment.size() > 2) {
                addSegment(listPointInSegment, root);
            }
        }
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[numberOfSegments()]);
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
                if (point[i].equals(point[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private void addSegment(ArrayList<Point> listPointInSegment, Point root) {
        listPointInSegment.add(root);
        Collections.sort(listPointInSegment);

        Point startPoint = listPointInSegment.get(0);
        Point endPoint = listPointInSegment.get(listPointInSegment.size() - 1);

        for (ArrayList<Point> pairPoint : checkExistSegment) {
            if ((pairPoint.get(0).compareTo(startPoint) == 0) && (pairPoint.get(1).compareTo(endPoint) == 0)) {
                return;
            }
        }
        ArrayList<Point> pairPoint = new ArrayList<>();
        pairPoint.add(startPoint);
        pairPoint.add(endPoint);

        checkExistSegment.add(pairPoint);

        lineSegments.add(new LineSegment(startPoint, endPoint));
    }

    public static void main(String[] args) {
        // read the n points from a file
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
