package com.sysu.taosysu.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.sysu.taosysu.R;
import com.sysu.taosysu.model.DrawerItem;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {

	Context mContext;
	List<DrawerItem> mDrawerList = new ArrayList<DrawerItem>();
	ImageView icon;
	TextView text;
	String[] navMenuTitles;
	TypedArray navMenuIcons;

	public DrawerAdapter(Context context) {
		mContext = context;
		initDrawerItem();
	}

	private void initDrawerItem() {
		navMenuTitles = mContext.getResources().getStringArray(
				R.array.nav_drawer_items);
		navMenuIcons = mContext.getResources().obtainTypedArray(
				R.array.nav_drawer_icons);

		int length = navMenuTitles.length;
		for (int i = 0; i < length; i++) {
			mDrawerList.add(new DrawerItem(navMenuIcons.getResourceId(i, -1),
					navMenuTitles[i]));
		}
		navMenuIcons.recycle();
	}

	@Override
	public int getCount() {
		return mDrawerList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDrawerList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.listitem_drawer, null);
		}
		text = (TextView) convertView.findViewById(R.id.drawer_text);
		icon = (ImageView) convertView.findViewById(R.id.drawer_icon);

		text.setText(mDrawerList.get(position).getTitle());
		icon.setImageResource(mDrawerList.get(position).getIcon());

		return convertView;
	}

}
