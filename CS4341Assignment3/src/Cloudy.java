
public class Cloudy {
	private Snow snow;
	private boolean isCloudy;
	
	public Cloudy(Snow s){
		this.snow = s;
	}
	
	public double getProbability(){
		double prob = 0;
		
		if(snow.isSnow())
			prob = 0.9;
		else
			prob = 0.3;
		
		return prob;
	}
	
	public boolean isCloudy(){
		return this.isCloudy;
	}
	
	public void determineCloudy(){
		double randNum = Math.random();
		if(randNum < this.getProbability()){
			isCloudy = true;
		}
		else{
			isCloudy = false;
		}
	}
}
