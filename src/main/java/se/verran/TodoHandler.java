package se.verran;

import java.util.HashMap;

public class TodoHandler {
    private final HashMap<String, String> notes = new HashMap<>();
    private final int numOfNotesLimitation;
    private final int noteSubjectLengthLimit;
    private final int noteContentLengthLimit;

    public TodoHandler(int numOfNotesLimit, int noteSubjectLengthLimit, int noteContentLengthLimit) {
        this.numOfNotesLimitation = numOfNotesLimit;
        this.noteSubjectLengthLimit = noteSubjectLengthLimit;
        this.noteContentLengthLimit = noteContentLengthLimit;
    }

    public String saveNote(String subject, String content) {
        notes.put(subject, content);
        return "Note with subject \"" + subject + "\" added!" + (notes.size() == numOfNotesLimitation ? " Memory full!" : "");
    }

    public boolean checkForSubjectConflict(String subject) {
        return (notes.containsKey(subject));
    }

    public boolean checkForInvalidContentLength(String content) {
        return (content.isEmpty()||content.length()> noteContentLengthLimit);
    }

    public void verifyAvailableMemory() {
        if(!(notes.size() < numOfNotesLimitation)){
            throw new MemoryFullException("Memory is full, you can't add notes until you have removed some of the old crappy ones!");
        }
    }

    public boolean checkForInvalidSubjectLength(String subject) {
        return subject.isEmpty() || subject.length() > noteSubjectLengthLimit;
    }

    public HashMap<String, String> getNotes() {
        return notes;
    }

    public int getNoteSubjectLengthLimit() {
        return noteSubjectLengthLimit;
    }

    public int getNoteContentLengthLimit() {
        return noteContentLengthLimit;
    }
}