package com.evernote.clients;

import com.evernote.edam.error.EDAMNotFoundException;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.type.LinkedNotebook;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.Notebook;
import com.evernote.thrift.TException;

import java.util.List;

/**
 * Interface specifying a set of {@link LinkedNoteStoreClient} operations.
 *
 * @author Tadaya Tsuyukubo
 */
public interface LinkedNoteStoreClientOperations {

    NoteStoreClient getClient();

    /**
     * Helper method to create a note in a linked notebook
     *
     * @param note
     * @param linkedNotebook
     * @return
     * @throws com.evernote.edam.error.EDAMUserException
     *
     * @throws com.evernote.edam.error.EDAMSystemException
     *
     * @throws com.evernote.thrift.TException
     * @throws com.evernote.edam.error.EDAMNotFoundException
     *
     */
    Note createNote(Note note, LinkedNotebook linkedNotebook)
            throws EDAMUserException, EDAMSystemException, TException,
            EDAMNotFoundException;

    /**
     * Helper method to list linked notebooks
     *
     * @see {@link com.evernote.edam.notestore.NoteStore.Client#listLinkedNotebooks(String)}
     */
    List<LinkedNotebook> listNotebooks() throws EDAMUserException,
            EDAMSystemException, TException, EDAMNotFoundException;

    /**
     * Will return the {@link com.evernote.edam.type.Notebook} associated with the
     * {@link com.evernote.edam.type.LinkedNotebook} from the linked account
     *
     * @param linkedNotebook
     */
    Notebook getCorrespondingNotebook(LinkedNotebook linkedNotebook)
            throws TException, EDAMUserException, EDAMSystemException,
            EDAMNotFoundException;

    /**
     * Checks writable permissions of {@link LinkedNotebook} on Linked account
     *
     * @param linkedNotebook
     */
    boolean isNotebookWritable(LinkedNotebook linkedNotebook)
            throws EDAMUserException, TException, EDAMSystemException,
            EDAMNotFoundException;

}
