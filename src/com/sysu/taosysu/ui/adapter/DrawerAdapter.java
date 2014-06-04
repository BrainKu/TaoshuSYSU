package com.sysu.taosysu.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sysu.taosysu.R;
import com.sysu.taosysu.model.DrawerItem;

public class DrawerAdapter extends BaseAdapter {

	private static final int LIST_HEADER = 1;
	private static final int LIST_NORMAL = 2;

	Context mContext;
	List<DrawerItem> mDrawerList = new ArrayList<DrawerItem>();
	ImageView drawerIcon;
	TextView drawerText;

	TextView username;
	TextView createTime;

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
		return mDrawerList.size() + 1;
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
		LayoutInflater inflater = LayoutInflater.from(mContext);

		if (getItemViewType(position) == LIST_HEADER) {
			if (convertView == null)
				convertView = inflater.inflate(R.layout.drawer_header, parent,
						false);
			username = (TextView) convertView.findViewById(R.id.user_name);
			createTime = (TextView) convertView
					.findViewById(R.id.user_join_time);
			username.setText("����ζ");
			createTime.setText("2014.1.1");
		}
		if (getItemViewType(position) == LIST_NORMAL) {
			if (convertView == null)
				convertView = inflater.inflate(R.layout.listitem_drawer,
						parent, false);

			drawerText = (TextView) convertView.findViewById(R.id.drawer_text);
			drawerIcon = (ImageView) convertView.findViewById(R.id.drawer_icon);

			drawerText.setText(mDrawerList.get(position - 1).getTitle());
			drawerIcon
					.setImageResource(mDrawerList.get(position - 1).getIcon());

		}

		return convertView;
	}

	@Override
	public int getItemViewType(int position) {
		if (position == 0)
			return LIST_HEADER;
		else
			return LIST_NORMAL;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

}
