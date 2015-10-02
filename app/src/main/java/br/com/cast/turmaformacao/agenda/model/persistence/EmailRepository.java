package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Email;
import br.com.cast.turmaformacao.agenda.model.entities.Email;

public final class EmailRepository {

	public EmailRepository() {
	}

	public static void save(Email $Email) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues contentValues = EmailContract.getContentValues($Email);
		$Email.setId((int) db.insert(EmailContract.TABLE, null, contentValues));

		db.close();
		databaseHelper.close();
	}

	public static void update(Email $Email) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues values = EmailContract.getContentValues($Email);
		String where = EmailContract.ID + " = ? ";
		String[] params = {$Email.getId().toString()};
		db.update(EmailContract.TABLE, values, where, params);

		db.close();
		databaseHelper.close();
	}

	public static void delete(Integer $Id) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		String where = EmailContract.ID + " = ? ";
		String[] params = {$Id.toString()};
		db.delete(EmailContract.TABLE, where, params);

		db.close();
		databaseHelper.close();
	}

	public static Email getById(Integer $Id) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getReadableDatabase();
		Email email;

		String where = EmailContract.ID + " = ? ";
		String[] params = {$Id.toString()};
		Cursor cursor = db.query(EmailContract.TABLE, EmailContract.COLUMNS, where, params, null, null, null);
		email = EmailContract.getEmail(cursor);

		db.close();
		databaseHelper.close();
		return email;
	}

	public static List<Email> getAll() {
		List<Email> emails;

		DatabaseHelper dataBaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

		Cursor cursor = db.query(EmailContract.TABLE, EmailContract.COLUMNS, null, null, null, null, EmailContract.ID);

		emails = EmailContract.getEmails(cursor);

		db.close();
		dataBaseHelper.close();

		return emails;
	}
}
