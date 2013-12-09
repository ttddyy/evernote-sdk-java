package com.evernote.clients;

import com.evernote.edam.notestore.NoteStoreIface;
import com.evernote.edam.userstore.UserStoreIface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.fail;

/**
 * @author Tadaya Tsuyukubo
 */
@RunWith(Parameterized.class)
public class WrappedMethodTest {

    private Class<?> original;
    private Class<?> wrapped;
    private String[] methodNamesToIgnore;

    public WrappedMethodTest(Class<?> original, Class<?> wrapped, String[] methodNamesToIgnore) {
        this.original = original;
        this.wrapped = wrapped;
        this.methodNamesToIgnore = methodNamesToIgnore;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // original class, wrapped class, method names to ignore
                {NoteStoreIface.class, NoteStoreClient.class, new String[]{}},
                {UserStoreIface.class, UserStoreClient.class, new String[]{}},
                {NoteStoreClient.class, NoteStoreClientOperations.class, new String[]{"getToken"}},
                {UserStoreClient.class, UserStoreClientOperations.class, new String[]{"getClient", "getToken"}},
                {LinkedNoteStoreClient.class, LinkedNoteStoreClientOperations.class,
                        new String[]{"getPersonalClient", "getAuthenticationResult", "getToken"}},
                {BusinessNoteStoreClient.class, BusinessNoteStoreClientOperations.class, new String[]{}}
        });
    }


    @Test
    public void testWrappedMethods() {
        Method[] originalMethods = this.original.getDeclaredMethods();
        Method[] wrappedMethods = this.wrapped.getDeclaredMethods();

        Set<String> originalMethodNames = new HashSet<String>();
        for (Method m : originalMethods) {
            originalMethodNames.add(m.getName());
        }

        for (Method m : wrappedMethods) {
            originalMethodNames.remove(m.getName());
        }

        originalMethodNames.removeAll(Arrays.asList(this.methodNamesToIgnore));

        if (!originalMethodNames.isEmpty()) {
            fail("Following methods are not implemented in " + this.wrapped.getName()
                    + ": " + originalMethodNames.toString());
        }
    }

}
