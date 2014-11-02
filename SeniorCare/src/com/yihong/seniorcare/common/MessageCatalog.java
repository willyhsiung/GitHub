package com.yihong.seniorcare.common;

/**
 * Generate Type
 */
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;


public class MessageCatalog {
  static String defaultMessageBundle = "MessageCatalog";

  ResourceBundle messages = null;
  static ProductProperties productProperties = new ProductProperties();
  /**
   * MessageCatalog constructor comment.
   */
  public MessageCatalog() {
	
    this(defaultMessageBundle, productProperties.getLocale());
  }

  /**
   * MessageCatalog constructor comment.
   */
  public MessageCatalog(String messageBundle) {
    this(messageBundle, productProperties.getLocale());
  }

  /**
   * MessageCatalog constructor comment.
   */
  public MessageCatalog(String messageBundle, Locale locale) {
    if (messageBundle != null) {
      try {
        messages = ResourceBundle.getBundle(messageBundle, locale);
      }
      catch (MissingResourceException ex) {
        System.err.println("MessageCatalog: Unable to find resource: " +
                           messageBundle + " locale:" + locale);
      }
    }
  }

  /**
   * MessageCatalog constructor comment.
   */
  public MessageCatalog(Locale locale) {
    this(defaultMessageBundle, locale);
  }

  public boolean isMessageFound(String messageId) {
    if (get(messageId) == null) {
      return false;
    }
    else {
      return true;
    }
  }

// return null if message not found in catalog
//
  public String get(String messageId) {
    String message = null;

    try {
      String lang = messages.getLocale().getLanguage();
      //String msg = messages.getString("login.title");
      message = messages.getString(messageId);

    }
    catch (java.util.MissingResourceException ex) {

      message = null;

    }

    return message;
  }

// return null if message not found in catalog
//
  public String get(String messageId, String arg1) {
    return get(messageId, arg1, "?", "?", "?");
  }

// return null if message not found in catalog
//
  public String get(String messageId, String arg1, String arg2) {
    return get(messageId, arg1, arg2, "?", "?");
  }

// return null if message not found in catalog
//
  public String get(String messageId, String arg1, String arg2, String arg3) {
    return get(messageId, arg1, arg2, arg3, "?");
  }

// return null if message not found in catalog
//
  public String get(String messageId, String arg1, String arg2, String arg3,
                    String arg4) {
    String message = null;

    message = get(messageId);
    if (message != null ) {

      message = replaceSubstring(message, "${1}", arg1);
      message = replaceSubstring(message, "${2}", arg2);
      message = replaceSubstring(message, "${3}", arg3);
      message = replaceSubstring(message, "${4}", arg4);
    }

    return message;
  }

// return null if message not found in catalog
//
  public String getRaw(String messageId) {
    return get(messageId, "${1}", "${2}", "${3}", "${4}");
  }

// Replaces every occurrence of 'from' to 'to' in 'message'
//
  protected static String replaceSubstring(String message,
                                           String from, String to) {
    StringBuffer result = new StringBuffer("");

    int oldIdx = 0;
    int newIdx = 0;
    int fromLen = from.length();

    while ( (newIdx = message.indexOf(from, oldIdx)) != -1) {
      result.append(message.substring(oldIdx, newIdx) + to);
      oldIdx = newIdx + fromLen;
    }
    result.append(message.substring(oldIdx));

    return result.toString();
  }
}
