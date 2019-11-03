package com.sqlichallenge.states;

import com.sqlichallenge.entities.Elevator;

public class ElevatorStateDown extends ElevatorState {
	
	private static ElevatorStateDown _instance;
	
	public static ElevatorStateDown getInstance(){
		if (_instance == null) _instance = new ElevatorStateDown();
		return _instance;
	}

	@Override
	public void move(Elevator elevator) {	
		if(elevator.getState() == ElevatorStateDown.getInstance()){
			elevator.setFloor(1);
		}else{
			elevator.setFloor(10);
			elevator.setState(ElevatorStateDown.getInstance());
			elevator.setFloor(1);
		}
		elevator.setState(ElevatorStateStop.getInstance());
	}

	@Override
	public void stop(Elevator elevator,int floor) {		
	}

	@Override
	public void rest(Elevator elevator, int floor) {
		// TODO Auto-generated method stub
		
	}

}
