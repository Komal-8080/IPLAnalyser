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
	public void givenDataShouldReturnCricketerWithMaximum6sAnd4sForMostRuns() {
		try {
			IPLAnalyser iPLAnalyser = new IPLAnalyser();
			iPLAnalyser.loadIPL2019FactsheetMostRuns(IPL2019_FACTSHEET_MOSTRUNSCSVPATH);
			String sortedIPLData = iPLAnalyser.getPlayersWithMaximum6and4();
			IPL2019FactsheetMostRunsCSV[] iplMostRuns = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostRunsCSV[].class);
			Assert.assertEquals("Andre Russell", iplMostRuns[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenDataShouldReturnCricketerWithBestStrikeingRateAndMaximum6sAnd4sForMostRuns() {
		try {
			IPLAnalyser iPLAnalyser = new IPLAnalyser();
			iPLAnalyser.loadIPL2019FactsheetMostRuns(IPL2019_FACTSHEET_MOSTRUNSCSVPATH);
			String sortedIPLData = iPLAnalyser.getPlayersWithBestStrikeingRateAndMaximum6and4();
			IPL2019FactsheetMostRunsCSV[] iplMostRuns = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostRunsCSV[].class);
			Assert.assertEquals("Andre Russell", iplMostRuns[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenDataShouldReturnCricketerWithHighestAvgeragesAndBestStrickingRates() {
		try {
			IPLAnalyser iPLAnalyser = new IPLAnalyser();
			iPLAnalyser.loadIPL2019FactsheetMostRuns(IPL2019_FACTSHEET_MOSTRUNSCSVPATH);
			String sortedIPLData = iPLAnalyser.getCricketerWithHighestAvgeragesAndBestStrickingRate();
			IPL2019FactsheetMostRunsCSV[] iplMostRuns = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostRunsCSV[].class);
			Assert.assertEquals("MS Dhoni", iplMostRuns[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenDataShouldReturnCricketerWithHighestAvgeragesAndMaximumRuns() {
		try {
			IPLAnalyser iPLAnalyser = new IPLAnalyser();
			iPLAnalyser.loadIPL2019FactsheetMostRuns(IPL2019_FACTSHEET_MOSTRUNSCSVPATH);
			String sortedIPLData = iPLAnalyser.getCricketerWithHighestAvgeragesAndMaximumRuns();
			IPL2019FactsheetMostRunsCSV[] iplMostRuns = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostRunsCSV[].class);
			System.out.println(iplMostRuns[0].player);
			Assert.assertEquals("David Warner", iplMostRuns[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenDataShouldReturnTopBowlingAverageForMostWkts() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPL2019FactsheetMostWkts(IPL2019_FACTSHEET_MOSTWKTSCSVPATH);
			String sortedIPLData = iplAnalyser.getTopBowlingAverages();
			IPL2019FactsheetMostWktsCSV[] wktsCSVList = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostWktsCSV[].class);
			System.out.println(wktsCSVList[0].player);
			Assert.assertEquals("Krishnappa Gowtham", wktsCSVList[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenDataShouldReturnBowlerWithTopStrinkingRate() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPL2019FactsheetMostWkts(IPL2019_FACTSHEET_MOSTWKTSCSVPATH);
			String sortedIPLData = iplAnalyser.getBowlersWithTopStrikeingRate();
			IPL2019FactsheetMostWktsCSV[] wktsCSVList = new Gson().fromJson(sortedIPLData,
					IPL2019FactsheetMostWktsCSV[].class);
			System.out.println(wktsCSVList[0].player);
			Assert.assertEquals("Krishnappa Gowtham", wktsCSVList[0].player);
		} catch (IPLAnalysisException e) {
			e.printStackTrace();
		}
	}

}
