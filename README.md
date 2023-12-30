## Usage
```java
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String pythonCode = "print('Hello from Python code!')";

        try {
            PyLangManager.runPythonCode(pythonCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
