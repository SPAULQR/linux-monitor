package monitors;

import exceptions.NotEnoughListSizeException;
import parser.IBufferedReaderParser;

import java.util.Map;
import java.util.stream.Collectors;

public class FileSystemMonitor implements IFileSystemMonitor {
    IBufferedReaderParser parser;
    private final int requiredListSize = 2;

    public FileSystemMonitor(IBufferedReaderParser parser) {
        this.parser = parser;
    }

    public Map<String, String> getFileSystemUsage() throws NotEnoughListSizeException {
        if (parser.getSystemData().size() < requiredListSize)
            throw new NotEnoughListSizeException(requiredListSize);

        return parser.getSystemData()
                .stream()
                .skip(1)
                .collect(Collectors
                        .toMap(key -> key.split("\\s+")[0],
                                value -> value.split("\\s+")[4],
                                (first, second) -> first));
    }
}
