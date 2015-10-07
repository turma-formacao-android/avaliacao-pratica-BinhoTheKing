package br.com.cast.turmaformacao.agenda.controllers.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.cast.turmaformacao.agenda.R;
import br.com.cast.turmaformacao.agenda.model.entities.Contact;
import br.com.cast.turmaformacao.agenda.model.entities.Email;
import br.com.cast.turmaformacao.agenda.model.entities.PersonalAddress;
import br.com.cast.turmaformacao.agenda.model.entities.Phone;
import br.com.cast.turmaformacao.agenda.model.entities.Social;
import br.com.cast.turmaformacao.agenda.model.service.AddressHTTPService;
import br.com.cast.turmaformacao.agenda.model.service.ContactBusinessService;
import br.com.cast.turmaformacao.agenda.model.service.EmailBusinessService;
import br.com.cast.turmaformacao.agenda.model.service.PhoneBusinessService;
import br.com.cast.turmaformacao.agenda.model.service.SocialBusinessService;

public class ContactFormActivity extends AppCompatActivity {

	Contact contact;
	private ImageView imageContactView;
	private EditText editTextContactNameView;
	private EditText editTextContactPhoneView;
	private EditText editTextContactEmailView;
	private EditText editTextContactSocialView;
	private EditText editTextContactZipCodeView;
	private EditText editTextContactCityView;
	private EditText editTextContactStateView;
	private EditText editTextContactNeighborhoodView;
	private EditText editTextContactStreetView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_form);
	}

	private void initContact() {
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			contact = (Contact) extras.get(Contact.PARAM_CONTACT);
		}
		contact = contact != null ? contact : new Contact();
	}

	@Override
	protected void onResume() {
		super.onResume();
		initContact();
		bindLayoutComponents();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_contact_form, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case R.id.menuAdd:
				onMenuAddContactClick();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void onMenuAddContactClick() {
		bindContact();
		ContactBusinessService.saveOrUpdate(contact);
		for (Phone p :
				contact.getPhones()) {
			PhoneBusinessService.saveOrUpdate(p);
		}
		for (Email e :
				contact.getEmails()) {
			EmailBusinessService.saveOrUpdate(e);
		}
		for (Social s :
				contact.getSocials()) {
			SocialBusinessService.saveOrUpdate(s);
		}
		ContactBusinessService.saveOrUpdate(contact);
		finish();
	}

	private void bindContact() {
		contact.setName(editTextContactNameView.getText().toString());
		Phone phone = new Phone();
		phone.setPhoneNumber(Integer.valueOf(editTextContactPhoneView.getText().toString()));
		contact.setPhones(new Phone[]{phone});
		Email email = new Email();
		email.setEmail(editTextContactEmailView.getText().toString());
		email.setContact(contact);
		contact.setEmails(new Email[]{email});
		Social social = new Social();
		social.setUrl(editTextContactSocialView.getText().toString());
		social.setContact(contact);
		contact.setSocials(new Social[]{social});
		PersonalAddress personalAddress = new PersonalAddress();
		personalAddress.setZipCode(Integer.valueOf(editTextContactZipCodeView.getText().toString()));
		personalAddress.setCity(editTextContactCityView.getText().toString());
		personalAddress.setState(editTextContactStateView.getText().toString());
		personalAddress.setNeighborhood(editTextContactNeighborhoodView.getText().toString());
		personalAddress.setStreet(editTextContactStreetView.getText().toString());
		contact.setAddress(personalAddress);
	}

	private void bindLayoutComponents() {
		bindImageContactView();
		bindEditTextContactNameView();
		bindEditTextContactPhoneView();
		bindEditTextContactEmailView();
		bindEditTextContactSocialView();
		bindEditTextContactZipCodeView();
		bindAddressComponents();
	}

	private void bindAddressComponents() {
		bindEditTextContactCityView();
		bindEditTextContactStateView();
		bindEditTextContactNeighborhoodView();
		bindEditTextContactStreetView();
	}

	private void bindEditTextContactStreetView() {
		editTextContactStreetView = (EditText) findViewById(R.id.editTextContactStreet);
		editTextContactStreetView.setText(contact.getAddress().getStreet());
	}

	private void bindEditTextContactNeighborhoodView() {
		editTextContactNeighborhoodView = (EditText) findViewById(R.id.editTextContactNeighborhood);
		editTextContactNeighborhoodView.setText(contact.getAddress().getNeighborhood());
	}

	private void bindEditTextContactStateView() {
		editTextContactStateView = (EditText) findViewById(R.id.editTextContactState);
		editTextContactStateView.setText(contact.getAddress().getState());
	}

	private void bindEditTextContactCityView() {
		editTextContactCityView = (EditText) findViewById(R.id.editTextContactCity);
		editTextContactCityView.setText(contact.getAddress().getCity());
	}

	private void bindEditTextContactZipCodeView() {
		editTextContactZipCodeView = (EditText) findViewById(R.id.editTextContactZipCode);
		editTextContactZipCodeView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_action_search, 0);
		if (contact.getAddress().getZipCode() != null) {
			editTextContactZipCodeView.setText(contact.getAddress().getZipCode().toString());
		}
		editTextContactZipCodeView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (event.getRawX() >= (editTextContactZipCodeView.getRight() - editTextContactZipCodeView.getCompoundDrawables()[2].getBounds().width())) {
						PersonalAddress addressFromWeb = AddressHTTPService.getAddressFromWeb(Integer.parseInt(editTextContactZipCodeView.getText().toString()));
						contact.setAddress(addressFromWeb);
						bindAddressComponents();
					}
				}
				return false;
			}
		});
	}

	private void bindEditTextContactSocialView() {
		editTextContactSocialView = (EditText) findViewById(R.id.editTextContactSocial);
		if (contact.getSocials() != null) {
			editTextContactSocialView.setText(contact.getSocials()[0].getUrl());
		}
	}

	private void bindEditTextContactEmailView() {
		editTextContactEmailView = (EditText) findViewById(R.id.editTextContactEmail);
		if (contact.getEmails() != null) {
			editTextContactEmailView.setText(contact.getEmails()[0].getEmail());
		}
	}

	private void bindEditTextContactPhoneView() {
		editTextContactPhoneView = (EditText) findViewById(R.id.editTextContactPhone);
		if (contact.getPhones() != null) {
			editTextContactPhoneView.setText(contact.getPhones()[0].getPhoneNumber());
		}
	}

	private void bindEditTextContactNameView() {
		editTextContactNameView = (EditText) findViewById(R.id.editTextContactName);
		editTextContactNameView.setText(contact.getName());
	}

	private void bindImageContactView() {
		imageContactView = (ImageView) findViewById(R.id.imageViewContact);
	}
}
