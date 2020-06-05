package monitors;

import exceptions.NotEnoughListSizeException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileSystemMonitor implements IFileSystemMonitor {
    private final List<String> dataList;
    private final int requiredListSize = 2;

    public FileSystemMonitor(List<String> dataList) {
        this.dataList = dataList;
    }

    public Map<String, String> getFileSystemUsage() throws NotEnoughListSizeException {
        if (dataList.size() < requiredListSize)
            throw new NotEnoughListSizeException(requiredListSize);

        return dataList.stream()
                .skip(1)
                .collect(Collectors
                        .toMap(key -> key.split("\\s+")[0],
                                value -> value.split("\\s+")[4],
                                (first, second) -> first));
    }
}
