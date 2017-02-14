
public class Exams {
	private Snow snow;
	private Day day;
	private boolean isExam;
	
	public Exams(){}
	
	public double getProbability(){
		double prob = 0;
		
		if(!snow.isSnow()){
			if(day.isWeekend)
				prob = 0.001;
			else //is weekday
				prob = 0.1;
		}
		else{//is snowing
			if(day.isWeekend)
				prob = 0.0001;
			else //is weekday
				prob = 0.3;
		}
		
		return prob;
	}
	
	public void setExams(){
		double randNum = Math.random();
		if(randNum < this.getProbability())
			isExam = true;
		else
			isExam = false;
	}
}
