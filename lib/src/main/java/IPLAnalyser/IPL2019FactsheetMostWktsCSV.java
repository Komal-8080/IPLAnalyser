package IPLAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IPL2019FactsheetMostWktsCSV {

	@CsvBindByName(column = "POS")
	public int position;

	@CsvBindByName(column = "PLAYER")
	public String player;

	@CsvBindByName(column = "Mat")
	public int matches;

	@CsvBindByName(column = "Inns")
	public int innings;

	@CsvBindByName(column = "Ov")
	public double overs;

	@CsvBindByName(column = "Runs")
	public int runs;

	@CsvBindByName(column = "Wkts")
	public int wickets;

	@CsvBindByName(column = "BBI")
	public int bbi;

	@CsvBindByName(column = "Avg")
	public double avg;

	@CsvBindByName(column = "Econ")
	public double economy;

	@CsvBindByName(column = "SR")
	public double strikeRate;

	@CsvBindByName(column = "4w")
	public int fourWicket;

	@CsvBindByName(column = "5w")
	public int fiveWicket;

	@Override
	public String toString() {
		return "IPL2019FactsheetMostWktsCSV [position=" + position + ", player=" + player + ", matches=" + matches
				+ ", innings=" + innings + ", overs=" + overs + ", runs=" + runs + ", wickets=" + wickets + ", bbi="
				+ bbi + ", avg=" + avg + ", economy=" + economy + ", strikeRate=" + strikeRate + ", fourWicket="
				+ fourWicket + ", fiveWicket=" + fiveWicket + "]";
	}

}
