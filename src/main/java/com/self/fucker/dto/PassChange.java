package com.self.fucker.dto;

import java.io.Serializable;

public class PassChange implements Serializable {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String newPassword;
	private String password;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
