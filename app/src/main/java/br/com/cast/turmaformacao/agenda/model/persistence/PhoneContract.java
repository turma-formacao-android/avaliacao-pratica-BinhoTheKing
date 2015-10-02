package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Phone;

public class PhoneContract {
	public static String TABLE = "contact";
	public static String ID = "id";
	public static String NUMBER = "number";
	public static String CONTACT_ID = "contact_id";

	public static String[] COLUMNS = {ID, NUMBER, CONTACT_ID};

	public static String getCreateTableScript() {
		StringBuilder create = new StringBuilder();

		create.append(" CREATE TABLE " + TABLE);
		create.append(" (");
		create.append(ID + " INTEGER PRIMARY KEY, ");
		create.append(NUMBER + " INTEGER, ");
		create.append(CONTACT_ID + " INTEGER, ");
		create.append(" FOREIGN KEY (" + CONTACT_ID + ") REFERENCES "
				+ ContactContract.TABLE + " (" + ContactContract.ID + ") ");
		create.append(") ");

		return create.toString();
	}

	public static ContentValues getContentValues(Phone $Phone) {
		ContentValues values = new ContentValues();

		values.put(ID, $Phone.getId());
		values.put(NUMBER, $Phone.getPhoneNumber());
		values.put(CONTACT_ID, $Phone.getContact().getId());

		return values;
	}

	public static Phone getPhone(Cursor $Cursor) {
		Phone phone = new Phone();

		if (!$Cursor.isBeforeFirst() || $Cursor.moveToNext()) {
			phone.setId($Cursor.getInt($Cursor.getColumnIndex(ID)));
			phone.setPhoneNumber($Cursor.getInt($Cursor.getColumnIndex(NUMBER)));
			phone.setContact(
					ContactRepository.getById(
							$Cursor.getInt($Cursor.getColumnIndex(ContactContract.ID))));
		}

		return phone;
	}

	public static List<Phone> getPhones (Cursor $Cursor){
		List<Phone> phones = new ArrayList<>();

		while ($Cursor.moveToNext()) {
			phones.add(getPhone($Cursor));
		}

		return phones;
	}
}
