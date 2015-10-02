package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.cast.turmaformacao.agenda.util.ApplicationUtil;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static String DATABASE_NAME = "agenda";
	private static Integer VERSION = 1;

	public static DatabaseHelper getInstance(){
		return new DatabaseHelper(ApplicationUtil.getApplicationContext());
	}

	public DatabaseHelper(Context $Context) {
		super($Context, DATABASE_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(ContactContract.getCreateTableScript());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
