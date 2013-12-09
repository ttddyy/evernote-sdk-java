package com.evernote.clients;

import com.evernote.edam.error.EDAMNotFoundException;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.notestore.*;
import com.evernote.edam.type.*;
import com.evernote.edam.userstore.AuthenticationResult;
import com.evernote.thrift.TException;

import java.util.List;

/**
 * Interface specifying a basic of {@link NoteStoreClient} operations.
 *
 * @author Tadaya Tsuyukubo
 */
public interface NoteStoreClientOperations {

    /**
     * If direct access to the Note Store is needed, all of these calls are
     * synchronous
     *
     * @return {@link com.evernote.edam.notestore.NoteStore.Client}
     */
    NoteStore.Client getClient();

    /**
     * @see NoteStore.Client#getSyncState(String)
     */
    SyncState getSyncState() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see NoteStore.Client##getSyncStateWithMetrics(com.evernote.edam.notestore
     *      .ClientUsageMetrics, OnClientCallback)
     */
    SyncState getSyncStateWithMetrics(ClientUsageMetrics clientMetrics)
            throws EDAMUserException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#getSyncChunk(String, int, int, boolean)
     */
    SyncChunk getSyncChunk(int afterUSN, int maxEntries,
                           boolean fullSyncOnly) throws EDAMUserException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#getFilteredSyncChunk(String, int, int,
     *      com.evernote.edam.notestore.SyncChunkFilter)
     */
    SyncChunk getFilteredSyncChunk(int afterUSN, int maxEntries,
                                   SyncChunkFilter filter) throws EDAMUserException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#getLinkedNotebookSyncState(String,
     *      com.evernote.edam.type.LinkedNotebook)
     */
    SyncState getLinkedNotebookSyncState(LinkedNotebook linkedNotebook)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @return
     * @see NoteStore.Client#getLinkedNotebookSyncChunk(String,
     *      com.evernote.edam.type.LinkedNotebook, int, int, boolean)
     */
    SyncChunk getLinkedNotebookSyncChunk(LinkedNotebook linkedNotebook,
                                         int afterUSN, int maxEntries, boolean fullSyncOnly)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#listNotebooks(String)
     */
    List<Notebook> listNotebooks() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#getNotebook(String, String)
     */
    Notebook getNotebook(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getDefaultNotebook(String)
     */
    Notebook getDefaultNotebook() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#createNotebook(String,
     *      com.evernote.edam.type.Notebook)
     */
    Notebook createNotebook(Notebook notebook) throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#updateNotebook(String,
     *      com.evernote.edam.type.Notebook)
     */
    int updateNotebook(Notebook notebook) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#expungeNotebook(String, String)
     */
    int expungeNotebook(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#listTags(String)
     */
    List<Tag> listTags() throws EDAMUserException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#listTagsByNotebook(String, String)
     */
    List<Tag> listTagsByNotebook(String notebookGuid)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#getTag(String, String)
     */
    Tag getTag(String guid) throws EDAMUserException, EDAMSystemException,
            EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#createTag(String, com.evernote.edam.type.Tag)
     */
    Tag createTag(Tag tag) throws EDAMUserException, EDAMSystemException,
            EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#updateTag(String, com.evernote.edam.type.Tag)
     */
    int updateTag(Tag tag) throws EDAMUserException, EDAMSystemException,
            EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#untagAll(String, String)
     */
    void untagAll(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#expungeTag(String, String)
     */
    int expungeTag(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#listSearches(String)
     */
    List<SavedSearch> listSearches() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#getSearch(String, String)
     */
    SavedSearch getSearch(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#createSearch(String,
     *      com.evernote.edam.type.SavedSearch)
     */
    SavedSearch createSearch(SavedSearch search) throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#updateSearch(String,
     *      com.evernote.edam.type.SavedSearch)
     */
    int updateSearch(SavedSearch search) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#expungeSearch(String, String)
     */
    int expungeSearch(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#findNotes(String,
     *      com.evernote.edam.notestore.NoteFilter, int, int)
     */
    NoteList findNotes(NoteFilter filter, int offset, int maxNotes)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#findNoteOffset(String,
     *      com.evernote.edam.notestore.NoteFilter, String)
     */
    int findNoteOffset(NoteFilter filter, String guid)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#findNotesMetadata(String,
     *      com.evernote.edam.notestore.NoteFilter, int, int,
     *      com.evernote.edam.notestore.NotesMetadataResultSpec)
     */
    NotesMetadataList findNotesMetadata(NoteFilter filter, int offset,
                                        int maxNotes, NotesMetadataResultSpec resultSpec)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#findNoteCounts(String,
     *      com.evernote.edam.notestore.NoteFilter, boolean)
     */
    NoteCollectionCounts findNoteCounts(NoteFilter filter,
                                        boolean withTrash) throws EDAMUserException, EDAMSystemException,
            EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getNote(String, String, boolean, boolean, boolean,
     *      boolean)
     */
    Note getNote(String guid, boolean withContent,
                 boolean withResourcesData, boolean withResourcesRecognition,
                 boolean withResourcesAlternateData) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getNoteApplicationData(String, String)
     */
    LazyMap getNoteApplicationData(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getNoteApplicationDataEntry(String, String, String)
     */
    String getNoteApplicationDataEntry(String guid, String key)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#setNoteApplicationDataEntry(String, String, String,
     *      String)
     */
    int setNoteApplicationDataEntry(String guid, String key, String value)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#unsetNoteApplicationDataEntry(String, String, String)
     */
    int unsetNoteApplicationDataEntry(String guid, String key)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#getNoteContent(String, String)
     */
    String getNoteContent(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getNoteSearchText(String, String, boolean, boolean)
     */
    String getNoteSearchText(String guid, boolean noteOnly,
                             boolean tokenizeForIndexing) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getResourceSearchText(String, String)
     */
    String getResourceSearchText(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getNoteTagNames(String, String)
     */
    List<String> getNoteTagNames(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#createNote(String, com.evernote.edam.type.Note)
     */
    Note createNote(Note note) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#updateNote(String, com.evernote.edam.type.Note)
     */
    Note updateNote(Note note) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#deleteNote(String, String)
     */
    int deleteNote(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#expungeNote(String, String)
     */
    int expungeNote(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#expungeNotes(String, java.util.List)
     */
    int expungeNotes(List<String> noteGuids) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#expungeInactiveNotes(String)
     */
    int expungeInactiveNotes() throws EDAMUserException,
            EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#copyNote(String, String, String)
     */
    Note copyNote(String noteGuid, String toNotebookGuid)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#listNoteVersions(String, String)
     */
    List<NoteVersionId> listNoteVersions(String noteGuid)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#getNoteVersion(String, String, int, boolean, boolean,
     *      boolean)
     */
    Note getNoteVersion(String noteGuid, int updateSequenceNum,
                        boolean withResourcesData, boolean withResourcesRecognition,
                        boolean withResourcesAlternateData) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getResource(String, String, boolean, boolean,
     *      boolean, boolean)
     */
    Resource getResource(String guid, boolean withData,
                         boolean withRecognition, boolean withAttributes, boolean withAlternateData)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#getResourceApplicationData(String, String)
     */
    LazyMap getResourceApplicationData(String guid)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#getResourceApplicationDataEntry(String, String,
     *      String)
     */
    String getResourceApplicationDataEntry(String guid, String key)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#setResourceApplicationDataEntry(String, String,
     *      String, String)
     */
    int setResourceApplicationDataEntry(String guid, String key,
                                        String value) throws EDAMUserException, EDAMSystemException,
            EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#unsetResourceApplicationDataEntry(String, String,
     *      String)
     */
    int unsetResourceApplicationDataEntry(String guid, String key)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#updateResource(String,
     *      com.evernote.edam.type.Resource)
     */
    int updateResource(Resource resource) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getResourceData(String, String)
     */
    byte[] getResourceData(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getResourceByHash(String, String, byte[], boolean,
     *      boolean, boolean)
     */
    Resource getResourceByHash(String noteGuid, byte[] contentHash,
                               boolean withData, boolean withRecognition, boolean withAlternateData)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#getResourceRecognition(String, String)
     */
    byte[] getResourceRecognition(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getResourceAlternateData(String, String)
     */
    byte[] getResourceAlternateData(String guid) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#getResourceAttributes(String, String)
     */
    ResourceAttributes getResourceAttributes(String guid)
            throws EDAMUserException, EDAMSystemException, EDAMNotFoundException,
            TException;

    /**
     * @see NoteStore.Client#getPublicNotebook(int, String)
     */
    Notebook getPublicNotebook(int userId, String publicUri)
            throws EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#createSharedNotebook(String,
     *      com.evernote.edam.type.SharedNotebook)
     */
    SharedNotebook createSharedNotebook(SharedNotebook sharedNotebook)
            throws EDAMUserException, EDAMNotFoundException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#updateSharedNotebook(String,
     *      com.evernote.edam.type.SharedNotebook)
     */
    int updateSharedNotebook(SharedNotebook sharedNotebook)
            throws EDAMUserException, EDAMNotFoundException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#sendMessageToSharedNotebookMembers(String, String,
     *      String, java.util.List)
     */
    int sendMessageToSharedNotebookMembers(String notebookGuid,
                                           String messageText, List<String> recipients) throws EDAMUserException,
            EDAMNotFoundException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#listSharedNotebooks(String)
     */
    List<SharedNotebook> listSharedNotebooks() throws EDAMUserException,
            EDAMNotFoundException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#expungeSharedNotebooks(String, java.util.List)
     */
    int expungeSharedNotebooks(List<Long> sharedNotebookIds)
            throws EDAMUserException, EDAMNotFoundException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#createLinkedNotebook(String,
     *      com.evernote.edam.type.LinkedNotebook)
     */
    LinkedNotebook createLinkedNotebook(LinkedNotebook linkedNotebook)
            throws EDAMUserException, EDAMNotFoundException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#updateLinkedNotebook(String,
     *      com.evernote.edam.type.LinkedNotebook)
     */
    int updateLinkedNotebook(LinkedNotebook linkedNotebook)
            throws EDAMUserException, EDAMNotFoundException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#listLinkedNotebooks(String)
     */
    List<LinkedNotebook> listLinkedNotebooks() throws EDAMUserException,
            EDAMNotFoundException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#expungeLinkedNotebook(String, String)
     */
    int expungeLinkedNotebook(String guid) throws EDAMUserException,
            EDAMNotFoundException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#authenticateToSharedNotebook(String, String)
     */
    AuthenticationResult authenticateToSharedNotebook(String shareKey)
            throws EDAMUserException, EDAMNotFoundException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#getSharedNotebookByAuth(String)
     */
    SharedNotebook getSharedNotebookByAuth() throws EDAMUserException,
            EDAMNotFoundException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#emailNote(String,
     *      com.evernote.edam.notestore.NoteEmailParameters)
     */
    void emailNote(NoteEmailParameters parameters)
            throws EDAMUserException, EDAMNotFoundException, EDAMSystemException,
            TException;

    /**
     * @see NoteStore.Client#shareNote(String, String)
     */
    String shareNote(String guid) throws EDAMUserException,
            EDAMNotFoundException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#stopSharingNote(String, String)
     */
    void stopSharingNote(String guid) throws EDAMUserException,
            EDAMNotFoundException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#authenticateToSharedNote(String, String)
     */
    AuthenticationResult authenticateToSharedNote(String guid,
                                                  String noteKey, String authenticationToken) throws EDAMUserException,
            EDAMNotFoundException, EDAMSystemException, TException;

    /**
     * @see NoteStore.Client#findRelated(String,
     *      com.evernote.edam.notestore.RelatedQuery,
     *      com.evernote.edam.notestore.RelatedResultSpec)
     */
    RelatedResult findRelated(RelatedQuery query,
                              RelatedResultSpec resultSpec) throws EDAMUserException,
            EDAMSystemException, EDAMNotFoundException, TException;

    /**
     * @see NoteStore.Client#setSharedNotebookRecipientSettings(String, long,
     *      SharedNotebookRecipientSettings)
     */
    void setSharedNotebookRecipientSettings(
            final String authenticationToken, final long sharedNotebookId,
            final SharedNotebookRecipientSettings recipientSettings)
            throws EDAMUserException, EDAMNotFoundException, EDAMSystemException,
            TException;

}
