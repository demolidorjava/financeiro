package br.com.javaparaweb.capitulo12.JFreeChart;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class CidadeColunasBean {
	private StreamedContent grafico;
	private static final Logger log = Logger.getLogger(CidadeColunasBean.class.getName());

public CidadeColunasBean() {
	try {
		JFreeChart graficoColunas = ChartFactory.createBarChart("Cinco cidades mais populosas de Santa Catarina", "cidades", "popula��o", this.geraDados(), PlotOrientation.VERTICAL,false, true, false);
		File arquivoGrafico = new File("colunas.png");
		ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoColunas, 500, 325);	
		this.grafico = new DefaultStreamedContent(new FileInputStream(arquivoGrafico), "image/png");
	}catch(Exception e) {
		log.severe(e.getMessage());
	}
}

	private DefaultCategoryDataset geraDados() {
		DefaultCategoryDataset dts = new DefaultCategoryDataset();
		dts.setValue(new Double(334002.0), "Popula��o", "Blumenau");
		dts.setValue(new Double(204667.0), "Popula��o", "Crici�ma");
		dts.setValue(new Double(461524.0), "Popula��o", "Florian�polis");
		dts.setValue(new Double(554601.0), "Popula��o", "Joinville");
		dts.setValue(new Double(228561.0), "Popula��o", "S�o Jos�");
		
		return dts;
	}
	
	public StreamedContent getGrafico() {
		return this.grafico;
	}
}
