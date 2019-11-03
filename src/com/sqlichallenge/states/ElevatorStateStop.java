package com.sqlichallenge.states;

import com.sqlichallenge.entities.Elevator;

public class ElevatorStateStop extends ElevatorState{

	private static ElevatorStateStop _instance;
	
	
	
	public ElevatorStateStop() {}
	
	public static ElevatorStateStop getInstance(){
		if(_instance == null) _instance = new ElevatorStateStop();
		return _instance;
	}

	@Override
	public void move(Elevator elevator) {	
	}

	@Override
	public void stop(Elevator elevator,int floor) {
		elevator.setFloor(floor);
		elevator.setState(this);
	}

	@Override
	public void rest(Elevator elevator, int floor) {
		// TODO Auto-generated method stub
		
	}	

}
