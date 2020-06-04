package monitors;

import Exceptions.NotEnoughListSizeException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CpuMonitor implements ICpuMonitor {
    private final List<String> dataList;
    private final int requiredListSize = 4;

    public CpuMonitor(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public Map<String, String> getCoresIdle() throws NotEnoughListSizeException {
        if (dataList.size() < requiredListSize)
            throw new NotEnoughListSizeException(requiredListSize);

        return dataList.stream()
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
