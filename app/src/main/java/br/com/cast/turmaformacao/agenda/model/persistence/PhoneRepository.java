package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Phone;

public final class PhoneRepository {

	public PhoneRepository() {
	}

	public static void save(Phone $Phone) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues contentValues = PhoneContract.getContentValues($Phone);
		$Phone.setId((int) db.insert(PhoneContract.TABLE, null, contentValues));

		db.close();
		databaseHelper.close();
	}

	public static void update(Phone $Phone) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues values = PhoneContract.getContentValues($Phone);
		String where = PhoneContract.ID + " = ? ";
		String[] params = {$Phone.getId().toString()};
		db.update(PhoneContract.TABLE, values, where, params);

		db.close();
		databaseHelper.close();
	}

	public static void delete(Integer $Id) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		String where = PhoneContract.ID + " = ? ";
		String[] params = {$Id.toString()};
		db.delete(PhoneContract.TABLE, where, params);

		db.close();
		databaseHelper.close();
	}

	public static Phone getById(Integer $Id) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getReadableDatabase();
		Phone phone = null;

		String where = PhoneContract.ID + " = ? ";
		String[] params = {$Id.toString()};
		Cursor cursor = db.query(PhoneContract.TABLE, PhoneContract.COLUMNS, where, params, null, null, null);
		phone = PhoneContract.getPhone(cursor);

		db.close();
		databaseHelper.close();
		return phone;
	}

	public static List<Phone> getAll() {
		List<Phone> phones;

		DatabaseHelper dataBaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

		Cursor cursor = db.query(PhoneContract.TABLE, PhoneContract.COLUMNS, null, null, null, null, PhoneContract.ID);

		phones = PhoneContract.getPhones(cursor);

		db.close();
		dataBaseHelper.close();

		return phones;
	}
}
