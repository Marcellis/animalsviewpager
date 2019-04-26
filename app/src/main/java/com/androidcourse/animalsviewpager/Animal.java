package com.androidcourse.animalsviewpager;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;

public class Animal implements Parcelable {

	@DrawableRes
	private int imageRes;

	private String species;

	public Animal(int imageRes, String species) {
		this.imageRes = imageRes;
		this.species = species;
	}

	protected Animal(Parcel in) {
		imageRes = in.readInt();
		species = in.readString();
	}

	public int getImageRes() {
		return imageRes;
	}

	public void setImageRes(int imageRes) {
		this.imageRes = imageRes;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public static final Creator<Animal> CREATOR = new Creator<Animal>() {
		@Override
		public Animal createFromParcel(Parcel in) {
			return new Animal(in);
		}

		@Override
		public Animal[] newArray(int size) {
			return new Animal[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(imageRes);
		dest.writeValue(species);
	}
}
