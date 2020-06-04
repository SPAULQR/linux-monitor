package monitors;

import Exceptions.NotEnoughListSizeException;

import java.util.Map;

public interface ICpuMonitor {

    public Map<String, String> getCoresIdle() throws NotEnoughListSizeException;

    public String getCpuIdle() throws NotEnoughListSizeException;

    public int getCoresCount() throws NotEnoughListSizeException;
}
