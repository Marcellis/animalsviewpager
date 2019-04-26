package com.androidcourse.animalsviewpager.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.androidcourse.animalsviewpager.Animal;

import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class AnimalsPagerAdapter extends FragmentPagerAdapter {

	private List<Animal> animals;

	public AnimalsPagerAdapter(FragmentManager fm, List<Animal> animals) {
		super(fm);
		this.animals = animals;
	}

	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a AnimalFragment
		return AnimalFragment.newInstance(animals.get(position));
	}

	@Override
	public int getCount() {
		return animals.size();
	}
}