//Exercise 1: Implementing the Singleton Pattern
public class Ex1SingletonTest {

    public static void main(String[] args) {

        Ex1Logger logger1 = Ex1Logger.getInstance();
        Ex1Logger logger2 = Ex1Logger.getInstance();
        Ex1Logger logger3 = Ex1Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("User logged in.");
        logger3.log("Data fetched successfully.");

        System.out.println("\n--- Instance Verification ---");
        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));
        System.out.println("All three point to same instance: " + (logger1 == logger2 && logger2 == logger3));

        System.out.println("\nHashCodes:");
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        System.out.println("logger3 hashCode: " + logger3.hashCode());
    }
}