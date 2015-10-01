package br.com.cast.turmaformacao.agenda.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Phone implements Parcelable{
	private Integer id;
	private Integer contactId;
	private Integer phoneNumber;

	public Phone() {
	}

	protected Phone(Parcel in) {
		id = in.readInt();
		contactId = in.readInt();
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

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer $ContactId) {
		contactId = $ContactId;
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
		if (contactId != null ? !contactId.equals(phone.contactId) : phone.contactId != null)
			return false;
		return !(phoneNumber != null ? !phoneNumber.equals(phone.phoneNumber) : phone.phoneNumber != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Phone{" +
				"id=" + id +
				", contactId=" + contactId +
				", phoneNumber=" + phoneNumber +
				'}';
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeInt(contactId);
		dest.writeInt(phoneNumber);
	}
}
