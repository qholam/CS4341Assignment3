public class Stress{
  Snow snow;
  Exams exam;
  boolean isStressed;
  public Stress(Snow s, Exams e){
	  this.snow = s;
	  this.exam = e;
  }
  public double getProbability(){
    double probability=-1;
    if((!snow.isSnow)&&(!exam.isExam)){
      probability = 0.01;
    }
    else if((!snow.isSnow)&&exam.isExam){
      probability=0.02;
    }
    else if(snow.isSnow&&(!exam.isExam)){
      probability = 0.1;
    }
    else if(snow.isSnow&&exam.isExam){
      probability=0.5;
    }
    return probability;
  }
  
  public boolean getIsStressed(){
    return isStressed;
  }
  
  public void determineStressed(){
    double rand = Math.random();
    if(rand<this.getProbability()){
      isStressed=true;
    }
    else{
      isStressed=false;
    }
  }
}
