package com.ilp04.service;

import java.time.LocalDate;
import java.util.ArrayList;
import com.ilp04.entity.SafetyIncident;


public interface SafetyIncidentService {


	public ArrayList<SafetyIncident> getAllSafetyIncident();
	public void insertIntoSafetyIncident(SafetyIncident safetyincident);
	public void updateSafetyIncident(SafetyIncident safetyincident);
	public ArrayList<SafetyIncident> getSafetyIncident(LocalDate incidentDate);
}
