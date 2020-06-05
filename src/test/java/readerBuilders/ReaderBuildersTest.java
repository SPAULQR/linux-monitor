package readerBuilders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import readerbuilders.FileReaderBuilder;
import readerbuilders.IReaderBuilder;
import readerbuilders.ProcessReaderBuilder;

import java.io.BufferedReader;
import java.io.IOException;

public class ReaderBuildersTest {
    private IReaderBuilder builder;
    private BufferedReader reader;
    private String firstLine;

    @Test
    public void rightLinuxCommandTest() throws IOException {
        builder = new ProcessReaderBuilder();
        reader = builder.getNewBufferedReader("mpstat -P ALL");
        firstLine = reader.readLine();
        Assertions.assertTrue(firstLine.contains("Linux"));
    }

    @Test
    public void wrongLinuxCommandTest() {
        builder = new ProcessReaderBuilder();
        reader = builder.getNewBufferedReader("wrong -P COMMAND");
        Assertions.assertThrows(NullPointerException.class,
                () -> firstLine = reader.readLine());
    }

    @Test
    public void fileReaderBuilderTest() throws IOException {
        builder = new FileReaderBuilder();
        reader = builder.getNewBufferedReader("src/test/resources/cpu_test_data.txt");
        firstLine = reader.readLine();
        Assertions.assertTrue(firstLine.contains("Linux"));
    }

    @Test
    public void wrongFileDirectoryTest() {
        builder = new FileReaderBuilder();
        reader = builder.getNewBufferedReader("src/test/wrong/directory.txt");
        Assertions.assertThrows(NullPointerException.class,
                () -> firstLine = reader.readLine());
    }
}
