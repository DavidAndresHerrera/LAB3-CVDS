package edu.eci.cvds.tdd.registry;

import java.util.*;

public class Registry {
	private ArrayList<Integer> registrados;
    
	public Registry(){
		registrados = new ArrayList<Integer>();
	}
	
	public RegisterResult registerVoter(Person p) {	
		if(!p.isAlive()){
			return RegisterResult.DEAD;
		}
		else if(p.getAge()<1 || p.getAge()>150){
			return RegisterResult.INVALID_AGE;
		}
		else if(p.getAge()<18){
			return RegisterResult.UNDERAGE; 	
		}
		else if(duplicated(p.getId())){
			return RegisterResult.DUPLICATED;
		}
		else{
			registrados.add(p.getId());
			return RegisterResult.VALID;
		}
    }
	
	private boolean duplicated(int p){
		if(registrados.indexOf(p)<0) 
			return false;
		return true;
	}
	
}