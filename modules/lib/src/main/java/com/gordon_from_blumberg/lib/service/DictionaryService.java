package com.gordon_from_blumberg.lib.service;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:38 020 20.06.16
 */


/**
 * Message service
 */
public interface DictionaryService {
    /**
     * Returns the text message by the specified message code
     * according to the current language
     *
     * @param messageCode Message code is the identifier of the message
     * @return Message or empty string if message is not found
     * @throws RuntimeException if the dictionary file does not exist for the current language
     */
    String getMessage(String messageCode);

    /**
     * @return Current language code
     */
    String getCurrentLanguage();

    /**
     * Sets the language
     *
     * @param language New language code
     */
    void setCurrentLanguage(String language);
}
