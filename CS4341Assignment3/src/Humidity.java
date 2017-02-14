
public class Humidity {
	
	double low = 0.2;
	double medium = 0.5;
	double high = 0.3;
	boolean isLow = false;
	boolean isMedium = false;
	boolean isHigh = false;
	
	public Humidity(){
		
	}
	
	public double getLow(){
		return low;
	}
	
	public double getMedium(){
		return medium;
	}
	
	public double getHigh(){
		
		return high;
	}
	
	public void setIsLow(boolean val){
		isLow = val;
		if(val){
			setIsMedium(false);
			setIsHigh(false);
		}
	}
	
	public void setIsMedium(boolean val){
		isMedium = val;
		if(val){
			setIsLow(false);
			setIsHigh(false);
		}
	}
	
	public void setIsHigh(boolean val){
		isHigh = val;
		if(val){
			setIsLow(false);
			setIsMedium(false);
		}
	}
	
	public boolean getIsLow(){
		return isLow;
	}
	
	public boolean getIsMedium(){
		return isMedium;
	}
	
	public boolean getIsHigh(){
		return isHigh;
	}
	
	public void determinehumidity(){
		double rand = Math.random()*100+1;
		if(rand<=20){
			setIsLow(true);
		}
		else if(rand>20&&rand<=70){
			setIsMedium(true);
		}
		else if (rand>70&&rand<=100){
			setIsHigh(true);
		}
	}
}
