
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

	/**
	 * @return the isWarm
	 */
	public boolean isWarm() {
		return isWarm;
	}

	/**
	 * @param isWarm the isWarm to set
	 */
	public void setWarm(boolean isWarm) {
		this.isWarm = isWarm;
		if(isWarm){
			this.isCold = false;
			this.isWarm = false;
		}
	}

	/**
	 * @return the isMild
	 */
	public boolean isMild() {
		return isMild;
	}

	/**
	 * @param isMild the isMild to set
	 */
	public void setMild(boolean isMild) {
		this.isMild = isMild;
		if(isMild){
			this.isCold = false;
			this.isWarm = false;
		}
	}

	/**
	 * @return the isCold
	 */
	public boolean isCold() {
		return isCold;
	}

	/**
	 * @param isCold the isCold to set
	 */
	public void setCold(boolean isCold) {
		this.isCold = isCold;
		if(isCold){
			this.isMild = false;
			this.isWarm = false;
		}
	}
	
	/**
	 * determines the temperature based on the probabilities 
	 */
	public void determineTemp(){
		double randNum = Math.random() * 100;
		if(randNum <= 10){
			this.setWarm(true);
		}
		else if(randNum > 10 && randNum <= 50){
			this.setMild(true);
		}
		else{
			this.setCold(true);
		}
	}
}
