package monitors;

import exceptions.NotEnoughListSizeException;
import parser.IBufferedReaderParser;

import java.util.Map;
import java.util.stream.Collectors;

public class CpuMonitor implements ICpuMonitor {
    IBufferedReaderParser parser;
    private final int requiredListSize = 4;

    public CpuMonitor(IBufferedReaderParser parser) {
        this.parser = parser;
    }


    @Override
    public Map<String, String> getCoresIdle() throws NotEnoughListSizeException {
        if (parser.getSystemData().size() < requiredListSize)
            throw new NotEnoughListSizeException(requiredListSize);

        return parser.getSystemData()
                .stream()
                .skip(3)
                .collect(Collectors
                        .toMap(key -> key.split("\\s+")[1],
                                value -> value.split("\\s+")[11]));
    }

    @Override
    public String getCpuIdle() throws NotEnoughListSizeException {
        return getCoresIdle().get("all");
    }

    @Override
    public int getCoresCount() throws NotEnoughListSizeException {
        return getCoresIdle().size() - 1;
    }
}
