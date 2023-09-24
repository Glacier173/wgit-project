import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommitTest {
private Commit commit;
    @BeforeEach
    public void setUp() throws IOException {
        // Initialize a new Commit object for each test case
        commit = new Commit("Test Summary", "Test Author", "");
    }
    @Test
    void testCreateTree() throws IOException {
        commit.createTree();
        String shaOfTree = commit.getShaOfTree();
        assertTrue(shaOfTree != null && !shaOfTree.isEmpty());
    }

    @Test
    void testGenSha1() throws IOException {
        String sha1 = commit.genSha1();
        assertTrue(sha1.matches("[a-f0-9]+") && sha1.length() == 40);
    }

    @Test
    void testGetDate() {
        Calendar date = GregorianCalendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date.getTime());
        assertEquals(formattedDate, commit.getDate());
    }

    @Test
    void testGetShaOfTree() {
        String shaOfTree = commit.getShaOfTree();
        assertTrue(shaOfTree != null && !shaOfTree.isEmpty());
    }

    @Test
    void testHashString() {
        String input = "TestInput";
        String expectedHash = "94ee059335e587e501cc4bf90613e0814c2a48ae1"; // SHA-1 hash of "TestInput"
        String actualHash = Commit.hashString(input);
        assertEquals(expectedHash, actualHash);
    }
}
