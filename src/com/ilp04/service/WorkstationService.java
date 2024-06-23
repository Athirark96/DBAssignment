package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.entity.Workstation;


public interface WorkstationService {

	public ArrayList<Workstation> getAllWorkstation();
	public void updateWorkstation(Workstation workstation);
	public void insertIntoCustomer(Workstation workstation);

}

