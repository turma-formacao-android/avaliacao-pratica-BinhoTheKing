package br.com.cast.turmaformacao.agenda.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.agenda.model.entities.Email;
import br.com.cast.turmaformacao.agenda.model.entities.Social;

public class SocialContract {
	public static String TABLE = "contact";
	public static String ID = "id";
	public static String URL = "url";
	public static String CONTACT_ID = "contact_id";

	public static String[] COLUMNS = {ID, URL, CONTACT_ID};

	public static String getCreateTableScript() {
		StringBuilder create = new StringBuilder();

		create.append(" CREATE TABLE " + TABLE);
		create.append(" (");
		create.append(ID + " INTEGER PRIMARY KEY, ");
		create.append(URL + " INTEGER, ");
		create.append(CONTACT_ID + " INTEGER, ");
		create.append(" FOREIGN KEY (" + CONTACT_ID + ") REFERENCES "
				+ ContactContract.TABLE + " (" + ContactContract.ID + ") ");
		create.append(") ");

		return create.toString();
	}

	public static ContentValues getContentValues(Social $$Social) {
		ContentValues values = new ContentValues();

		values.put(ID, $$Social.getId());
		values.put(URL, $$Social.getUrl());
		values.put(CONTACT_ID, $$Social.getContact().getId());

		return values;
	}

	public static Social getSocial(Cursor $Cursor) {
		Social social = new Social();

		if (!$Cursor.isBeforeFirst() || $Cursor.moveToNext()) {
			social.setId($Cursor.getInt($Cursor.getColumnIndex(ID)));
			social.setUrl($Cursor.getString($Cursor.getColumnIndex(URL)));
			social.setContact(
					ContactRepository.getById(
							$Cursor.getInt($Cursor.getColumnIndex(ContactContract.ID))));
		}

		return social;
	}

	public static List<Social> getSocials (Cursor $Cursor){
		List<Social> socials = new ArrayList<>();

		while ($Cursor.moveToNext()) {
			socials.add(getSocial($Cursor));
		}

		return socials;
	}
}
