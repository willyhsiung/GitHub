package com.yihong.seniorcare.common;

/**
 * <p>
 * <ul>
 * <li><b>Java Class</b> com.telcordia.inpac.intf.ValuesList
 * <li><b>Source File</b> com/telcordia/inpac/intf/ValuesList.java
 * <li><b>IDL Source File</b> Npc.idl
 * <li><b>IDL Absolute Name</b> ::intf::ValuesList
 * <li><b>Repository Identifier</b> IDL:intf/ValuesList:1.0
 * </ul>
 * <b>IDL definition:</b>
 * 
 * <pre>
 * #pragma prefix "intf"
 *     struct ValuesList {
 *       string valueId;
 *       string value1;
 *       string value2;
 *       string value3;
 *       string value4;
 *     };
 * </pre>
 * 
 * </p>
 */
final public class ValuesList implements Cloneable, java.io.Serializable {
	private String valueId;
	private String value1;
	private String value2;
	private String value3;
	private String value4;

	public ValuesList() {
		valueId = "";
		value1 = "";
		value2 = "";
		value3 = "";
		value4 = "";
	}

	public ValuesList(String valueId, String value1, String value2,
			String value3, String value4) {
		this.valueId = valueId;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.value4 = value4;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ce) {
		}
		return obj;
	}

	public String getValueId() {
		return valueId;
	}

	public void setValueId(String valueId) {
		this.valueId = valueId;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValuesList [value1=");
		builder.append(value1);
		builder.append(", value2=");
		builder.append(value2);
		builder.append(", value3=");
		builder.append(value3);
		builder.append(", value4=");
		builder.append(value4);
		builder.append(", valueId=");
		builder.append(valueId);
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

		if (o instanceof com.yihong.seniorcare.common.ValuesList) {
			final com.yihong.seniorcare.common.ValuesList obj = (com.yihong.seniorcare.common.ValuesList) o;
			boolean res = true;
			do {

				res = this.valueId == obj.valueId
						|| (this.valueId != null && obj.valueId != null && this.valueId
								.equals(obj.valueId));
				if (!res) {
					break;
				}

				res = this.value1 == obj.value1
						|| (this.value1 != null && obj.value1 != null && this.value1
								.equals(obj.value1));
				if (!res) {
					break;
				}

				res = this.value2 == obj.value2
						|| (this.value2 != null && obj.value2 != null && this.value2
								.equals(obj.value2));
				if (!res) {
					break;
				}

				res = this.value3 == obj.value3
						|| (this.value3 != null && obj.value3 != null && this.value3
								.equals(obj.value3));
				if (!res) {
					break;
				}

				res = this.value4 == obj.value4
						|| (this.value4 != null && obj.value4 != null && this.value4
								.equals(obj.value4));
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
