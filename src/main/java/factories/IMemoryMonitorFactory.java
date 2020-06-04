package factories;

import monitors.IMemoryMonitor;

public interface IMemoryMonitorFactory {
    IMemoryMonitor getLinuxMemoryMonitor();
}
