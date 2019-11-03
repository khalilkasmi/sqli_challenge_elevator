package com.sqlichallenge.entities;

import com.sqlichallenge.states.ElevatorState;
import com.sqlichallenge.states.ElevatorStateDown;
import com.sqlichallenge.states.ElevatorStateRest;
import com.sqlichallenge.states.ElevatorStateStop;
import com.sqlichallenge.states.ElevatorStateUp;


public class Elevator {
	
	private String id;
	private int floor;
	private ElevatorState state;
	private int numberOfFloors;
	
	public Elevator(int numberOfFLoors ,String elevatorIdAndFloor) {
		super();
		String[] elevatorData = elevatorIdAndFloor.split(":");
		this.id = elevatorData[0];
		this.floor = Integer.valueOf(elevatorData[1]);
		this.state = ElevatorStateRest.getInstance();
		this.numberOfFloors = numberOfFLoors;
	}

	public void move(String direction){
		switch (direction) {
		case "UP":
			state = ElevatorStateUp.getInstance();
			state.move(this);
			break;
			
		case "DOWN":
			this.state = ElevatorStateDown.getInstance();
			state.move(this);
			break;
		default:
			break;
		}
	}
	
	public void stopAt(int floor){
		//this.state = ElevatorStateStop.getInstance();
		state = ElevatorStateStop.getInstance();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public ElevatorState getState() {
		return state;
	}

	public void setState(ElevatorState state) {
		this.state = state;
	}

	
	
	
	
	
	
}
