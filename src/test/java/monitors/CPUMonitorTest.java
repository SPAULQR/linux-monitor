package monitors;

import exceptions.NotEnoughListSizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.BufferedReaderParser;
import parser.IBufferedReaderParser;
import readerbuilders.FileReaderBuilder;
import readerbuilders.IReaderBuilder;

public class CPUMonitorTest {
    private IReaderBuilder builder = new FileReaderBuilder();
    private IBufferedReaderParser parser = new BufferedReaderParser(builder, "src/test/resources/cpu_test_data.txt");
    private ICpuMonitor cpuMonitor = new CpuMonitor(parser.getSystemData());

    @Test
    public void shouldThrowExceptionIfInsufficientOutputSize() {
        parser = new BufferedReaderParser(builder, "src/test/resources/not_enough_test_list.txt");
        cpuMonitor = new CpuMonitor(parser.getSystemData());
        Assertions.assertThrows(NotEnoughListSizeException.class,
                () -> cpuMonitor.getCoresIdle());
    }

    @Test
    public void shouldNotReturnNullForCoreIdleStat() throws NotEnoughListSizeException {
        Assertions.assertNotNull(cpuMonitor.getCoresIdle());
    }

    @Test
    public void shouldReturnCorrectCpuIdleValue() throws NotEnoughListSizeException {
        Assertions.assertEquals("93,90", cpuMonitor.getCpuIdle());
    }
}