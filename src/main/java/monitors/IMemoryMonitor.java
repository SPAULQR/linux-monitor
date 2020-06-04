package monitors;

import Exceptions.NotEnoughListSizeException;

public interface IMemoryMonitor {
    String getMemoryUsage() throws NotEnoughListSizeException;
}
