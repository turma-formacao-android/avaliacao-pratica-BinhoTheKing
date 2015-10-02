package br.com.cast.turmaformacao.agenda.model.service;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.cast.turmaformacao.agenda.model.entities.PersonalAddress;

public class AddressHTTPService {

	public static final String URL = "http://api.postmon.com.br/v1/cep/";

	private AddressHTTPService() {
		super();
	}

	public static PersonalAddress getAddressFromWeb(Integer $ZipCode) {
		PersonalAddress personalAddress = new PersonalAddress();

		try {
			java.net.URL url = new URL(URL + $ZipCode.toString());
			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream inputStream = conn.getInputStream();
				ObjectMapper objectMapper = new ObjectMapper();
				personalAddress = objectMapper.readValue(inputStream, PersonalAddress.class);
			}
		} catch (Exception e) {
			Log.e("Erro", "Timeout");
		}

		return personalAddress;
	}
}
