//Exercise 1: Implementing the Singleton Pattern
public class Ex1Logger {

    private static Ex1Logger instance;

    private Ex1Logger() {
        System.out.println("Logger instance created.");
    }

    public static Ex1Logger getInstance() {
        if (instance == null) {
            instance = new Ex1Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}