package br.com.cast.turmaformacao.agenda.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Social implements Parcelable{
	private Integer id;
	private Contact contact;
	private String url;

	public Social() {
	}

	protected Social(Parcel in) {
		id = in.readInt();
		contact = in.readParcelable(Contact.class.getClassLoader());
		url = in.readString();
	}

	public static final Creator<Social> CREATOR = new Creator<Social>() {
		@Override
		public Social createFromParcel(Parcel in) {
			return new Social(in);
		}

		@Override
		public Social[] newArray(int size) {
			return new Social[size];
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String $Url) {
		url = $Url;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Social social = (Social) o;

		if (id != null ? !id.equals(social.id) : social.id != null) return false;
		if (contact != null ? !contact.equals(social.contact) : social.contact != null)
			return false;
		return !(url != null ? !url.equals(social.url) : social.url != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (contact != null ? contact.hashCode() : 0);
		result = 31 * result + (url != null ? url.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Social{" +
				"id=" + id +
				", contact=" + contact +
				", url='" + url + '\'' +
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
		dest.writeString(url);
	}
}
