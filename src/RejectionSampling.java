
public class RejectionSampling {
	public void doRejectionSampling(int iterations, String queryVariable, String conditions){
		/*For a given input "sample humidity=low 50000 day=weekday snow=true"
		 * the queryVariable would be "humidity=low"
		 * and the conditions would be "day=weekday" and "snow= true"
		 * I wasn't sure how the input string is parsed, but this is the general idea
		 * of how I though of doing the rejection sampling algorithm
		 */
		int numValidSamples = 0;
		int count = 0;
		
		//run rejection sampling # of iterations times
		for(int i = 0; i < iterations; i++){
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
			
			//check if we are going to reject or accept this Simulation
			if(reject()){
				//we are rejecting this sample
			}
			else{
				//we are accepting this sample
				numValidSamples++;
				if(this sample matches our queryVariable){
					count++;
				}
			}
		}
	}
	
	public boolean reject(){
		return false;
	}
}
