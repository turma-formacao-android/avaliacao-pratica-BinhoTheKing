package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Contact;
import br.com.cast.turmaformacao.agenda.model.entities.PersonalAddress;

public class ContactContract {
	public static String TABLE = "contact";
	public static String ID = "id";
	public static String NAME = "name";
	public static String ZIP_CODE = "zip_code";
	public static String CITY = "city";
	public static String NEIGHBORHOOD = "neighborhood";
	public static String STREET = "street";
	public static String STATE = "state";

	public static String[] COLUMNS = {ID, NAME, ZIP_CODE, CITY, NEIGHBORHOOD, STREET, STATE};

	public static String getCreateTableScript() {
		StringBuilder create = new StringBuilder();

		create.append(" CREATE TABLE " + TABLE);
		create.append(" ( ");
		create.append(ID + " INTEGER PRIMARY KEY, ");
		create.append(NAME + " TEXT, ");
		create.append(ZIP_CODE + " INTEGER, ");
		create.append(STATE + " TEXT, ");
		create.append(CITY + " TEXT, ");
		create.append(NEIGHBORHOOD + " TEXT, ");
		create.append(STREET + " TEXT ");
		create.append(" ) ");

		return create.toString();
	}

	public static ContentValues getContentValues(Contact $Contact) {
		ContentValues values = new ContentValues();

		values.put(ID, $Contact.getId());
		values.put(NAME, $Contact.getName());
		values.put(ZIP_CODE, $Contact.getAddress().getZipCode());
		values.put(STATE, $Contact.getAddress().getState());
		values.put(CITY, $Contact.getAddress().getCity());
		values.put(NEIGHBORHOOD, $Contact.getAddress().getNeighborhood());
		values.put(STREET, $Contact.getAddress().getStreet());

		return values;
	}

	public static Contact getContact(Cursor $Cursor) {
		Contact contact = new Contact();

		if ($Cursor.isBeforeFirst() || $Cursor.moveToNext()) {
			contact.setId($Cursor.getInt($Cursor.getColumnIndex(ID)));
			contact.setName($Cursor.getString($Cursor.getColumnIndex(NAME)));

			PersonalAddress address = new PersonalAddress();
			address.setZipCode($Cursor.getInt($Cursor.getColumnIndex(ZIP_CODE)));
			address.setState($Cursor.getString($Cursor.getColumnIndex(STATE)));
			address.setCity($Cursor.getString($Cursor.getColumnIndex(CITY)));
			address.setNeighborhood($Cursor.getString($Cursor.getColumnIndex(NEIGHBORHOOD)));
			address.setStreet($Cursor.getString($Cursor.getColumnIndex(STREET)));

			contact.setAddress(address);
		}

		return contact;
	}

	public static List<Contact> getContacts(Cursor $Cursor) {
		List<Contact> contacts = new ArrayList<>();

		while ($Cursor.moveToNext()) {
			contacts.add(getContact($Cursor));
		}

		return contacts;
	}

}
