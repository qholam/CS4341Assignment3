
public class Temperature {
	private final double warmProb = 0.1;
	private final double mildProb = 0.4;
	private final double coldProb = 0.5;
	private boolean isWarm = false;
	private boolean isMild = false;
	private boolean isCold = false;
	
	public Temperature(){
	}

	/**
	 * @return the warmProb
	 */
	public double getWarmProb() {
		return warmProb;
	}
	/**
	 * @return the mildProb
	 */
	public double getMildProb() {
		return mildProb;
	}

	/**
	 * @return the coldProb
	 */
	public double getColdProb() {
		return coldProb;
	}
}
