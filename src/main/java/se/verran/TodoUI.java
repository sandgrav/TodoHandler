package se.verran;

public class TodoUI {
    private TodoHandler todoHandler;

    public TodoUI(TodoHandler todoHandler) {
        this.todoHandler = todoHandler;
    }

    public String addNote(String subject, String content) {
        todoHandler.verifyAvailableMemory();
        if (todoHandler.checkForInvalidSubjectLength(subject))
            return "Subject length doesn't follow the restrictions of (1-" + todoHandler.getNoteSubjectLengthLimit() + ")!";

        if (todoHandler.checkForInvalidContentLength(content))
            return "Content length doesn't follow the restrictions of (1-" + todoHandler.getNoteContentLengthLimit() + ")!";

        if (todoHandler.checkForSubjectConflict(subject))
            return "Conflict detected, choose another subject!";

        return todoHandler.saveNote(subject, content);
    }

/*    public String deleteNote(String subject){
        if(!notes.containsKey(subject)){
            return "Did not find a note by that subject!";
        }
        notes.remove(subject);
        return "Note with subject \"" + subject + "\" deleted!";
    }*/
}
