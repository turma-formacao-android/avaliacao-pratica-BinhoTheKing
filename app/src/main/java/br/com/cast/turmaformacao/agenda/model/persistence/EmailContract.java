package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Email;
import br.com.cast.turmaformacao.agenda.model.entities.Phone;

public class EmailContract {
	public static String TABLE = "contact";
	public static String ID = "id";
	public static String EMAIL = "email";
	public static String CONTACT_ID = "contact_id";

	public static String[] COLUMNS = {ID, EMAIL, CONTACT_ID};

	public static String getCreateTableScript() {
		StringBuilder create = new StringBuilder();

		create.append(" CREATE TABLE " + TABLE);
		create.append(" (");
		create.append(ID + " INTEGER PRIMARY KEY, ");
		create.append(EMAIL + " INTEGER, ");
		create.append(CONTACT_ID + " INTEGER, ");
		create.append(" FOREIGN KEY (" + CONTACT_ID + ") REFERENCES "
				+ ContactContract.TABLE + " (" + ContactContract.ID + ") ");
		create.append(") ");

		return create.toString();
	}

	public static ContentValues getContentValues(Email $Email) {
		ContentValues values = new ContentValues();

		values.put(ID, $Email.getId());
		values.put(EMAIL, $Email.getEmail());
		values.put(CONTACT_ID, $Email.getContact().getId());

		return values;
	}

	public static Email getEmail(Cursor $Cursor) {
		Email email = new Email();

		if (!$Cursor.isBeforeFirst() || $Cursor.moveToNext()) {
			email.setId($Cursor.getInt($Cursor.getColumnIndex(ID)));
			email.setEmail($Cursor.getString($Cursor.getColumnIndex(EMAIL)));
			email.setContact(
					ContactRepository.getById(
							$Cursor.getInt($Cursor.getColumnIndex(ContactContract.ID))));
		}

		return email;
	}

	public static List<Email> getPhones (Cursor $Cursor){
		List<Email> emails = new ArrayList<>();

		while ($Cursor.moveToNext()) {
			emails.add(getEmail($Cursor));
		}

		return emails;
	}
}
