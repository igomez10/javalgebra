//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.junit.jupiter:junit-jupiter-api:5.10.1
//DEPS org.junit.jupiter:junit-jupiter-engine:5.10.1
//DEPS org.junit.platform:junit-platform-console:1.9.2

//SOURCES main.java
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.platform.console.ConsoleLauncher;
import static java.lang.System.*;

public class TestLauncher {

    @Test
    void testShouldFail() {
        Assertions.assertEquals(1, 3);
    }

    @Test
    @DisplayName("First number is less than the second")
    void testMatrixToString() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9));
        String result = main.matrixToString(matrix);
        String expected = """
                1  2   3
                4  5   6
                7  8   9
                """;
        Assertions.assertEquals(expected, result);
        if (expected.length() != result.length()) {
            out.println("unexpected length");
        }
        for (int i = 0; i < expected.length(); i++) {
            if (expected.charAt(i) != result.charAt(i)) {
                out.printf("unexpected char at ", i);
            }
        }
    }

    public static void main(String[] args) {
        // Pass arguments to ConsoleLauncher to run the specific test class
        ConsoleLauncher.main(new String[] {
                "--select-class", "TestLauncher",
                "--details=tree"
        });
    }
}
