package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Contact;

public final class ContactRepository {

	public ContactRepository() {
	}

	public static void save(Contact $Contact) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues contentValues = ContactContract.getContentValues($Contact);
		$Contact.setId((int) db.insert(ContactContract.TABLE, null, contentValues));

		db.close();
		databaseHelper.close();
	}

	public static void update(Contact $Contact){
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues values = ContactContract.getContentValues($Contact);
		String where = ContactContract.ID + " = ? ";
		String[] params = {$Contact.getId().toString()};
		db.update(ContactContract.TABLE, values, where, params);

		db.close();
		databaseHelper.close();
	}

	public static void delete(Integer $Id){
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		String where = ContactContract.ID + " = ? ";
		String[] params = {$Id.toString()};
		db.delete(ContactContract.TABLE, where, params);

		db.close();
		databaseHelper.close();
	}

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

	public static List<Contact> getAll(){
		List<Contact> contacts;

		DatabaseHelper dataBaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

		Cursor cursor = db.query(ContactContract.TABLE, ContactContract.COLUMNS, null, null, null, null, ContactContract.ID);

		contacts = ContactContract.getContacts(cursor);

		db.close();
		dataBaseHelper.close();

		return contacts;
	}
}
