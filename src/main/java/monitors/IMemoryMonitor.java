package monitors;

import exceptions.NotEnoughListSizeException;

public interface IMemoryMonitor {
    String getMemoryUsage() throws NotEnoughListSizeException;
}
