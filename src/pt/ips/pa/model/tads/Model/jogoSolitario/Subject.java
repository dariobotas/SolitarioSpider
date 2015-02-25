package pt.ips.pa.model.tads.Model.jogoSolitario;

import Interface.InterfaceObserver;
import java.util.ArrayList;

/**
 * 
 * @author dario
 */
public class Subject{

private ArrayList<InterfaceObserver> observers;
private boolean changeState;

public Subject(){
this.observers = new ArrayList<>();
changeState = false;
}

public void add(InterfaceObserver ob){
this.observers.add(ob);
}

public void remove(InterfaceObserver ob){
this.observers.remove(ob);
}

public void notifyObservers(){
if(isChangeState()){
for(InterfaceObserver obs : this.observers){
obs.update(this);
}
changeState = false;
}
}

public boolean isChangeState(){
return changeState;
}

public void setChangeState(boolean changeState){
this.changeState = changeState;
}

}