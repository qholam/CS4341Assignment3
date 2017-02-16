/**
 * This class will hold the values for all the nodes on a given sample
 * @author Tommy's PC
 *
 */
public class NodeValues {
	final int array_size = 8;
	/*Index of each node in the array*/
	final int humidityIndex = 0;
	final int temperatureIndex = 1;
	final int icyIndex = 2;
	final int snowIndex = 3;
	final int dayIndex = 4;
	final int cloudyIndex = 5;
	final int examsIndex = 6;
	final int stressIndex = 7;
	
	/*possible values for humidity*/
	final int lowHumidity = 0;
	final int mediumHumidity = 1;
	final int highHumidity = 2;
	/*possible values for temperature*/
	final int warmTemperature = 0;
	final int mildTemperature = 1;
	final int coldTemperature = 2;
	/*possible values for icy*/
	final int isIcy = 0;
	final int notIcy = 1;
	/*possible values for snow*/
	final int isSnowy = 0;
	final int notSnowy = 1;
	/*possible values for day*/
	final int weekend = 0;
	final int weekday = 1;
	/*possible values for cloudy*/
	final int isCloudy = 0;
	final int notCloudy = 1;
	/*possible values for exams*/
	final int isExams = 0;
	final int notExams = 1;
	/*possible values for stress*/
	final int highStress = 0;
	final int lowStress = 1;
	
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
