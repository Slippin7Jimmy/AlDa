package aufgabenblatt02;

public class StockTick {

	private double kurs;

	public StockTick() {
		// TODO Auto-generated constructor stub
	}

	public double getKurs() {
		return kurs;
	}

	public void setKurs(double letztKurs, float kursDiff) {
		this.kurs = letztKurs + kursDiff;
		if (kurs < 0) {
			this.kurs = 0;
		}

	}

}
