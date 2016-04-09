package com.befit.tabsswipe.adapter;

import com.project.befit.MainPage;
import com.project.befit.ResultSelect;
import com.project.befit.Guide;
import com.project.befit.Food;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new MainPage();
		case 1:
			// Games fragment activity
			return new ResultSelect();
		case 2:
			// Movies fragment activity
			return new Food();
		case 3:
			// Movies fragment activity
			return new Guide();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 4;
	}

}