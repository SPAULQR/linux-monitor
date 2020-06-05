package monitors;

import exceptions.NotEnoughListSizeException;

import java.util.List;

public class MemoryMonitor implements IMemoryMonitor {
    private final List<String> dataList;
    private final int requiredListSize = 4;

    public MemoryMonitor(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String getMemoryUsage() throws NotEnoughListSizeException {
        if (dataList.size() < requiredListSize)
            throw new NotEnoughListSizeException(requiredListSize);

        return dataList.stream()
                .skip(3)
                .findFirst()
                .map(s -> s.split("\\s+")[4])
                .orElse("Current value not found");
    }
}
