package com.evernote.clients;

import com.evernote.edam.error.EDAMNotFoundException;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.type.PremiumInfo;
import com.evernote.edam.type.User;
import com.evernote.edam.userstore.AuthenticationResult;
import com.evernote.edam.userstore.BootstrapInfo;
import com.evernote.edam.userstore.PublicUserInfo;
import com.evernote.thrift.TException;

/**
 * Interface specifying a basic of {@link UserStoreClient} operations.
 *
 * @author Tadaya Tsuyukubo
 */
public interface UserStoreClientOperations {

    /**
     * Determine if a user belongs to a business account
     *
     * @return the result of a user belonging to a business account
     */
    boolean isBusinessUser() throws TException, EDAMUserException,
            EDAMSystemException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#checkVersion(String, short, short)
     */
    boolean checkVersion(final String clientName,
                         final short edamVersionMajor, final short edamVersionMinor)
            throws TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#getBootstrapInfo(String)
     */
    BootstrapInfo getBootstrapInfo(final String locale) throws TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#authenticate(String, String, String, String, boolean)
     */
    AuthenticationResult authenticate(final String username,
                                      final String password, final String consumerKey,
                                      final String consumerSecret, final boolean supportsTwoFactor)
            throws EDAMUserException, EDAMSystemException, TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#authenticateLongSession(String, String, String,
     *      String, String, String, boolean)
     */
    AuthenticationResult authenticateLongSession(final String username,
                                                 final String password, final String consumerKey,
                                                 final String consumerSecret, final String deviceIdentifier,
                                                 final String deviceDescription, final boolean supportsTwoFactor)
            throws EDAMUserException, EDAMSystemException, TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#authenticateToBusiness(String)
     */
    AuthenticationResult authenticateToBusiness()
            throws EDAMUserException, EDAMSystemException, TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#refreshAuthentication(String)
     */
    AuthenticationResult refreshAuthentication() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#getUser(String)
     */
    User getUser() throws EDAMUserException, EDAMSystemException,
            TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#getPublicUserInfo(String)
     */
    PublicUserInfo getPublicUserInfo(final String username)
            throws EDAMNotFoundException, EDAMSystemException, EDAMUserException,
            TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#getPremiumInfo(String)
     */
    PremiumInfo getPremiumInfo() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#getNoteStoreUrl(String)
     */
    String getNoteStoreUrl() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#revokeLongSession(String)
     */
    void revokeLongSession() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see com.evernote.edam.userstore.UserStore.Client#completeTwoFactorAuthentication(String, String,
     *      String, String)
     */
    void completeTwoFactorAuthentication(final String authenticationToken,
                                         final String oneTimeCode, final String deviceIdentifier,
                                         final String deviceDescription) throws EDAMUserException,
            EDAMSystemException, TException;

}
