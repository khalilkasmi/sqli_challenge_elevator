package com.sqlichallenge.dispatcher;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sqlichallenge.entities.Elevator;
import com.sqlichallenge.states.ElevatorState;
import com.sqlichallenge.states.ElevatorStateDown;
import com.sqlichallenge.states.ElevatorStateRest;
import com.sqlichallenge.states.ElevatorStateUp;

public class ElevatorDispatcher {

	private static ElevatorDispatcher _instance; 
	
	
	public static ElevatorDispatcher getInstance() {
		if(_instance == null) _instance = new ElevatorDispatcher();
		return _instance;
	}


	/*public Elevator getClosestElevator(Set<Elevator> elevators) {
		Elevator elevatorWithMaxFloor = null;
		Iterator<Elevator> iterator = elevators.iterator();
		while (iterator.hasNext()) {
			elevatorWithMaxFloor = compareFloors(iterator.next(),iterator.next());
		}
		return elevatorWithMaxFloor;
	}
	

	
	public Elevator compareFloors(Elevator e1,Elevator e2){
		if (e1.getFloor() > e2.getFloor())
			return e1;
		else 
			return e2;
	}*/


	public String requestElevator(Set<Elevator> elevators, int numberOfFloors2) {
		int numberOfFloors = numberOfFloors2;
		HashMap<Integer,Elevator> elevatorsDistances = new HashMap<Integer,Elevator>();
		int distance = 0 ;
		for (Elevator elevator : elevators) {
			if(elevator.getState() instanceof ElevatorStateUp){
				distance = numberOfFloors - elevator.getFloor();
				elevatorsDistances.put(distance,elevator);
			}else if(elevator.getState() instanceof ElevatorStateDown){
				distance = numberOfFloors + elevator.getFloor();
				elevatorsDistances.put(distance,elevator);
			}else if(elevator.getState() instanceof ElevatorStateRest){
				distance = numberOfFloors - elevator.getFloor();
				elevatorsDistances.put(distance,elevator);
			}
		}
		int distanceMin = Collections.min(elevatorsDistances.keySet());
		return elevatorsDistances.get(distanceMin).getId();
	}
	
	public String requestElevator(Set<Elevator> elevators, int numberOfFloors2,int floor) {
		int numberOfFloors = numberOfFloors2;
		HashMap<Integer,Elevator> elevatorsDistances = new HashMap<Integer,Elevator>();
		int distance = 0 ;
		for (Elevator elevator : elevators) {
			if(elevator.getState() instanceof ElevatorStateUp){
				if(floor > elevator.getFloor()){
					distance = floor - elevator.getFloor();
					elevatorsDistances.put(distance,elevator);
				}else{
					distance = (numberOfFloors - elevator.getFloor()) + (numberOfFloors - floor);
					elevatorsDistances.put(distance,elevator);
				}
			}else if(elevator.getState() instanceof ElevatorStateDown){
				if(floor > elevator.getFloor()){
					distance = floor + elevator.getFloor();
					elevatorsDistances.put(distance,elevator);
				}else{
					distance =  elevator.getFloor() - floor;
					elevatorsDistances.put(distance,elevator);
				}
			}else if(elevator.getState() instanceof ElevatorStateRest){
				distance = Math.abs(floor - elevator.getFloor());
				elevatorsDistances.put(distance,elevator);
			}
		}
		int distanceMin = Collections.min(elevatorsDistances.keySet());
		return elevatorsDistances.get(distanceMin).getId();
	}

}
