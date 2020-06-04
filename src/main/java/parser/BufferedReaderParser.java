package parser;

import readerbuilders.IReaderBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BufferedReaderParser implements IBufferedReaderParser {
    private final IReaderBuilder builder;
    private final String command;
    private static final Logger log = Logger.getLogger(BufferedReaderParser.class.getName());

    public BufferedReaderParser(IReaderBuilder builder, String command) {
        this.builder = builder;
        this.command = command;
    }

    @Override
    public List<String> getSystemData() {
        String currentLine;
        List<String> listInfo = new ArrayList<>();
        try (BufferedReader reader = builder.getNewBufferedReader(command)) {
            while ((currentLine = reader.readLine()) != null) {
                listInfo.add(currentLine);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
        return listInfo;
    }
}
