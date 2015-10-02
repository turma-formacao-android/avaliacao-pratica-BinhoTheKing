package br.com.cast.turmaformacao.agenda.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Phone implements Parcelable {
	private Integer id;
	private Contact contact;
	private Integer phoneNumber;

	public Phone() {
	}

	protected Phone(Parcel in) {
		id = in.readInt();
		contact = in.readParcelable(Contact.class.getClassLoader());
		phoneNumber = in.readInt();
	}

	public static final Creator<Phone> CREATOR = new Creator<Phone>() {
		@Override
		public Phone createFromParcel(Parcel in) {
			return new Phone(in);
		}

		@Override
		public Phone[] newArray(int size) {
			return new Phone[size];
		}
	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer $Id) {
		id = $Id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact $Contact) {
		contact = $Contact;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer $PhoneNumber) {
		phoneNumber = $PhoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Phone phone = (Phone) o;

		if (id != null ? !id.equals(phone.id) : phone.id != null) return false;
		if (contact != null ? !contact.equals(phone.contact) : phone.contact != null)
			return false;
		return !(phoneNumber != null ? !phoneNumber.equals(phone.phoneNumber) : phone.phoneNumber != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (contact != null ? contact.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Phone{" +
				"id=" + id +
				", contact=" + contact +
				", phoneNumber=" + phoneNumber +
				'}';
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id != null ? id : -1);
		dest.writeParcelable(contact, flags);
		dest.writeInt(phoneNumber);
	}
}
