package IPLAnalyser;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

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

	@Test
	public void givenDataShouldReturnTopBattingAverageForMostRuns() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPL2019FactsheetMostRuns(IPL2019_FACTSHEET_MOSTRUNSCSVPATH);
			String sortedIPLData = iplAnalyser.getTopBatsmenAverages();
			IPL2019FactsheetMostRunsCSV[] iplMostRuns = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostRunsCSV[].class);
			Assert.assertEquals("MS Dhoni", iplMostRuns[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenDataShouldReturnBatsmanWithTopStrickingRateForMostRuns() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPL2019FactsheetMostRuns(IPL2019_FACTSHEET_MOSTRUNSCSVPATH);
			String sortedIPLData = iplAnalyser.getBatsmenWithTopStrickingRate();
			IPL2019FactsheetMostRunsCSV[] iplMostRuns = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostRunsCSV[].class);
			Assert.assertEquals("Ishant Sharma", iplMostRuns[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenDataShouldReturnBestStrinckingRateWith6sAnd4sForMostRuns() {
		try {
			IPLAnalyser iPLAnalyser = new IPLAnalyser();
			iPLAnalyser.loadIPL2019FactsheetMostRuns(IPL2019_FACTSHEET_MOSTRUNSCSVPATH);
			String sortedIPLData = iPLAnalyser.getPlayersWithBestStrinkingRateWithTop6and4();
			IPL2019FactsheetMostRunsCSV[] iplMostRuns = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostRunsCSV[].class);
			Assert.assertEquals("Andre Russell", iplMostRuns[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

}
