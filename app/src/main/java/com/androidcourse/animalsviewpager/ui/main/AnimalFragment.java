package com.androidcourse.animalsviewpager.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.androidcourse.animalsviewpager.Animal;
import com.androidcourse.animalsviewpager.R;

/**
 * A fragment containing an amial view.
 */
public class AnimalFragment extends Fragment {

	private static final String ARG_ANIMAL = "ARG_ANIMAL";

	private AnimalViewModel animalViewModel;

	public static AnimalFragment newInstance(Animal animal) {
		AnimalFragment fragment = new AnimalFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelable(ARG_ANIMAL, animal);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		animalViewModel = ViewModelProviders.of(this).get(AnimalViewModel.class);

		if (getArguments() != null) {
			animalViewModel.setAnimal((Animal) getArguments().getParcelable(ARG_ANIMAL));
		}
	}

	@Override
	public View onCreateView(
			@NonNull LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_main, container, false);

		final TextView tvSpecies = root.findViewById(R.id.tvSpecies);
		final ImageView ivAnimal = root.findViewById(R.id.ivAnimal);

		animalViewModel.getAnimal().observe(this, new Observer<Animal>() {
			@Override
			public void onChanged(@Nullable Animal animal) {
				tvSpecies.setText(animal.getSpecies());
				ivAnimal.setImageResource(animal.getImageRes());
			}
		});
		return root;
	}
}