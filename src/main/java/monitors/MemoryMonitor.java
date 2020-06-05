package monitors;

import exceptions.NotEnoughListSizeException;
import parser.IBufferedReaderParser;

public class MemoryMonitor implements IMemoryMonitor {
    IBufferedReaderParser parser;
    private final int requiredListSize = 4;

    public MemoryMonitor(IBufferedReaderParser parser) {
        this.parser = parser;
    }

    @Override
    public String getMemoryUsage() throws NotEnoughListSizeException {
        if (parser.getSystemData().size() < requiredListSize)
            throw new NotEnoughListSizeException(requiredListSize);

        return parser.getSystemData()
                .stream()
                .skip(3)
                .findFirst()
                .map(s -> s.split("\\s+")[4])
                .orElse("Current value not found");
    }
}
