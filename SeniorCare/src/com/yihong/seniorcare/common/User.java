package com.yihong.seniorcare.common;

import java.util.Arrays;

public class User implements Cloneable, java.io.Serializable {
	public String userId;
	public String userName;
	public String userType;
	public String sessionId;
	public String password;
	public String updateTime;
	public String[] roles;
	public Session sessionInfo;
	
	public User() {
	}

	public User(String userId, String userName, String userType,
			String sessionId, String password,  String updateTime,
			String[] roles, Session sessionInfo) {
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.sessionId = sessionId;
		this.password = password;
		this.updateTime = updateTime;
		this.roles = roles;
		this.sessionInfo = sessionInfo;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ce) {
		}
		return obj;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [password=");
		builder.append(password);
		builder.append(", roles=");
		builder.append(Arrays.toString(roles));
		builder.append(", sessionId=");
		builder.append(sessionId);
		builder.append(", sessionInfo=");
		builder.append(sessionInfo);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userType=");
		builder.append(userType);
		builder.append("]");
		return builder.toString();
	}

	public boolean equals(java.lang.Object o) {

		if (this == o) {
			return true;
		}

		if (o == null) {
			return false;
		}

		if (o instanceof User) {
			final User obj = (User) o;
			boolean res = true;
			do {

				res = this.userId == obj.userId
						|| (this.userId != null && obj.userId != null && this.userId
								.equals(obj.userId));
				if (!res) {
					break;
				}

				res = this.userName == obj.userName
						|| (this.userName != null && obj.userName != null && this.userName
								.equals(obj.userName));
				if (!res) {
					break;
				}
				res = this.userType == obj.userType
						|| (this.userType != null && obj.userType != null && this.userType
								.equals(obj.userType));
				if (!res) {
					break;
				}
				res = this.sessionId == obj.sessionId
						|| (this.sessionId != null && obj.sessionId != null && this.sessionId
								.equals(obj.sessionId));
				if (!res) {
					break;
				}

				res = this.password == obj.password
						|| (this.password != null && obj.password != null && this.password
								.equals(obj.password));
				if (!res) {
					break;
				}


				res = this.updateTime == obj.updateTime
						|| (this.updateTime != null && obj.updateTime != null && this.updateTime
								.equals(obj.updateTime));
				if (!res) {
					break;
				}

				res = this.roles == obj.roles
						|| (this.roles != null
								&& obj.roles != null && this.roles
								.equals(obj.roles));
				if (!res) {
					break;
				}

				res = this.sessionInfo == obj.sessionInfo
						|| (this.sessionInfo != null && obj.sessionInfo != null && this.sessionInfo
								.equals(obj.sessionInfo));
				if (!res) {
					break;
				}

			} while (false);
			return res;
		} else {
			return false;
		}
	}

	
}
