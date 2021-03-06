
public class Snow {
	private Humidity humidity;
	private Temperature temperature;
	public boolean isSnow;
	
	public Snow(Humidity h, Temperature t){
		this.humidity = h;
		this.temperature = t;
	}
	
	public double getProbability(){
		double prob = 0.0;
		
		if(humidity.getIsLow()){
			if(temperature.isWarm())
				prob = 0.0001;
			else if(temperature.isMild())
				prob = 0.001;
			else //temp is cold
				prob = 0.1;
		}
		else if(humidity.getIsMedium()){
			if(temperature.isWarm())
				prob = 0.0001;
			else if(temperature.isMild())
				prob = 0.0001;
			else //temp is cold
				prob = 0.25;
		}
		else{//humidity is high
			if(temperature.isWarm())
				prob = 0.0001;
			else if(temperature.isMild())
				prob = 0.001;
			else //temp is cold
				prob = 0.4;
		}
		
		return prob;
	}

	/**
	 * @return the isSnow
	 */
	public boolean isSnow() {
		return isSnow;
	}

	/**
	 * @param isSnow the isSnow to set
	 */
	public void determineSnow() {
		Double randNum = Math.random();
		if(randNum < this.getProbability())
			this.isSnow = true;
		else
			this.isSnow = false;
	}
	
	
}
