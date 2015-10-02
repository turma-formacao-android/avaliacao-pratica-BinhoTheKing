package br.com.cast.turmaformacao.agenda.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.agenda.R;
import br.com.cast.turmaformacao.agenda.controllers.adapters.ContactListAdapter;
import br.com.cast.turmaformacao.agenda.model.entities.Contact;
import br.com.cast.turmaformacao.agenda.model.service.ContactBusinessService;

public class ContactsListActivity extends AppCompatActivity {

	private ListView listContactView;
	private List<Contact> contacts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_list);
		refreshContacts();
		bindListContactView();
	}


	private void refreshContacts() {
		contacts = ContactBusinessService.findAll();
		contacts = contacts == null ? new ArrayList<Contact>() : contacts;
	}

	private void bindListContactView() {
		listContactView = (ListView) findViewById(R.id.listViewContact);
		listContactView.setAdapter(new ContactListAdapter(this, contacts));
		listContactView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				ContactListAdapter adapter = (ContactListAdapter) listContactView.getAdapter();
				Intent goToContactFormActivity = new Intent(ContactsListActivity.this, ContactFormActivity.class);
				goToContactFormActivity.putExtra(Contact.PARAM_CONTACT, adapter.getItem(position));
				startActivity(goToContactFormActivity);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		updateList();
	}

	private void updateList() {
		BaseAdapter adapter = (BaseAdapter) listContactView.getAdapter();
		refreshContacts();
		adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_contacts_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.menuAdd) {
			onMenuAddClick();
		}

		return super.onOptionsItemSelected(item);
	}

	private void onMenuAddClick() {
		Intent goToContactFormActivity = new Intent(ContactsListActivity.this, ContactFormActivity.class);
		startActivity(goToContactFormActivity);
	}
}
