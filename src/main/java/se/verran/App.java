package se.verran;

public class App 
{
    public static void main( String[] args )
    {
        // TodoHandler is the brain
        TodoHandler todoHandler = new TodoHandler(5, 20, 45);

        // TodoUI is the language user interface
        TodoUI todoUI = new TodoUI(todoHandler);

        // Lets add some notes
        System.out.println(todoUI.addNote("In case of emergency", "1. git commit 2. git push 3. leave building"));
        System.out.println(todoUI.addNote("Car maintenance", "Oil and oil filter change"));
        System.out.println(todoUI.addNote("Food", "For the dog, for the cat (allergenic)"));
        System.out.println(todoUI.addNote("School", "I'm too school for cool"));
        System.out.println(todoUI.addNote("Ischias", "Gets on my nerve"));

        // Memory will now be full
        System.out.println(todoUI.addNote("Apple", "Buy a Macintosh to impress Bill Gates"));

        // Deletes OK
//        System.out.println(todoUI.deleteNote("Food"));

        // Note added
//        System.out.println(todoUI.addNote("Apple", "Buy a Macintosh to impress Bill Gates"));

    }
}
