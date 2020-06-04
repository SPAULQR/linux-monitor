package factories;

import monitors.IFileSystemMonitor;

public interface IFileSystemMonitorFactory {
    IFileSystemMonitor getLinuxFileSystemMonitor();
}
