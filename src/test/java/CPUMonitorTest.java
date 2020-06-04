import Exceptions.NotEnoughListSizeException;
import factories.CpuMonitorFactory;
import factories.ICpuMonitorFactory;
import monitors.ICpuMonitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CPUMonitorTest {
    private final ICpuMonitorFactory cpuMonitorFactory = new CpuMonitorFactory();
    private ICpuMonitor cpuMonitor = cpuMonitorFactory.getFileCpuMonitor("src/test/resources/cpu test data.txt");;

    @Test
    public void insufficientDataListTesting() {
        cpuMonitor = cpuMonitorFactory.getFileCpuMonitor("src/test/resources/not enough test list.txt");
        Assertions.assertThrows(NotEnoughListSizeException.class,
                () -> cpuMonitor.getCoresIdle());
    }

    @Test
    public void testCpuMonitorNotNull() throws NotEnoughListSizeException {
        Assertions.assertNotNull(cpuMonitor.getCoresIdle());
    }

    @Test
    public void testCpuMonitorFirstLine() throws NotEnoughListSizeException {
        Assertions.assertEquals("93,90", cpuMonitor.getCpuIdle());
    }
}