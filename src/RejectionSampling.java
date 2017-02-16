import java.util.ArrayList;

public class RejectionSampling {
	/**
	 * Runs rejection sampling with given parameters. We assume that conditionIndexes and
	 * conditionValues are the same size.
	 * @param iterations
	 * @param queryVariableIndex
	 * @param queryVariableValue
	 * @param conditionIndexes
	 * @param conditionValues
	 */
	public static void doRejectionSampling(int iterations, int queryVariableIndex, int queryVariableValue, 
											ArrayList<Integer> conditionIndexes, ArrayList<Integer> conditionValues){
		/*For a given input "sample humidity=low 50000 day=weekday snow=true"
		 * the queryVariable would be "humidity=low"
		 * and the conditions would be "day=weekday" and "snow= true"
		 * I wasn't sure how the input string is parsed, but this is the general idea
		 * of how I though of doing the rejection sampling algorithm
		 */
		int numValidSamples = 0;
		int count = 0;
		
		//array that will hold values for each node on each iteration
		NodeValues nodeValues = new NodeValues();
		
		//run rejection sampling # of iterations times
		for(int i = 0; i < iterations; i++){
			//initialize array
			nodeValues = new NodeValues();
			
			//Simulate first level(Humidity, Temperature, Day)
			Humidity humiditySimulation = new Humidity();
			humiditySimulation.determinehumidity();
			Temperature temperatureSimulation = new Temperature();
			temperatureSimulation.determineTemp();
			Day daySimulation = new Day();
			daySimulation.determineDay();
			
			//Simulate second level(Icy and Snow)
			Icy icySimulation = new Icy(humiditySimulation, temperatureSimulation);
			icySimulation.determineIcy();
			Snow snowSimulation = new Snow(humiditySimulation, temperatureSimulation);
			snowSimulation.determineSnow();
			
			//Simulate third level(Cloudy and Exams)
			Cloudy cloudySimulation = new Cloudy(snowSimulation);
			cloudySimulation.determineCloudy();
			Exams examsSimulation = new Exams(snowSimulation, daySimulation);
			examsSimulation.determineExams();
			
			//Simulate fourth level(Stress)
			Stress stressSimulation = new Stress(snowSimulation, examsSimulation);
			stressSimulation.determineStressed();
			
			//add all node values to array
			nodeValues.setCloudy(cloudySimulation);
			nodeValues.setDay(daySimulation);
			nodeValues.setExams(examsSimulation);
			nodeValues.setHumidity(humiditySimulation);
			nodeValues.setIcy(icySimulation);
			nodeValues.setSnow(snowSimulation);
			nodeValues.setStress(stressSimulation);
			nodeValues.setTemperature(temperatureSimulation);
			
			//check if we are going to reject or accept this Simulation
			if(reject(nodeValues, conditionIndexes, conditionValues)){
				//we are rejecting this sample
			}
			else{
				//we are accepting this sample
				numValidSamples++;
				if(nodeValues.getValueAt(queryVariableIndex) == queryVariableValue){
					//keep track of number of times query variable value is met
					count++;
				}
			}
		}
		
		//print out stats
		System.out.println("Total Number of Samples: " + iterations);
		System.out.println("Total Number of Non-rejected Samples: " + numValidSamples);
		double probability = ((double) count)/numValidSamples;
		System.out.println("Estimated Probability of Query Node: " + probability);
		//calculating standard deviation and confidence interval
		double mean = 0;
		double standardDev = calcStandardDeviation(nodeValues);
		System.out.println("Standard Deviation: +/-" + standardDev);
		double highBound = mean + 2.0*standardDev/Math.sqrt(numValidSamples);
		double lowBound = mean - 2.0*standardDev/Math.sqrt(numValidSamples);
		System.out.println("95% Confidence Interval: (" + lowBound + ", " + highBound + ")");
		
	}
	
	/**
	 * calculates standard deviation of the values of all the nodes
	 * @param nodeValues
	 * @return
	 */
	public static double calcStandardDeviation(NodeValues nodeValues){
		double standardDev = 0.0;
		
		 
		
		return standardDev;
	}
	
	/**
	 * check if the conditions are met, if not we will reject this sample
	 * @param nodeValues
	 * @param conditionIndexes
	 * @param conditionValues
	 * @return
	 */
	public static boolean reject(NodeValues nodeValues, ArrayList<Integer> conditionIndexes, ArrayList<Integer> conditionValues){
		boolean reject = false;
		
		for(int i = 0; i < conditionIndexes.size(); i++){
			if(nodeValues.getValueAt(conditionIndexes.get(i)) != conditionValues.get(i)){
				reject = true;
			}
		}
		
		return reject;
	}
}
