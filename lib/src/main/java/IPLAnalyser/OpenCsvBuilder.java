package IPLAnalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCsvBuilder<E> implements ICSVBuilder {

	public <E> Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
		return this.getCSVtoBean(reader, csvClass).iterator();

	}

	public <E> List<E> getCSVFList(Reader reader, Class csvClass) throws CSVBuilderException {
		return this.getCSVtoBean(reader, csvClass).parse();
	}

	public CsvToBean<E> getCSVtoBean(Reader reader, Class<E> csvClass) throws CSVBuilderException {
		try {
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(csvClass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<E> csvToBean = csvToBeanBuilder.build();
			return csvToBean;

		} catch (IllegalStateException e) {
			throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
		} catch (RuntimeException e) {
			throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM);
		}

	}
}
