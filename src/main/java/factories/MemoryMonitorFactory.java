package factories;

import monitors.IMemoryMonitor;
import monitors.MemoryMonitor;
import parser.BufferedReaderParser;
import parser.IBufferedReaderParser;
import readerbuilders.IReaderBuilder;
import readerbuilders.ProcessReaderBuilder;

public class MemoryMonitorFactory implements IMemoryMonitorFactory {
    private IReaderBuilder builder;
    private IBufferedReaderParser parser;

    @Override
    public IMemoryMonitor getLinuxMemoryMonitor() {
        builder = new ProcessReaderBuilder();
        parser = new BufferedReaderParser(builder, "sar -r ALL 1 1");
        return new MemoryMonitor(parser.getSystemData());
    }
}
