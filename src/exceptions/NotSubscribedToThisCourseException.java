package exceptions;

public class NotSubscribedToThisCourseException extends Exception {
    public NotSubscribedToThisCourseException(){
        super("This student is not subscribed to this course.");
    }
}
