package br.com.cast.turmaformacao.agenda.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonalAddress implements Parcelable {
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonProperty("cep")
	private Integer zipCode;

	@JsonProperty("bairro")
	private String neighborhood;

	@JsonProperty("cidade")
	private String city;

	@JsonProperty("logradouro")
	private String street;

	@JsonProperty("estado")
	private String state;

	public PersonalAddress() {
	}

	protected PersonalAddress(Parcel in) {
		neighborhood = in.readString();
		city = in.readString();
		street = in.readString();
		state = in.readString();
	}

	public static final Creator<PersonalAddress> CREATOR = new Creator<PersonalAddress>() {
		@Override
		public PersonalAddress createFromParcel(Parcel in) {
			return new PersonalAddress(in);
		}

		@Override
		public PersonalAddress[] newArray(int size) {
			return new PersonalAddress[size];
		}
	};

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer $ZipCode) {
		zipCode = $ZipCode;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String $Neighborhood) {
		neighborhood = $Neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String $City) {
		city = $City;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String $Street) {
		street = $Street;
	}

	public String getState() {
		return state;
	}

	public void setState(String $State) {
		state = $State;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(neighborhood);
		dest.writeString(city);
		dest.writeString(street);
		dest.writeString(state);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PersonalAddress that = (PersonalAddress) o;

		if (!zipCode.equals(that.zipCode)) return false;
		if (neighborhood != null ? !neighborhood.equals(that.neighborhood) : that.neighborhood != null)
			return false;
		if (city != null ? !city.equals(that.city) : that.city != null) return false;
		if (street != null ? !street.equals(that.street) : that.street != null) return false;
		return !(state != null ? !state.equals(that.state) : that.state != null);

	}

	@Override
	public int hashCode() {
		int result = zipCode.hashCode();
		result = 31 * result + (neighborhood != null ? neighborhood.hashCode() : 0);
		result = 31 * result + (city != null ? city.hashCode() : 0);
		result = 31 * result + (street != null ? street.hashCode() : 0);
		result = 31 * result + (state != null ? state.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "PersonalAddress{" +
				"zipCode=" + zipCode +
				", state='" + state + '\'' +
				", city='" + city + '\'' +
				", neighborhood='" + neighborhood + '\'' +
				", street='" + street + '\'' +
				'}';
	}
}
