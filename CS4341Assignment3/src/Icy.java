public class Icy {
  Humidity humidity;
  Temperature temp;
  boolean isIcy;
  
  public double getProbability(){
  double probability=-1;
    if(humidity.isLow&&temp.isWarm()){
      probability = 0.001;
    }
    else if(humidity.isLow&&temp.isMild()){
      probability = 0.01;
    }
    else if(humidity.isLow&&temp.isCold()){
      probability = 0.05;
    }
    else if(humidity.isMedium&&temp.isWarm()){
      probability = 0.001;
    }
    else if(humidity.isMedium&&temp.isMild()){
      probability = 0.03;
    }
    else if(humidity.isMedium&&temp.isCold()){
      probability = 0.2;
    }
    else if(humidity.isHigh&&temp.isWarm()){
      probability = 0.005;
    }
    else if(humidity.isHigh&&temp.isMild()){
      probability = 0.01;
    }
    else if(humidity.isHigh&&temp.isCold()){
      probability=0.35;
    }
    return probability;
  }
  
  public boolean getIsIcy(){
    return isIcy;
  }
  
  public void setIsIcy(){
    double rand = Math.random()*100+1;
    if(rand<this.getProbability()){
      isIcy=false;
    }
    if(rand>=this.getProbability()){
      isIcy=true;
    }
  }
  
  
}
