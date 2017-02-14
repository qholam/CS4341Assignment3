public class Stress{
  Snow snow;
  Exams exam;
  boolean isStressed;
  public Stress(){
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
  
  public void setIsStressed(){
    double rand = Math.random()*100+1;
    if(rand<this.getProbability()){
      isStressed=false;
    }
    else{
      isStressed=true;
    }
  }
}