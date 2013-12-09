package com.evernote.clients;

import com.evernote.edam.error.EDAMNotFoundException;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.type.LinkedNotebook;
import com.evernote.edam.type.Notebook;
import com.evernote.thrift.TException;

import java.util.List;

/**
 * Interface specifying a set of {@link BusinessNoteStoreClient} operations.
 *
 * @author Tadaya Tsuyukubo
 */
public interface BusinessNoteStoreClientOperations extends LinkedNoteStoreClientOperations {

    LinkedNotebook createNotebook(Notebook notebook) throws TException,
            EDAMUserException, EDAMSystemException, EDAMNotFoundException;

    /**
     * Helper method to list business notebooks synchronously
     *
     * @return
     * @throws EDAMUserException
     * @throws EDAMSystemException
     * @throws TException
     * @throws EDAMNotFoundException
     */
    List<LinkedNotebook> listNotebooks() throws EDAMUserException,
            EDAMSystemException, TException, EDAMNotFoundException;


}
