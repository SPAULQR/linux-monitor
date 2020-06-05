package parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import readerbuilders.FileReaderBuilder;
import readerbuilders.IReaderBuilder;

import java.util.List;

public class BufferedReaderParserTest {
    private IReaderBuilder builder = new FileReaderBuilder();
    private IBufferedReaderParser parser = new BufferedReaderParser(builder, "src/test/resources/cpu_test_data.txt");

    @Test
    public void testParserNotNull() {
        List<String> requestedList = parser.getSystemData();
        Assertions.assertNotNull(requestedList);
    }
}
