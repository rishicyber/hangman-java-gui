public class WrongInputException extends RuntimeException {
    WrongInputException() {
        System.out.println("Please provide a single character only..!!");
    }
}
