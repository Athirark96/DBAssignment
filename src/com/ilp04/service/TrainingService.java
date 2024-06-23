package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.Training;

public interface TrainingService {

	public ArrayList<Training> getTrainingDetails(); 
	public void insertIntoTraining(Training training);
	public void updateIntoTraining(Training training);


	
}
