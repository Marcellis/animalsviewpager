package com.androidcourse.animalsviewpager;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

	private MutableLiveData<List<Animal>> animals = new MutableLiveData<>();
	private AnimalRepository animalRepository = new AnimalRepository();

	public MainActivityViewModel() {
		animals.setValue(animalRepository.getAnimals());
	}

	public MutableLiveData<List<Animal>> getAnimals() {
		return animals;
	}
}
