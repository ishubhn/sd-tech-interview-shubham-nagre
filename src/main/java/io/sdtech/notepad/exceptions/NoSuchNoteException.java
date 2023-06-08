package io.sdtech.notepad.exceptions;

public class NoSuchNoteException extends RuntimeException {
    public NoSuchNoteException(String s) {
        super(s);
    }
}
