// Test Cases
// java-introcs BarChartRacer cities.txt 10
// java-introcs BarChartRacer brands.txt 15
// java-introcs BarChartRacer movies.txt 10
// java-introcs BarChartRacer endgame.txt 10

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        In dataFile = new In(args[0]);
        int k = Integer.parseInt(args[1]);

        String chartTitle = dataFile.readLine();
        String xAxisLabel = dataFile.readLine();
        String dataSource = dataFile.readLine();

        BarChart chart1 = new BarChart(chartTitle, xAxisLabel, dataSource);
        Bar[] barList = null;
        int recordsPerGroup = 0;
        String caption = "";

        while (dataFile.hasNextLine()) {
            String currentLine = dataFile.readLine();               // ignore the blank line
            recordsPerGroup = Integer.parseInt(dataFile.readLine());
            barList = new Bar[recordsPerGroup];
            // iterate through all records within the same group
            for (int i = 0; i < recordsPerGroup; i++) {
                currentLine = dataFile.readLine();
                String[] dataItems = currentLine.split(",");
                if (i == 0) {
                    caption = dataItems[0];
                    chart1.setCaption(caption);
                }
                String name = dataItems[1];
                int value = Integer.parseInt(dataItems[3]);
                String category = dataItems[4];
                Bar bar1 = new Bar(name, value, category);
                barList[i] = bar1;
            }

            Arrays.sort(barList);
            // add the first k bars to the bar chart1 in descending order
            for (int i = 0; i < k; i++) {
                Bar bar = barList[recordsPerGroup-1-i];
                chart1.add(bar.getName(), bar.getValue(), bar.getCategory());
            }
            // draw the bars, pause, and reset
            StdDraw.clear();
            chart1.draw();
            StdDraw.show();
            StdDraw.pause(10);
            chart1.reset();
            barList = null;
        }
    }
}
