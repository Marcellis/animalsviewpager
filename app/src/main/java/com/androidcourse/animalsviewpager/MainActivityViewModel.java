package com.androidcourse.animalsviewpager;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

	private MutableLiveData<List<Animal>> animals = new MutableLiveData<>();

	public MainActivityViewModel() {
		animals.setValue(new ArrayList<>(
				Arrays.asList(
						new Animal(R.drawable.frog, "Frog"),
						new Animal(R.drawable.monkey, "Monkey"),
						new Animal(R.drawable.giraffe, "Giraffe")
				)
		));
	}

	public MutableLiveData<List<Animal>> getAnimals() {
		return animals;
	}
}
