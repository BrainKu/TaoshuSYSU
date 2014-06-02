package com.sysu.taosysu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.sysu.taosysu.ui.fragment.LaunchFragment;

public class LoginActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_launch);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.launch_container, new LaunchFragment()).commit();
	} 

}
