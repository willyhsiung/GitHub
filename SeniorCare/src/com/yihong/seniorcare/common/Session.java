package com.yihong.seniorcare.common;

import java.sql.Timestamp;

public class Session implements Cloneable, java.io.Serializable {

	public String userId;
	public String sessionId;
	public String status;
	public Timestamp startTime;
	public Timestamp updateTime;
	public Timestamp lastInvalidAttempt;
	public String languageCode;
	public Timestamp lastActivityTimeStamp;
	public String invalidAttemptsCount;
	public String updatedBy;

	public Session() {
	}

	public Session(String userId, String sessionId, String status,
			Timestamp startTime, Timestamp updateTime,
			Timestamp lastInvalidAttempt, String languageCode,
			Timestamp lastActivityTimeStamp,
			String invalidAttemptsCount, String updatedBy) {
		this.userId = userId;
		this.sessionId = sessionId;
		this.status = status;
		this.startTime = startTime;
		this.updateTime = updateTime;
		this.lastInvalidAttempt = lastInvalidAttempt;
		this.languageCode = languageCode;
		this.lastActivityTimeStamp = lastActivityTimeStamp;
		this.invalidAttemptsCount = invalidAttemptsCount;
		this.updatedBy = updatedBy;
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
		builder.append("Session [invalidAttemptsCount=");
		builder.append(invalidAttemptsCount);
		builder.append(", languageCode=");
		builder.append(languageCode);
		builder.append(", lastActivityTimeStamp=");
		builder.append(lastActivityTimeStamp);
		builder.append(", lastInvalidAttempt=");
		builder.append(lastInvalidAttempt);
		builder.append(", sessionId=");
		builder.append(sessionId);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", userId=");
		builder.append(userId);
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

		if (o instanceof Session) {
			final com.yihong.seniorcare.common.Session obj = (com.yihong.seniorcare.common.Session) o;
			boolean res = true;
			do {
				res = this.userId == obj.userId
						|| (this.userId != null && obj.userId != null && this.userId
								.equals(obj.userId));
				if (!res) {
					break;
				}

				res = this.sessionId == obj.sessionId
						|| (this.sessionId != null && obj.sessionId != null && this.sessionId
								.equals(obj.sessionId));
				if (!res) {
					break;
				}

				res = this.status == obj.status
						|| (this.status != null && obj.status != null && this.status
								.equals(obj.status));
				if (!res) {
					break;
				}

				res = this.startTime == obj.startTime
						|| (this.startTime != null && obj.startTime != null && this.startTime
								.equals(obj.startTime));
				if (!res) {
					break;
				}

				res = this.updateTime == obj.updateTime
						|| (this.updateTime != null && obj.updateTime != null && this.updateTime
								.equals(obj.updateTime));
				if (!res) {
					break;
				}

				res = this.lastInvalidAttempt == obj.lastInvalidAttempt
						|| (this.lastInvalidAttempt != null
								&& obj.lastInvalidAttempt != null && this.lastInvalidAttempt
								.equals(obj.lastInvalidAttempt));
				if (!res) {
					break;
				}

				res = this.languageCode == obj.languageCode
						|| (this.languageCode != null
								&& obj.languageCode != null && this.languageCode
								.equals(obj.languageCode));
				if (!res) {
					break;
				}

				res = this.lastActivityTimeStamp == obj.lastActivityTimeStamp
						|| (this.lastActivityTimeStamp != null
								&& obj.lastActivityTimeStamp != null && this.lastActivityTimeStamp
								.equals(obj.lastActivityTimeStamp));
				if (!res) {
					break;
				}

				res = this.invalidAttemptsCount == obj.invalidAttemptsCount
						|| (this.invalidAttemptsCount != null
								&& obj.invalidAttemptsCount != null && this.invalidAttemptsCount
								.equals(obj.invalidAttemptsCount));
				if (!res) {
					break;
				}

				res = this.updatedBy == obj.updatedBy
						|| (this.updatedBy != null && obj.updatedBy != null && this.updatedBy
								.equals(obj.updatedBy));
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
