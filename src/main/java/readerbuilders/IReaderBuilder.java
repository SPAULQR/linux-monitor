package readerbuilders;

import java.io.BufferedReader;

public interface IReaderBuilder {
    BufferedReader getNewBufferedReader(String command);
}
