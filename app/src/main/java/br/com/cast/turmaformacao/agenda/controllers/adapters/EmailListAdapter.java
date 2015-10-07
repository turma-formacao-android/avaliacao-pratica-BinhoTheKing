package br.com.cast.turmaformacao.agenda.controllers.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.agenda.R;
import br.com.cast.turmaformacao.agenda.model.entities.Email;

public class EmailListAdapter extends BaseAdapter {

	private List<Email> emails;
	private Activity context;

	public EmailListAdapter(List<Email> $Emails, Activity $Context) {
		emails = $Emails;
		context = $Context;
	}

	@Override
	public int getCount() {
		return emails.size();
	}

	@Override
	public Object getItem(int position) {
		return emails.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Email email = emails.get(position);
		ViewHolder viewHolder = new ViewHolder();

		if (convertView == null) {
			convertView = context.getLayoutInflater().inflate(R.layout.list_item_email, parent, false);
			viewHolder.emailTextView = (TextView) convertView.findViewById(R.id.editTextContactEmail);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (email != null) {
			viewHolder.emailTextView.setText(email.getEmail());
		}

		return convertView;
	}

	static class ViewHolder {
		public TextView emailTextView;
	}
}
