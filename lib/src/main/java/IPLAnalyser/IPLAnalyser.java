package IPLAnalyser;


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
            throw new IPLAnalysisException(e.getMessage(),
            		IPLAnalysisException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new IPLAnalysisException(e.getMessage(),
            		IPLAnalysisException.ExceptionType.FILE_OR_HEADER_PROBLEM);
        }
    }

	public int loadIPL2019FactsheetMostWkts(String csvFilePath) throws IPLAnalysisException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
        	wktsCSVList = CSVBuilderFactory.createCSVBuilder().getCSVFList(reader, IPL2019FactsheetMostWktsCSV.class);
            return wktsCSVList.size();

        } catch (IOException | CSVBuilderException e) {
            throw new IPLAnalysisException(e.getMessage(),
            		IPLAnalysisException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new IPLAnalysisException(e.getMessage(),
            		IPLAnalysisException.ExceptionType.FILE_OR_HEADER_PROBLEM);
        }
	}


}
