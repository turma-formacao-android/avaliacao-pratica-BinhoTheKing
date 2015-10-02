package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Social;

public final class SocialRepository {

	public SocialRepository() {
	}

	public static void save(Social $Social) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues contentValues = SocialContract.getContentValues($Social);
		$Social.setId((int) db.insert(SocialContract.TABLE, null, contentValues));

		db.close();
		databaseHelper.close();
	}

	public static void update(Social $Social) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		ContentValues values = SocialContract.getContentValues($Social);
		String where = SocialContract.ID + " = ? ";
		String[] params = {$Social.getId().toString()};
		db.update(SocialContract.TABLE, values, where, params);

		db.close();
		databaseHelper.close();
	}

	public static void delete(Integer $Id) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();

		String where = SocialContract.ID + " = ? ";
		String[] params = {$Id.toString()};
		db.delete(SocialContract.TABLE, where, params);

		db.close();
		databaseHelper.close();
	}

	public static Social getById(Integer $Id) {
		DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = databaseHelper.getReadableDatabase();
		Social email;

		String where = SocialContract.ID + " = ? ";
		String[] params = {$Id.toString()};
		Cursor cursor = db.query(SocialContract.TABLE, SocialContract.COLUMNS, where, params, null, null, null);
		email = SocialContract.getSocial(cursor);

		db.close();
		databaseHelper.close();
		return email;
	}

	public static List<Social> getAll() {
		List<Social> socials;

		DatabaseHelper dataBaseHelper = DatabaseHelper.getInstance();
		SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

		Cursor cursor = db.query(SocialContract.TABLE, SocialContract.COLUMNS, null, null, null, null, SocialContract.ID);

		socials = SocialContract.getSocials(cursor);

		db.close();
		dataBaseHelper.close();

		return socials;
	}
}
