package readerbuilders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaderBuilder implements IReaderBuilder {
    private static final Logger log = Logger.getLogger(FileReaderBuilder.class.getName());

    @Override
    public BufferedReader getNewBufferedReader(String command) {
        try {
            return new BufferedReader(new FileReader(command));
        } catch (FileNotFoundException e) {
            log.log(Level.SEVERE, "Wrong file directory");
            return null;
        }
    }
}
