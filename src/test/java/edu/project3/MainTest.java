package edu.project3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() throws IOException {
        assertDoesNotThrow(() -> Main.main(new String[] {"--path",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            "--format", "adoc"}));

        assertDoesNotThrow(() -> Main.main(new String[] {"--path",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            "--format", "markdown"}));

        assertDoesNotThrow(() -> Main.main(new String[] {"--path",
            "src/main/resources/**",
            "--format", "markdown", "--from", "2023-08-31"}));

        assertDoesNotThrow(() -> Main.main(new String[] {"--path",
            "src/main/resources/**", "--from", "2013-08-31", "--to", "2023-08-31"}));

        assertTrue(new File("src/main/resources/project3/Result/report.adoc").exists());
        assertTrue(new File("src/main/resources/project3/Result/report.md").exists());
    }
}
