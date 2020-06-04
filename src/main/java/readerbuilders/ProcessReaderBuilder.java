package readerbuilders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessReaderBuilder implements IReaderBuilder {
    private static final Logger log = Logger.getLogger(ProcessReaderBuilder.class.getName());

    @Override
    public BufferedReader getNewBufferedReader(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream processInputStream = process.getInputStream();
            return new BufferedReader(new InputStreamReader(processInputStream));
        } catch (IOException e) {
            log.log(Level.SEVERE, "Incorrect instruction");
            return null;
        }
    }
}
