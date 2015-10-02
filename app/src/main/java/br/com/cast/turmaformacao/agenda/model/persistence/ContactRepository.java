package br.com.cast.turmaformacao.agenda.model.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.cast.turmaformacao.agenda.model.entities.Contact;

public class ContactRepository {
	public static Contact getById(Integer $Id) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getReadableDatabase();
		Contact contact = null;

		String where = ContactContract.ID + " = ? ";
		String[] params = {$Id.toString()};
		Cursor cursor = db.query(ContactContract.TABLE, ContactContract.COLUMNS, where, params, null, null, null);
		contact = ContactContract.getContact(cursor);

		db.close();
		databaseHelper.close();
		return contact;
	}
}
