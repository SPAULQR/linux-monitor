package factories;

import monitors.CpuMonitor;
import monitors.ICpuMonitor;
import parser.BufferedReaderParser;
import parser.IBufferedReaderParser;
import readerbuilders.FileReaderBuilder;
import readerbuilders.IReaderBuilder;
import readerbuilders.ProcessReaderBuilder;

public class CpuMonitorFactory implements ICpuMonitorFactory {
    private IReaderBuilder builder;
    private IBufferedReaderParser parser;

    @Override
    public ICpuMonitor getLinuxCpuMonitor() {
        builder = new ProcessReaderBuilder();
        parser = new BufferedReaderParser(builder, "mpstat -P ALL");
        return new CpuMonitor(parser.getSystemData());
    }

    @Override
    public ICpuMonitor getFileCpuMonitor(String directory) {
        builder = new FileReaderBuilder();
        parser = new BufferedReaderParser(builder, directory);
        return new CpuMonitor(parser.getSystemData());
    }
}
