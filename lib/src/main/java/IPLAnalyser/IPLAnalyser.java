package IPLAnalyser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

public class IPLAnalyser {

	List<IPL2019FactsheetMostRunsCSV> runsCSVList = null;
	List<IPL2019FactsheetMostWktsCSV> wktsCSVList = null;

	public int loadIPL2019FactsheetMostRuns(String csvFilePath) throws IPLAnalysisException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			runsCSVList = CSVBuilderFactory.createCSVBuilder().getCSVFList(reader, IPL2019FactsheetMostRunsCSV.class);
			return runsCSVList.size();

		} catch (IOException | CSVBuilderException e) {
			throw new IPLAnalysisException(e.getMessage(), IPLAnalysisException.ExceptionType.IPL_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new IPLAnalysisException(e.getMessage(), IPLAnalysisException.ExceptionType.FILE_OR_HEADER_PROBLEM);
		}
	}

	public int loadIPL2019FactsheetMostWkts(String csvFilePath) throws IPLAnalysisException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			wktsCSVList = CSVBuilderFactory.createCSVBuilder().getCSVFList(reader, IPL2019FactsheetMostWktsCSV.class);
			return wktsCSVList.size();

		} catch (IOException | CSVBuilderException e) {
			throw new IPLAnalysisException(e.getMessage(), IPLAnalysisException.ExceptionType.IPL_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new IPLAnalysisException(e.getMessage(), IPLAnalysisException.ExceptionType.FILE_OR_HEADER_PROBLEM);
		}
	}

	public String getTopBatsmenAverages() throws IPLAnalysisException {
		try (Writer writer = new FileWriter("./src/test/resources/IPLTopBattingAverages.json")) {
			if (runsCSVList == null || runsCSVList.size() == 0) {
				throw new IPLAnalysisException("No data", IPLAnalysisException.ExceptionType.NO_DATA);
			}
			Comparator<IPL2019FactsheetMostRunsCSV> iplComparator = Comparator.comparing(census -> census.avg);
			this.descendingSort(iplComparator);
			String json = new Gson().toJson(runsCSVList);
			Gson gson = new GsonBuilder().create();
			gson.toJson(runsCSVList, writer);
			return json;

		} catch (RuntimeException | IOException e) {
			throw new IPLAnalysisException(e.getMessage(), IPLAnalysisException.ExceptionType.FILE_OR_HEADER_PROBLEM);
		}
	}

	public String getBatsmenWithTopStrickingRate() throws IPLAnalysisException {
		try (Writer writer = new FileWriter("./src/test/resources/IPLBatsmanWithTopSR.json")) {
			if (runsCSVList == null || runsCSVList.size() == 0) {
				throw new IPLAnalysisException("No data", IPLAnalysisException.ExceptionType.NO_DATA);
			}
			Comparator<IPL2019FactsheetMostRunsCSV> iplComparator = Comparator.comparing(census -> census.strikeRate);
			this.descendingSort(iplComparator);
			String json = new Gson().toJson(runsCSVList);
			Gson gson = new GsonBuilder().create();
			gson.toJson(runsCSVList, writer);
			return json;

		} catch (RuntimeException | IOException e) {
			throw new IPLAnalysisException(e.getMessage(), IPLAnalysisException.ExceptionType.FILE_OR_HEADER_PROBLEM);
		}
	}

	private void descendingSort(Comparator<IPL2019FactsheetMostRunsCSV> iplComparator) {
		for (int i = 0; i < runsCSVList.size() - 1; i++) {
			for (int j = 0; j < runsCSVList.size() - i - 1; j++) {
				IPL2019FactsheetMostRunsCSV ipl1 = runsCSVList.get(j);
				IPL2019FactsheetMostRunsCSV ipl2 = runsCSVList.get(j + 1);
				if (iplComparator.compare(ipl1, ipl2) < 0) {
					runsCSVList.set(j, ipl2);
					runsCSVList.set(j + 1, ipl1);
				}
			}
		}
	}

}
