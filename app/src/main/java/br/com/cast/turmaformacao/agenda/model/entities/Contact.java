package br.com.cast.turmaformacao.agenda.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
	private Integer id;
	private String name;
	private Phone[] phones;
	private Email[] emails;
	private String socials;
	private PersonalAddress address;

	public Contact() {
	}

	protected Contact(Parcel in) {
		id = in.readInt();
		name = in.readString();
		phones = (Phone[]) in.readParcelableArray(Phone.class.getClassLoader());
		emails = (Email[]) in.readParcelableArray(Email.class.getClassLoader());
		socials = in.readString();
		address = in.readParcelable(PersonalAddress.class.getClassLoader());
	}

	public static final Creator<Contact> CREATOR = new Creator<Contact>() {
		@Override
		public Contact createFromParcel(Parcel in) {
			return new Contact(in);
		}

		@Override
		public Contact[] newArray(int size) {
			return new Contact[size];
		}
	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer $Id) {
		id = $Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String $Name) {
		name = $Name;
	}

	public Phone[] getPhones() {
		return phones;
	}

	public void setPhones(Phone[] $Phones) {
		phones = $Phones;
	}

	public Email[] getEmails() {
		return emails;
	}

	public void setEmails(Email[] $Emails) {
		emails = $Emails;
	}

	public String getSocials() {
		return socials;
	}

	public void setSocials(String $Socials) {
		socials = $Socials;
	}

	public PersonalAddress getAddress() {
		return address;
	}

	public void setAddress(PersonalAddress $Address) {
		address = $Address;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id != null ? id : -1);
		dest.writeString(name);
		dest.writeParcelableArray(phones, flags);
		dest.writeParcelableArray(emails, flags);
		dest.writeString(socials);
		dest.writeParcelable(address, flags);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Contact client = (Contact) o;

		if (id != null ? !id.equals(client.id) : client.id != null) return false;
		if (name != null ? !name.equals(client.name) : client.name != null) return false;
		if (phones != null ? !phones.equals(client.phones) : client.phones != null) return false;
		if (emails != null ? !emails.equals(client.emails) : client.emails != null) return false;
		if (socials != null ? !socials.equals(client.socials) : client.socials != null)
			return false;
		return !(address != null ? !address.equals(client.address) : client.address != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (phones != null ? phones.hashCode() : 0);
		result = 31 * result + (emails != null ? emails.hashCode() : 0);
		result = 31 * result + (socials != null ? socials.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		return result;
	}


}
