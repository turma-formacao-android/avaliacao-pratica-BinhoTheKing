package br.com.cast.turmaformacao.agenda.controllers.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.agenda.R;
import br.com.cast.turmaformacao.agenda.model.entities.Contact;

public class ContactListAdapter extends BaseAdapter {

	Activity context;
	List<Contact> contacts;

	public ContactListAdapter(Activity $Context, List<Contact> $Contacts) {
		context = $Context;
		contacts = $Contacts;
	}

	@Override
	public int getCount() {
		return contacts.size();
	}

	@Override
	public Contact getItem(int position) {
		return contacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Contact contact = contacts.get(position);
		ViewHolder viewHolder = new ViewHolder();

		if (convertView == null) {
			convertView = context.getLayoutInflater().inflate(R.layout.list_item_contact, parent, false);
			viewHolder.productImageView = (ImageView) convertView.findViewById(R.id.imageViewContact);
			viewHolder.productNameTextView = (TextView) convertView.findViewById(R.id.textViewContactName);

			convertView.setTag(viewHolder);


		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (contact != null) {
//			File file = new File(Environment.getDataDirectory()+"/"+Environment.DIRECTORY_DOWNLOADS);
//			Bitmap image = BitmapFactory.decodeFile(Environment.getDataDirectory()+"/"+Environment.DIRECTORY_DOWNLOADS+"/image.jpg"/*product.getImageSrc()*/);


//			viewHolder.productImageView.setImageBitmap(image);

			Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_account_box);
			viewHolder.productImageView.setImageDrawable(icon);
			viewHolder.productNameTextView.setText(contact.getName());
		}

		return convertView;
	}
	static class ViewHolder {

		public ImageView productImageView;
		public TextView productNameTextView;
	}
}
