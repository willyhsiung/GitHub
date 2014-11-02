package com.yihong.seniorcare.common;


	import java.util.ArrayList;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.ListIterator;
	import java.util.Locale;

	public class YHException extends Exception {

	  private String errorCode;
	  private String errorMsg;
	  private String arg1;
	  private String arg2;
	  private String arg3;
	  private String arg4;

	  private LinkedList<YHException> YHExceptionList = null;
	  private int errorId;

	 
	  private boolean flag1 = false;
	  private boolean flag2 = false;
	  private boolean flag3 = false;
	  private boolean flag4 = false;
	  
	  protected List<String> errorList;

	  

	//default constructor
	  public YHException() {
	  }

	  //Constructor of Exception using errorCode only, no arguments.
	  public YHException(
	      String errorCode
	      ) {
	    this.errorCode = errorCode;
	  }

	  //Constructor using errorCode and one argument.
	  //The argument is defaulted to don't translate
	  public YHException(
	      String errorCode,
	      String arg1
	      ) {
	    this.errorCode = errorCode;
	    this.arg1 = arg1;
	  }

	  public YHException(
	      String errorCode,
	      String arg1,
	      boolean flag1
	      ) {
	    this.errorCode = errorCode;
	    this.arg1 = arg1;
	    this.flag1 = flag1;
	  }

	  public YHException(
	      String errorCode,
	      String arg1,
	      boolean flag1,
	      String arg2,
	      boolean flag2
	      ) {
	    this.errorCode = errorCode;
	    this.arg1 = arg1;
	    this.flag1 = flag1;
	    this.arg2 = arg2;
	    this.flag2 = flag2;
	  }

	  public YHException(
	      String errorCode,
	      String arg1,
	      boolean flag1,
	      String arg2,
	      boolean flag2,
	      String arg3,
	      boolean flag3
	      ) {
	    this.errorCode = errorCode;
	    this.arg1 = arg1;
	    this.flag1 = flag1;
	    this.arg2 = arg2;
	    this.flag2 = flag2;
	    this.arg3 = arg3;
	    this.flag3 = flag3;
	  }

	  public YHException(
	      String errorCode,
	      String arg1,
	      boolean flag1,
	      String arg2,
	      boolean flag2,
	      String arg3,
	      boolean flag3,
	      String arg4,
	      boolean flag4
	      ) {
	    this.errorCode = errorCode;
	    this.arg1 = arg1;
	    this.flag1 = flag1;
	    this.arg2 = arg2;
	    this.flag2 = flag2;
	    this.arg3 = arg3;
	    this.flag3 = flag3;
	    this.arg4 = arg4;
	    this.flag4 = flag4;
	  }

	  public YHException(
	      String errorCode,
	      String arg1,
	      String arg2
	      ) {
	    this.errorCode = errorCode;
	    this.arg1 = arg1;
	    this.arg2 = arg2;
	  }

	  public YHException(
	      String errorCode,
	      String arg1,
	      String arg2,
	      String arg3
	      ) {
	    this.errorCode = errorCode;
	    this.arg1 = arg1;
	    this.arg2 = arg2;
	    this.arg3 = arg3;

	  }

	  public YHException(
	      String errorCode,
	      String arg1,
	      String arg2,
	      String arg3,
	      String arg4
	      ) {
	    this.errorCode = errorCode;
	    this.arg1 = arg1;
	    this.arg2 = arg2;
	    this.arg3 = arg3;
	    this.arg4 = arg4;
	  }

	  public String getArg1() {
	    return arg1;
	  }

	  public String getArg2() {
	    return arg2;
	  }

	  public String getArg3() {
	    return arg3;
	  }

	  public String getArg4() {
	    return arg4;
	  }

	  public boolean getFlag1() {
	    return flag1;
	  }

	  public boolean getFlag2() {
	    return flag2;
	  }

	  public boolean getFlag3() {
	    return flag3;
	  }

	  public boolean getFlag4() {
	    return flag4;
	  }

	  public String getErrorCode() {
	    return errorCode;
	  }
	  
	  public int getErrorId() {
			return errorId;
	  }

	  public void setErrorId(int errorId) {
			this.errorId = errorId;
	  }

	  public void addTNError(String msg) {
		  if (errorList == null)
			  errorList = new ArrayList<String>();
		  if (!errorList.contains(msg))
			  errorList.add(msg);
	  }
	  public List<String> getErrorList() {
			return errorList;
	  }
	  public int getTnErrorCount() {
		  return errorList == null? 0: errorList.size(); 
	  }
	  public String getTNErrorList(String tag, int count) {
		  StringBuffer sb = new StringBuffer();
		  int cnt = 0;
		  if (errorList !=null) {
			 for (String t:errorList)  {
				 if (sb.length() != 0)
					 sb.append(",");
				 if (tag != null)
					 sb.append(t + " - " + tag);
				 else
					 sb.append(t);
				 cnt++;
				 if (cnt >= count)
					 break;
			 }
		  }
		  return sb.toString();
	  }

	  //getErrorMsg using errorCode and locale. read error from properties file
	  //translate if needed.
	  //add arguments and translate them if needed.
	  public String getErrorMsg(
	      java.util.Locale locale,
	      String errorCode
	      ) {
	    this.errorCode = errorCode;

	    MessageCatalog msgCat = new MessageCatalog(locale);

	    //this is to be used ONLY for special cases when the
	    //translation at the boundry is difficult and the user
	    //already has set the translated value in error message
	    if (errorCode.equalsIgnoreCase("-1")) {
	      return errorMsg;
	    }

	    //read resourcebundle using user's locale
	    //java.util.ResourceBundle msgs;
	    //msgs = java.util.ResourceBundle.getBundle("MessageCatalog", locale);
	    //get error msg from resource bundle in user's language
	    //String msg = "";//msgs.getString(errorCode);

	    String argument1 = null;
	    String argument2 = null;
	    String argument3 = null;
	    String argument4 = null;

	    if (arg1 != null) {
	      argument1 = arg1;
	      if (flag1) {
	        argument1 = msgCat.get(arg1);
	      }
	    }

	    if (arg2 != null) {
	      argument2 = arg2;
	      if (flag2 == true) {
	        argument2 = msgCat.get(arg2);
	      }
	    }

	    if (arg3 != null) {
	      argument3 = arg3;
	      if (flag3 == true) {
	        argument3 = msgCat.get(arg3);
	      }
	    }

	    if (arg4 != null) {
	      argument4 = arg4;
	      if (flag4 == true) {
	        argument4 = msgCat.get(arg4);
	      }
	    }
	    errorMsg = msgCat.get(errorCode, argument1, argument2, argument3, argument4);
	    //String args[] = {
	    //    argument1, argument2, argument3, argument4};
	    //java.text.MessageFormat formatter = new java.text.MessageFormat("");
	    //formatter.applyPattern(msg);
	    //errorMsg = formatter.format(args);
	    if (errorMsg == null) {
	      //NPC0003: Message ${1} not found.
	      errorMsg = msgCat.get("NPC0003E", errorCode);
	    }
	    return errorMsg;

	  }

	  public void setErrorMsg(String noNeedToConvertErrMsg) {
	    errorMsg = noNeedToConvertErrMsg;
	  }

	  public String getErrorMsg(Locale locale) {
	    return (this.getErrorMsg(locale, this.errorCode));
	  }

	  public void addExceptionInList(YHException npcEx) {
	    if (this.YHExceptionList == null) {
	      YHExceptionList = new LinkedList<YHException>();
	    }
	    YHExceptionList.add(npcEx);
	  }

	  public int getNumOfExcInList(){
	    if (this.YHExceptionList == null)
	      return 0;
	    else
	      return this.YHExceptionList.size();
	  }

	  public String getSOAPDataValErrMsg(java.util.Locale locale) {
	    YHException npcEx = null;
	    if (YHExceptionList == null) {
	      npcEx = new YHException("NPC0001E", "getSOAPDataValErrMsg: list is empty");
	      return npcEx.getErrorMsg(locale);
	    }

	    npcEx = new YHException(errorCode);

	    errorMsg = npcEx.getErrorMsg(locale);

	    ListIterator iter = YHExceptionList.listIterator();
	    while (iter.hasNext()) {
	      npcEx = (YHException) iter.next();
	      errorMsg = errorMsg +  " " + npcEx.getErrorMsg(locale) + ";";
	    }

	    return errorMsg;
	  }

	  public String getGUIDataValErrMsg(java.util.Locale locale, String errorCode) {
	    YHException npcEx = null;
	    if (YHExceptionList == null) {
	      npcEx = new YHException("NPC0001E", "getGUIDataValErrMsg: list is empty");
	      return npcEx.getErrorMsg(locale);
	    }

	    npcEx = new YHException(errorCode);


	    //errorMsg = npcEx.getErrorMsg(locale);
	    arg1 = "";

	    ListIterator iter = YHExceptionList.listIterator();
	    boolean isFirst = true;
	    while (iter.hasNext()) {
	      npcEx = (YHException) iter.next();

	      if (isFirst) {
	        arg1 = arg1 + npcEx.getErrorMsg(locale);
	        isFirst = false;
	      }
	      else {
	        //NPC3018E: , comma seperator
	        arg1 = arg1 + this.getErrorMsg(locale, "NPC3018E")
	            + " " + npcEx.getErrorMsg(locale);
	      }

	    }

	    flag1 = false;
	    errorMsg = this.getErrorMsg(locale, errorCode);
	    return errorMsg;
	  }

	

}
