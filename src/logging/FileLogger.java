package logging;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileLogger implements ILogger {

    private PrintWriter writer;
    public FileLogger() throws FileNotFoundException, UnsupportedEncodingException {
       writer = new PrintWriter("results.txt", "UTF-8");
    }

    @Override
    public void write(long a) {
        writer.println(a);
    }

    @Override
    public void write(String a) {
        writer.println(a);
    }

    @Override
    public void write(Object... values) throws FileNotFoundException {
        for(Object val: values) {
            writer.print(val + " ");
        }
        writer.println(" ");
    }

    @Override
    public void close() {
        writer.close();
    }
}
