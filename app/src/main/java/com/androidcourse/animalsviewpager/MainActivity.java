package com.androidcourse.animalsviewpager;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.androidcourse.animalsviewpager.ui.main.AnimalsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private MainActivityViewModel viewModel;
	private List<Animal> animals = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final AnimalsPagerAdapter animalsPagerAdapter = new AnimalsPagerAdapter(getSupportFragmentManager(), animals);
		final ViewPager viewPager = findViewById(R.id.view_pager);
		viewPager.setAdapter(animalsPagerAdapter);

		viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
		viewModel.getAnimals().observe(this, new Observer<List<Animal>>() {
			@Override
			public void onChanged(@Nullable List<Animal> animals) {
				MainActivity.this.animals.clear();
				MainActivity.this.animals.addAll(animals);
				animalsPagerAdapter.notifyDataSetChanged();
			}
		});
	}
}