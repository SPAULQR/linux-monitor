package monitors;

import Exceptions.NotEnoughListSizeException;

import java.util.Map;

public interface IFileSystemMonitor {
    Map<String, String> getFileSystemUsage() throws NotEnoughListSizeException;
}
