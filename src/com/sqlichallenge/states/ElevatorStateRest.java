package com.sqlichallenge.states;

import com.sqlichallenge.entities.Elevator;

public class ElevatorStateRest extends ElevatorState {

	private static ElevatorStateRest _instance;
	
	public static ElevatorStateRest getInstance(){
		if (_instance == null) _instance = new ElevatorStateRest();
		return _instance;
	}
	
	@Override
	public void move(Elevator elevator) {
		
	}

	@Override
	public void stop(Elevator elevator, int floor) {
	}

	@Override
	public void rest(Elevator elevator, int floor) {
		// TODO Auto-generated method stub
		
	}

}
