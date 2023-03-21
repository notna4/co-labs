package logging;

public class ConsoleLogger implements ILogger {

    @Override
    public void write(long a) {
        System.out.println(a);
    }

    @Override
    public void write(String a) {
        System.out.println(a);
    }


    @Override
    public void write(Object ... values) {
        if(values[values.length-1] == "micros") {
            for(int i = 0; i < values.length-1; i++) {
                if(values[i].getClass().getName() == "java.lang.Long") {
                    System.out.print(convertNanoTo("micros", (Long)values[i]) + " ");
                }
                else {
                    System.out.print(values[i] + " ");
                }
            }
            System.out.println("micros.");
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
        else if(values[values.length-1] == "s") {
            for(int i = 0; i < values.length-1; i++) {
                if(values[i].getClass().getName() == "java.lang.Long") {
                    System.out.print(convertNanoTo("s", (Long)values[i]) + " ");
                }
                else {
                    System.out.print(values[i] + " ");
                }
            }
            System.out.println("seconds.");
        }
        else if(values[values.length-1] == "ns") {
            for(int i = 0; i < values.length-1; i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println("ns.");
        }
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
        ;
    }
}
