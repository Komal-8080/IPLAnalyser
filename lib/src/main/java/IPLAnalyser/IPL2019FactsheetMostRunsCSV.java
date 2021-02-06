package IPLAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IPL2019FactsheetMostRunsCSV {

	@CsvBindByName(column = "POS")
	public int position;

	@CsvBindByName(column = "PLAYER")
	public String player;

	@CsvBindByName(column = "Mat")
	public int matches;

	@CsvBindByName(column = "Inns")
	public int innings;

	@CsvBindByName(column = "NO")
	public int notOuts;

	@CsvBindByName(column = "Runs")
	public int runs;

	@CsvBindByName(column = "HS")
	public String highest;

	@CsvBindByName(column = "Avg")
	public double avg;

	@CsvBindByName(column = "BF")
	public int bf;

	@CsvBindByName(column = "SR")
	public double strikeRate;

	@CsvBindByName(column = "100")
	public int hundreds;

	@CsvBindByName(column = "50")
	public int fifties;

	@CsvBindByName(column = "4s")
	public int fours;

	@CsvBindByName(column = "6s")
	public int sixes;

	@Override
	public String toString() {
		return "IPL2019FactsheetMostRunsCSV {" + "position=" + position + ", player='" + player + '\'' + ", matches=" + matches
				+ ", innings=" + innings + ", notOuts=" + notOuts + ", runs=" + runs + ", highest='" + highest + '\''
				+ ", avg=" + avg + ", bf=" + bf + ", strikeRate=" + strikeRate + ", hundreds=" + hundreds + ", fifties="
				+ fifties + ", fours=" + fours + ", sixes=" + sixes + '}';
	}
}
