import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RunSample {

	private static String requestType;
	private static String requestCondition;
	private static String examcond;
	private static String humiditycond;
	private static String snowcond;
	private static String icycond;
	private static String tempcond;
	private static String daycond;
	private static String stresscond;
	private static String cloudycond;
	private static int iteracond;
	private static String[] input;
	private static String[] type;
	
	private static int queryVariableIndex;
	private static int queryVariableValue; 
	private static ArrayList<Integer> conditionIndexes;
	private static ArrayList<Integer> conditionValues;

	public static void main(String[] args) 
	{
		conditionIndexes = new ArrayList<Integer> ();
		conditionValues = new ArrayList<Integer> ();
		System.out.println("sample");
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine().split(" ");
		int i = 0;
		for(String s: input)
		{
			type = s.split("=");
			for(String str: type)
			{
				if(i == 0)
				{
					requestType = str;
					queryVariableIndex = getNodeIndex(str);
				}
				else if(i == 1)
				{
					requestCondition = str;
					queryVariableValue = getNodeValue(queryVariableIndex, str);
				}else if(i == 2)
				{
					iteracond = Integer.parseInt(str); 
				} else
				{
					if(str.toLowerCase().equals("humidity"))
					{
						humiditycond = type[1];
						int nodeIndex = getNodeIndex(str.toLowerCase());
						int nodeValue = getNodeValue(nodeIndex, humiditycond);
						conditionIndexes.add(nodeIndex);
						conditionValues.add(nodeValue);
					} 
					else if(str.toLowerCase().equals("day"))
					{
						daycond = type[1];
						int nodeIndex = getNodeIndex(str.toLowerCase());
						int nodeValue = getNodeValue(nodeIndex, daycond);
						conditionIndexes.add(nodeIndex);
						conditionValues.add(nodeValue);
					}
					else if(str.toLowerCase().equals("snow"))
					{
						snowcond = type[1];
						int nodeIndex = getNodeIndex(str.toLowerCase());
						int nodeValue = getNodeValue(nodeIndex, snowcond);
						conditionIndexes.add(nodeIndex);
						conditionValues.add(nodeValue);
					}
					else if(str.toLowerCase().equals("temperature"))
					{
						tempcond = type[1];
						int nodeIndex = getNodeIndex(str.toLowerCase());
						int nodeValue = getNodeValue(nodeIndex, tempcond);
						conditionIndexes.add(nodeIndex);
						conditionValues.add(nodeValue);
					}
					else if(str.toLowerCase().equals("exam"))
					{
						examcond = type[1];
						int nodeIndex = getNodeIndex(str.toLowerCase());
						int nodeValue = getNodeValue(nodeIndex, examcond);
						conditionIndexes.add(nodeIndex);
						conditionValues.add(nodeValue);
					}
					else if(str.toLowerCase().equals("cloudy"))
					{
						cloudycond = type[1];
						int nodeIndex = getNodeIndex(str.toLowerCase());
						int nodeValue = getNodeValue(nodeIndex, cloudycond);
						conditionIndexes.add(nodeIndex);
						conditionValues.add(nodeValue);
					}
					else if(str.toLowerCase().equals("stress")){
						stresscond = type[1];
						int nodeIndex = getNodeIndex(str.toLowerCase());
						int nodeValue = getNodeValue(nodeIndex, stresscond);
						conditionIndexes.add(nodeIndex);
						conditionValues.add(nodeValue);
					}
					else if(str.toLowerCase().equals("icy")){
						icycond = type[1];
						int nodeIndex = getNodeIndex(str.toLowerCase());
						int nodeValue = getNodeValue(nodeIndex, icycond);
						conditionIndexes.add(nodeIndex);
						conditionValues.add(nodeValue);
					}
				}
				i++;
			}
		}
		
		//run rejection sampling
		RejectionSampling.doRejectionSampling(iteracond, queryVariableIndex, queryVariableValue, conditionIndexes, conditionValues);
	}
	
	public static int getNodeValue(int index, String value){
		int val = -1;
		value = value.toLowerCase();
		
		switch(index) {
		case NodeValues.humidityIndex:
			if (value.equals("low")){
				val = NodeValues.lowHumidity;
			}
			else if (value.equals("medium")){
				val = NodeValues.mediumHumidity;
			}
			else{
				val = NodeValues.highHumidity;
			}
			break;
		case NodeValues.temperatureIndex:
			if (value.equals("warm")){
				val = NodeValues.warmTemperature;
			}
			else if (value.equals("mild"))
				val = NodeValues.mildTemperature;
			else
				val = NodeValues.coldTemperature;
			break;
		case NodeValues.cloudyIndex:
			if(value.equals("true"))
				val = NodeValues.isCloudy;
			else
				val = NodeValues.notCloudy;
			break;
		case NodeValues.icyIndex:
			if(value.equals("true"))
				val = NodeValues.isIcy;
			else
				val = NodeValues.notIcy;
			break;
		case NodeValues.snowIndex:
			if(value.equals("true"))
				val = NodeValues.isSnowy;
			else
				val = NodeValues.notSnowy;
			break;
		case NodeValues.examsIndex:
			if(value.equals("true"))
				val = NodeValues.isExams;
			else
				val = NodeValues.notExams;
			break;
		case NodeValues.stressIndex:
			if(value.equals("high"))
				val = NodeValues.highStress;
			else
				val = NodeValues.lowStress;
			break;
		case NodeValues.dayIndex:
			if(value.equals("weekday"))
				val = NodeValues.weekday;
			else
				val = NodeValues.weekend;
			break;
		}
		
		return val;
	}
	
	public static int getNodeIndex(String s){
		int index = -1;
		
		switch(s.toLowerCase()){
		case "humidity":
			index = NodeValues.humidityIndex;
			break;
		case "temperature":
			index = NodeValues.temperatureIndex;
			break;
		case "icy":
			index = NodeValues.icyIndex;
			break;
		case "snow":
			index = NodeValues.snowIndex;
			break;
		case "day":
			index = NodeValues.dayIndex;
			break;
		case "cloudy":
			index = NodeValues.cloudyIndex;
			break;
		case "exam":
			index = NodeValues.examsIndex;
			break;
		case "stress":
			index = NodeValues.stressIndex;
			break;
		default:
			break;
		}
		
		return index;
	}
} 
