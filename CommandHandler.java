import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Name: AhamedShoumikA1Q1
 *
 * DESCRIPTION: taken in the input file and exectutes each line of command
 * COMP2140 Section D01 Assighnment Assightnment #1, Question #1
 * 
 * @author Rubait Ul Ahamed, 007876180
 * @version (20th May 2020)
 */

public class CommandHandler {

    //path to input file
    private final static String PATH = "Input.txt";

    //commands
    private final static String ADD_COMMAND = "ADD";
    private final static String SEARCH_BY_TITLE_COMMAND = "SEARCHT";
    private final static String SEARCH_BY_AUTHOR_COMMAND = "SEARCHA";
    private final static String BORROW_BOOK_COMMAND = "GETBOOK";
    private final static String RETURN_BOOK_COMMAND = "RETURNBOOK";

    //debug
    private static final boolean DEBUG = false;


    /**
     * Method Name: executeCommand
     * @param command line of command to execute
     * @param lib lib to execute command on
     * @return (void) taken in and executes one line of command on lib.
     *                Command ex: ADD Gaimen, Neil, American Gods
     */
    public static void executeCommand(String command, Library lib){
        Scanner scan = null;
        String instruction = "";
        String lastName = "";
        String firstName = "";
        String title = "";

        try {
            scan = new Scanner(command);
            instruction = scan.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (instruction.equals(ADD_COMMAND)) {
         
            try {
                lastName = scan.next();
                lastName = lastName.substring(0, lastName.length() - 1);
                firstName = scan.next();
                firstName = firstName.substring(0, firstName.length() - 1);
                while (scan.hasNext()){
                    title += scan.next() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(lastName);
                    System.out.println(firstName);
                    System.out.println(title);
                }
            }
            add(lib, lastName, firstName, title);
        } else if (instruction.equals(SEARCH_BY_AUTHOR_COMMAND)){
            try {
                lastName = scan.next();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(lastName);
                }
            }
            searchByAuthour(lib, lastName);
        } else if (instruction.equals(SEARCH_BY_TITLE_COMMAND)) {
            try {
                while (scan.hasNext()){
                    title += scan.next() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(title);
                }
            }
            searchByTitle(lib, title);
        } else if (instruction.equals(BORROW_BOOK_COMMAND)) {
            try {
                lastName = scan.next();
                lastName = lastName.substring(0, lastName.length() - 1);
                firstName = scan.next();
                firstName = firstName.substring(0, firstName.length() - 1);
                while (scan.hasNext()){
                    title += scan.next() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(lastName);
                    System.out.println(firstName);
                    System.out.println(title);
                }
            }
            borrowBookFromLib(lib, lastName, firstName, title);
        } else if (instruction.equals(RETURN_BOOK_COMMAND)) {
            try {
                lastName = scan.next();
                lastName = lastName.substring(0, lastName.length() - 1);
                firstName = scan.next();
                firstName = firstName.substring(0, firstName.length() - 1);
                while (scan.hasNext()){
                    title += scan.next() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(lastName);
                    System.out.println(firstName);
                    System.out.println(title);
                }
            }
            returnBookToLib(lib, lastName, firstName, title);
        }
    }


    /**
     * Method name: returnBookToLib
     * @param lib library to return book to
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the author
     * @return (void) if book part of lib, returns it to the lib
     */
    public static void returnBookToLib (Library lib, String lastName, String firstName, String title) {
        boolean result = lib.returnBook(lastName, firstName, title);
        if(!result){
            System.out.println("Book does not belong to this library");
        } 
        System.out.println("\n");
    }


    /**
     * Method name: add
     * @param lib library to add to
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the author
     * @return (void) adds book to the library
     */
    public static void add (Library lib, String lastName, String firstName, String title){
        Book temp = new Book(lastName, firstName, title);
        lib.addBook(temp);
    }


    /**
     * MEthod name: searchByAuthor
     * @param lib library to search on
     * @param lastName last name of to search by
     * @return (void) searches and prins out list of matched authors
     */
    public static void searchByAuthour (Library lib, String lastName){
        String s = lib.listByAuthor(lastName);
        System.out.print(s + "\n");
    }
    

    /**
     * Method name: searchByTitle
     * @param lib library to search on
     * @param title string to check for title
     * @return (void) searches and prins out list of matched titles
     */
    public static void searchByTitle (Library lib, String title){
        String s = lib.listByTitle(title);
        System.out.print(s + "\n");
        //formating & printingg needed
    }


    /**
     * Method name: borrowBookFromLib
     * @param lib library to borrow from
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the author
     * @return (void) loans book from lib
     */
    public static void borrowBookFromLib (Library lib, String lastName, String firstName, String title) {
        boolean result = lib.loanBook(lastName, firstName, title);
        if(!result){
            System.out.println("No Such book avalable");
        } 
        System.out.println("\n");
    }
}