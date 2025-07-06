import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws Exception {
        // Insecure: Reads a command from user input and executes it
        System.out.println("Enter a shell command to execute:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        // Command injection vulnerability
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = output.readLine()) != null) {
            System.out.println(line);
        }
        output.close();
    }
}