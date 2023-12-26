package TeoriaFP.fase02.trabajo01;
/* 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;

public class TimeChart {
    public static void generateTimeChart(long[] insertionTimes, long[] quicksortTimes) {
        // Crear una serie para los tiempos de inserción
        XYSeries insertionSeries = new XYSeries("Insercion");

        // Agregar puntos de datos a la serie de inserción
        for (int i = 0; i < insertionTimes.length; i++) {
            insertionSeries.add(i, insertionTimes[i]);
        }

        // Crear una serie para los tiempos de quicksort
        XYSeries quicksortSeries = new XYSeries("Quicksort");

        // Agregar puntos de datos a la serie de quicksort
        for (int i = 0; i < quicksortTimes.length; i++) {
            quicksortSeries.add(i, quicksortTimes[i]);
        }

        // Crear un conjunto de datos que contenga ambas series
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(insertionSeries);
        dataset.addSeries(quicksortSeries);

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Tiempo de Ejecucion de Algoritmos de Ordenamiento",
                "Ejecucion", "Tiempo (nanosegundos)", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        // Personalizar el gráfico si es necesario
        XYPlot plot = chart.getXYPlot();
        StandardXYItemRenderer renderer = new StandardXYItemRenderer();
        plot.setRenderer(renderer);

        // Guardar el gráfico como una imagen
        try {
            File imageFile = new File("chart.png");
            ChartUtilities.saveChartAsPNG(imageFile, chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/