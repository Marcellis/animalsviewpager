package com.androidcourse.animalsviewpager.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.androidcourse.animalsviewpager.Animal;

public class AnimalViewModel extends ViewModel {

	private MutableLiveData<Animal> animal = new MutableLiveData<>();

	public void setAnimal(Animal animal) {
		this.animal.setValue(animal);
	}

	public MutableLiveData<Animal> getAnimal() {
		return animal;
	}
}