
public class Day {
	double weekend = 0.2;
	double weekday = 0.8;
	boolean isWeekend = false;
	boolean isWeekday = false;
	public Day(){
	
	}
	public double getWeekend(){
		return weekend;
	}
	public double getWeekday(){
		return weekday;
	}
	public void setIsWeekend(boolean val1){
		isWeekend=val1;
	}
	public void setIsWeekday(boolean val2){
		isWeekday = val2;
	}
	public determineDay(){
		int rand = Math.random()%100;
		if(rand<=20){
			setIsWeekend(true);
			setIsWeekday(false);
		}
		else{
			setIsWeekend(false);
			setIsWeekday(true);
		}
	}
}
