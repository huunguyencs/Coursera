
import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {

    private static Bar[] parseAndSort(BarChart chart, String[] lines) {
        Bar[] bars = new Bar[lines.length];
        String year = "";
        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(",");
            bars[i] = new Bar(split[1], Integer.parseInt(split[3]), split[4]);
            year = split[0];
        }
        chart.setCaption(year);
        Arrays.sort(bars);
        Collections.reverse(Arrays.asList(bars));
        return bars;
    }

    private static void drawFrame(BarChart chart, String[] lines, int num) {
        Bar[] bars = parseAndSort(chart, lines);
        for (int i = 0; i < num; i++) {
            chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
        }

    }

    public static void main(String[] args) {
        String file = args[0];
        int k = Integer.parseInt(args[1]);
        In sc = new In(file);

        // Read info chart
        String title = sc.readLine();
        String xAxis = sc.readLine();
        String source = sc.readLine();
        sc.readLine();

        // Set up chart
        BarChart chart = new BarChart(title, xAxis, source);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        // Read file loop
        do {
            int n = Integer.parseInt(sc.readLine());
            String[] lines = new String[n];
            for (int i = 0; i < n; i++) {
                lines[i] = sc.readLine();
            }
            sc.readLine();

            // draw a frame
            drawFrame(chart, lines, k);
            chart.draw();
            StdDraw.show();
            StdDraw.pause(200);

            // Reset frame
            StdDraw.clear();
            chart.reset();
        } while (sc.hasNextLine());

    }
}
