/**
 * This class will hold the values for all the nodes on a given sample
 * @author Tommy's PC
 *
 */
public class NodeValues {
	public final static int array_size = 8;
	/*Index of each node in the array*/
	final static int humidityIndex = 0;
	final static int temperatureIndex = 1;
	final static int icyIndex = 2;
	final static int snowIndex = 3;
	final static int dayIndex = 4;
	final static int cloudyIndex = 5;
	final static int examsIndex = 6;
	final static int stressIndex = 7;
	
	/*possible values for humidity*/
	final static int lowHumidity = 0;
	final static int mediumHumidity = 1;
	final static int highHumidity = 2;
	/*possible values for temperature*/
	final static int warmTemperature = 0;
	final static int mildTemperature = 1;
	final static int coldTemperature = 2;
	/*possible values for icy*/
	final static int isIcy = 0;
	final static int notIcy = 1;
	/*possible values for snow*/
	final static int isSnowy = 0;
	final static int notSnowy = 1;
	/*possible values for day*/
	final static int weekend = 0;
	final static int weekday = 1;
	/*possible values for cloudy*/
	final static int isCloudy = 0;
	final static int notCloudy = 1;
	/*possible values for exams*/
	final static int isExams = 0;
	final static int notExams = 1;
	/*possible values for stress*/
	final static int highStress = 0;
	final static int lowStress = 1;
	
	/*array that hold the values of all the nodes for a given sample*/
	final int[] nodeValues;
	
	public NodeValues(){
		nodeValues = new int[array_size]; 
	}
	
	/*get node value at specified index*/
	public int getValueAt(int index){
		return nodeValues[index];
	}
	
	/*setter methods for each node*/
	public void setHumidity(Humidity h){
		if(h.getIsHigh()){
			nodeValues[humidityIndex] = highHumidity;
		}
		else if(h.getIsMedium()){
			nodeValues[humidityIndex] = mediumHumidity;
		}
		else{
			nodeValues[humidityIndex] = lowHumidity;
		}
	}
	public void setTemperature(Temperature t){
		if(t.isCold()){
			nodeValues[temperatureIndex] = coldTemperature;
		}
		else if(t.isWarm()){
			nodeValues[temperatureIndex] = warmTemperature;
		}
		else{
			nodeValues[temperatureIndex] = mildTemperature;
		}
	}
	public void setIcy(Icy i){
		if(i.getIsIcy()){
			nodeValues[icyIndex] = isIcy;
		}
		else{
			nodeValues[icyIndex] = notIcy;
		}
	}
	public void setSnow(Snow s){
		if(s.isSnow()){
			nodeValues[snowIndex] = isSnowy;
		}
		else{
			nodeValues[snowIndex] = notSnowy;
		}
	}
	public void setDay(Day d){
		if(d.isWeekday){
			nodeValues[dayIndex] = weekday;
		}
		else{
			nodeValues[dayIndex] = weekend;
		}
	}
	public void setCloudy(Cloudy c){
		if(c.isCloudy()){
			nodeValues[cloudyIndex] = isCloudy;
		}
		else{
			nodeValues[cloudyIndex] = notCloudy;
		}
	}
	public void setExams(Exams e){
		if(e.isExam){
			nodeValues[examsIndex] = isExams;
		}
		else{
			nodeValues[examsIndex] = notExams;
		}
	}
	public void setStress(Stress s){
		if(s.getIsStressed()){
			nodeValues[stressIndex] = highStress;
		}
		else{
			nodeValues[stressIndex] = lowStress;
		}
	}
	
}
