package com.sqlichallenge.entities;

import java.util.HashSet;
import java.util.Set;

import com.sqlichallenge.dispatcher.ElevatorDispatcher;
import com.sqlichallenge.states.ElevatorStateStop;

public class Building {

	private int numberOfFloors;
	private Set<Elevator> elevators;
	private ElevatorDispatcher dispatcher;
	
	public Building(int numberOfFloors,String ...elevatorsIdAndFloor ) {
		super();
		this.numberOfFloors = numberOfFloors;
		elevators = new HashSet<Elevator>();
		for (String string : elevatorsIdAndFloor) {
			elevators.add(new Elevator(numberOfFloors,string));
		}
		dispatcher = ElevatorDispatcher.getInstance();
	}

	public void move(String id, String direction){
		for (Elevator elevator : elevators) {
			if (elevator.getId().equals(id)){
				elevator.move(direction);
			}
		}
	}
	
	public void stopAt(String id, int floor){
		for (Elevator elevator : elevators) {
			if (elevator.getId().equals(id)){
				//elevator.setState(ElevatorStateStop.getInstance());
				elevator.stopAt(floor);
			}
		}
	}
	
	public String requestElevator(){
		return this.dispatcher.requestElevator(this.elevators,numberOfFloors);
	}
	
	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public Set<Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(Set<Elevator> elevators) {
		this.elevators = elevators;
	}

	public ElevatorDispatcher getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(ElevatorDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public String requestElevator(int floor) {
		// TODO Auto-generated method stub
		return this.dispatcher.requestElevator(elevators,this.numberOfFloors,floor);
	}
	
	
	
	
}
