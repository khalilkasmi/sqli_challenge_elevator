package com.sqlichallenge.states;

import com.sqlichallenge.entities.Elevator;

public abstract class ElevatorState {

	public abstract void move(Elevator elevator);
	public abstract void stop(Elevator elevator, int floor);
	public abstract void rest(Elevator elevator, int floor);
	
}
