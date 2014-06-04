package com.sysu.taosysu.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sysu.taosysu.MainActivity;
import com.sysu.taosysu.R;

public class LoginFragment extends Fragment {

	Button login;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_login, container, false);

		login = (Button) view.findViewById(R.id.login);
		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				getActivity().startActivity(
						new Intent(getActivity(), MainActivity.class));
				getActivity().finish();
			}
		});
		return view;
	}

}
