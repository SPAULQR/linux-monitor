package factories;

import monitors.ICpuMonitor;

public interface ICpuMonitorFactory {
    ICpuMonitor getLinuxCpuMonitor();

    ICpuMonitor getFileCpuMonitor(String command);
}
