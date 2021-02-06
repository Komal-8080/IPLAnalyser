package IPLAnalyser;

import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyserTest {

	private static final String IPL2019_FACTSHEET_MOSTRUNSCSVPATH = "C:\\Users\\Gayatri\\eclipse-workspace\\IPLAnalysis\\lib\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv";
	private static final String IPL2019_FACTSHEET_MOSTWKTSCSVPATH = "C:\\Users\\Gayatri\\eclipse-workspace\\IPLAnalyser\\lib\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv";

	// To check Most Runs File Records
	@Test
	public void givenIPL2019FactSheetMostRunsCSVFileReturnsCorrectRecords() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			int numOfRecords = iplAnalyser.loadIPL2019FactsheetMostRuns(IPL2019_FACTSHEET_MOSTRUNSCSVPATH);
			Assert.assertEquals(101, numOfRecords);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIPL2019FactSheetMostWktsCSVFileReturnsCorrectRecords() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			int numOfRecords = iplAnalyser.loadIPL2019FactsheetMostWkts(IPL2019_FACTSHEET_MOSTWKTSCSVPATH);
			Assert.assertEquals(99, numOfRecords);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

}
