package br.com.cast.turmaformacao.agenda.controllers.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.agenda.R;
import br.com.cast.turmaformacao.agenda.model.entities.Social;

public class SocialListAdapter extends BaseAdapter {

	private List<Social> socials;
	private Activity context;

	public SocialListAdapter(List<Social> $Socials, Activity $Context) {
		socials = $Socials;
		context = $Context;
	}

	@Override
	public int getCount() {
		return socials.size();
	}

	@Override
	public Object getItem(int position) {
		return socials.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Social social = socials.get(position);
		ViewHolder viewHolder = new ViewHolder();

		if (convertView == null) {
			convertView = context.getLayoutInflater().inflate(R.layout.list_item_social, parent, false);
			viewHolder.socialTextView = (TextView) convertView.findViewById(R.id.editTextContactSocial);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (social != null) {
			viewHolder.socialTextView.setText(social.getUrl());
		}

		return convertView;
	}

	static class ViewHolder {
		public TextView socialTextView;
	}
}
