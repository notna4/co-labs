package logging;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class FileLogger implements ILogger {

    private PrintWriter writer;
    public FileLogger()  {
        try {
//            throw new FileNotFoundException(), new UnsupportedEncodingException();
//            writer = new PrintWriter("results.txt", "UTF-8");
            writer= new PrintWriter(new FileOutputStream("results.txt", true /* append = true */));
        } catch (IOException err) {
            throw new RuntimeException(err);
        }
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
    public void write(Object... values)  {
        if(values[values.length-1] == "micros") {
            for(int i = 0; i < values.length-1; i++) {
                if(values[i].getClass().getName() == "java.lang.Long") {
//                    writer.print(TimeUnit.NANOSECONDS.toMicros((Long) values[i]) + " ");
                    writer.print(convertNanoTo("micros", (Long)values[i]) + " ");
                }
                else {
                    writer.print(values[i] + " ");
                }
            }
            writer.print("micros.");
        }
        else if(values[values.length-1] == "s") {
            for(int i = 0; i < values.length-1; i++) {
                if(values[i].getClass().getName() == "java.lang.Long") {
//                    writer.print(TimeUnit.NANOSECONDS.toSeconds((Long) values[i]) + " ");
                    writer.print(convertNanoTo("s", (Long)values[i]) + " ");
                }
                else {
                    writer.print(values[i] + " ");
                }
            }
            writer.print("seconds.");
        }
        else if(values[values.length-1] == "milli") {
            for(int i = 0; i < values.length-1; i++) {
                if(values[i].getClass().getName() == "java.lang.Long") {
                    System.out.print(convertNanoTo("milli", (Long)values[i]) + " ");
                }
                else {
                    System.out.print(values[i] + " ");
                }
            }
            System.out.println("milli.");
        }
        else if(values[values.length-1] == "ns") {
            for(int i = 0; i < values.length-1; i++) {
                    writer.print(values[i] + " ");
            }
            writer.print("ns.");
        }
        writer.println(" ");
    }

    @Override
    public long convertNanoTo(String dest, long nano) {
        if(dest == "micros") {
            return nano/1000;
        }
        else if(dest == "milli") {
            return nano/1000000;
        }
        else if(dest == "s") {
            return nano/1000000000;
        }
        return -1;
    }

    @Override
    public void close() {
        writer.close();
    }
}
