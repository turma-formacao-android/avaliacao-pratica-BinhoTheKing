package br.com.cast.turmaformacao.agenda.controllers.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.agenda.R;
import br.com.cast.turmaformacao.agenda.model.entities.Phone;

public class PhoneListAdapter extends BaseAdapter {

	private List<Phone> phones;
	private Activity context;

	public PhoneListAdapter(List<Phone> $Phones, Activity $Context) {
		phones = $Phones;
		context = $Context;
	}

	@Override
	public int getCount() {
		return phones.size();
	}

	@Override
	public Object getItem(int position) {
		return phones.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Phone phone = phones.get(position);
		ViewHolder viewHolder = new ViewHolder();

		if (convertView == null) {
			convertView = context.getLayoutInflater().inflate(R.layout.list_item_phone, parent, false);
			viewHolder.phoneTextView = (TextView) convertView.findViewById(R.id.editTextContactPhone);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (phone != null) {
			viewHolder.phoneTextView.setText(phone.getPhoneNumber().toString());
		}

		return convertView;
	}

	static class ViewHolder {
		public TextView phoneTextView;
	}
}
