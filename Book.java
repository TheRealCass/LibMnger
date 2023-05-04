/**
 * Class Name: Book
 * 
 * DESCRIPTION: holds data and info for a book in a library
 * 
 * @author   Rubait Ul Ahamed
 * @version 3.0
 */
class Book{

    //book info
    private String title;
    private String authorFirstName;
    private String authorLastName;

    private boolean onLoan;

    private final boolean DEBUG = false;

    /**
     * constructor
     * @param lastName
     * @param firstName
     * @param title
     */
    public Book(String lastName, String firstName, String title){

        this.title = title;
        authorFirstName = firstName;
        authorLastName = lastName;
        onLoan = false;


    }


    /**
     * getStatus
     * finds out if the book is in house or on loan.
     * 
     * @return (boolean) the onLoad variable
     */
    public boolean getStatus(){
        return this.onLoan;
    }


    /**
     * etTitle
     * 
     * @return (String) the title of the book
     */
    public String getTitle() {
        return this.title;
    }


    /**
     * getAuthorFirstName
     * 
     * @return {String} the first name of the author
     */
    public String getAuthorFirstName() {
        return this.authorFirstName;
    }


    /**
     * getAuthorLastName
     * 
     * @return {String} the author's last name
     */
    public String getAuthorLastName() {
        return this.authorLastName;
    }


    /**
     * getInitials
     * 
     * @return (String) the initial of the author
     *          Ex- Gaimen, Neil
     */
    public String getInitials(){
        String toReturn = "";
        toReturn += getAuthorLastName();
        toReturn += ", " + getAuthorFirstName();
        return toReturn;
    }


    /**
     * giveOnLoan
     * sets the boolean flag onLoad to true
     */
    public void giveOnLoan(){
        onLoan = true;
        if (DEBUG)
            System.out.println("Book loaned:\n" + toString());
    }


    /**
     * recieveBook
     * sets the boolean flag onLoad to false
     */
    public void recieveBook(){
        onLoan = false;
        if (DEBUG)
            System.out.println("Book returned:\n" + toString());
    }


    /**
     * Method Name: toString
     *
     * @return {String} returns the title, authors initals and weather it's on loan or not
     *                  Ex- "American Gods" - Gaimen, Neil(inLibrary/onLoan)
     */
    @Override
    public String toString(){
        String toReturn = getInitials();
        toReturn += ", " + getTitle();
        toReturn += "(";
            if(onLoan){
                toReturn += "onLoan";
            } else {
                toReturn += "inLibrary";
            }
        toReturn += ")";
        return toReturn;
    }

}