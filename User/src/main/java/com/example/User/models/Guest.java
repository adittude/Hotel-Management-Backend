package com.example.User.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "Guest")
public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int guestId;
	private String guestName;
	private long guestContact;
	private String guestEmail;
	private String guestGender;
	private boolean deleted=Boolean.FALSE;
	private String guestAddress;


	public Guest() {

	}

	public Guest(int guestId, String guestName, long guestContact, String guestEmail, String guestGender,
                 String guestAddress) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestContact = guestContact;
		this.guestEmail = guestEmail;
		this.guestGender = guestGender;
		this.guestAddress = guestAddress;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public long getGuestContact() {
		return guestContact;
	}

	public void setGuestContact(long guestContact) {
		this.guestContact = guestContact;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestRmail) {
		this.guestEmail = guestRmail;
	}

	public String getGuestGender() {
		return guestGender;
	}

	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", guestName=" + guestName + ", guestContact=" + guestContact
				+ ", guestEmail=" + guestEmail + ", guestGender=" + guestGender + ", guestAddress=" + guestAddress
				+ "]";
	}

}
