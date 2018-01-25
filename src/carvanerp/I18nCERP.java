/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carvanerp;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author NaveedRaza
 */
public class I18nCERP {
    private String language = new String("en");
    private String country = new String("EN");
    private Locale currentLocale = new Locale(language, country);
    private ResourceBundle messages=ResourceBundle.getBundle("carvanerp/MessagesBundle",currentLocale);
   
    public String strGetLocale(String strKey){
        return messages.getString(strKey);
    }
}
