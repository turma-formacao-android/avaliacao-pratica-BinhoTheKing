package br.com.cast.turmaformacao.agenda.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Email implements Parcelable {
	private Integer id;
	private Contact contact;
	private String email;

	public Email() {
	}

	protected Email(Parcel in) {
		id = in.readInt();
		contact = in.readParcelable(Contact.class.getClassLoader());
		email = in.readString();
	}

	public static final Creator<Email> CREATOR = new Creator<Email>() {
		@Override
		public Email createFromParcel(Parcel in) {
			return new Email(in);
		}

		@Override
		public Email[] newArray(int size) {
			return new Email[size];
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String $Email) {
		email = $Email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Email email1 = (Email) o;

		if (id != null ? !id.equals(email1.id) : email1.id != null) return false;
		if (contact != null ? !contact.equals(email1.contact) : email1.contact != null)
			return false;
		return !(email != null ? !email.equals(email1.email) : email1.email != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (contact != null ? contact.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Email{" +
				"id=" + id +
				", contact=" + contact +
				", email='" + email + '\'' +
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
		dest.writeString(email);
	}
}
