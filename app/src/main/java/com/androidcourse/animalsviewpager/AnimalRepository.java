package com.androidcourse.animalsviewpager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalRepository {

	public List<Animal> getAnimals() {
		return new ArrayList<>(
				Arrays.asList(
						new Animal(R.drawable.frog, "Frog"),
						new Animal(R.drawable.monkey, "Monkey"),
						new Animal(R.drawable.giraffe, "Giraffe")
				)
		);
	}

}
