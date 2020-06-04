package factories;

import monitors.FileSystemMonitor;
import monitors.IFileSystemMonitor;
import parser.BufferedReaderParser;
import parser.IBufferedReaderParser;
import readerbuilders.IReaderBuilder;
import readerbuilders.ProcessReaderBuilder;

public class FileSystemMonitorFactory implements IFileSystemMonitorFactory {
    private IReaderBuilder builder;
    private IBufferedReaderParser parser;

    @Override
    public IFileSystemMonitor getLinuxFileSystemMonitor() {
        builder = new ProcessReaderBuilder();
        parser = new BufferedReaderParser(builder, "df -h");
        return new FileSystemMonitor(parser.getSystemData());
    }
}
