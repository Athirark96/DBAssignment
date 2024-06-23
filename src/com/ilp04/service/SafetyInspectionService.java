package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.SafetyInspection;


public interface SafetyInspectionService {
	
	public ArrayList<SafetyInspection> getAllSafetyInspection();;
	public void insertIntoSafetyInspection(SafetyInspection inspection);
	public void updateIntoSafetyInspection(SafetyInspection inspection);
//	public ArrayList<SafetyIncident> getAllSafetyIncident();
//	public void insertIntoSafetyIncident(SafetyIncident safetyincident);
//	public void updateSafetyIncident(SafetyIncident safetyincident);
}
