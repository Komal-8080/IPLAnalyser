package IPLAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IPL2019FactsheetMostWktsCSV {

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getInnings() {
		return innings;
	}

	public void setInnings(int innings) {
		this.innings = innings;
	}

	public double getOvers() {
		return overs;
	}

	public void setOvers(double overs) {
		this.overs = overs;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getBbi() {
		return bbi;
	}

	public void setBbi(int bbi) {
		this.bbi = bbi;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getEconomy() {
		return economy;
	}

	public void setEconomy(double economy) {
		this.economy = economy;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public int getFourWicket() {
		return fourWicket;
	}

	public void setFourWicket(int fourWicket) {
		this.fourWicket = fourWicket;
	}

	public int getFiveWicket() {
		return fiveWicket;
	}

	public void setFiveWicket(int fiveWicket) {
		this.fiveWicket = fiveWicket;
	}

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
