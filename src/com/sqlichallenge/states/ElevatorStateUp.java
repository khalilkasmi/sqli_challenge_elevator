package com.sqlichallenge.states;

import com.sqlichallenge.entities.Elevator;

public class ElevatorStateUp extends ElevatorState {

	private static ElevatorStateUp _instance;
	
	public static ElevatorStateUp getInstance(){
		if (_instance == null) _instance = new ElevatorStateUp();
		return _instance;
	}
	

	@Override
	public void move(Elevator elevator) {
		if(elevator.getFloor() != elevator.getNumberOfFloors()){
			if(elevator.getState() == ElevatorStateDown.getInstance()){
				elevator.setFloor(1);
			}
		}
	}


	@Override
	public void stop(Elevator elevator, int floor) {
		elevator.setFloor(elevator.getNumberOfFloors());
	}


	@Override
	public void rest(Elevator elevator, int floor) {
		elevator.setFloor(floor);
	}
	
}
