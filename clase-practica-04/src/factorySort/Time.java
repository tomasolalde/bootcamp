package factorySort;

import java.util.Date;

public class Time {
    private Date inicio;
    private Date fin;

    public Time() {
    }

    public void start () {
        this.inicio = new Date();
    }

    public void stop () {
        this.fin = new Date();
    }

    public long elapsedTime () {
        return this.fin.getTime() - this.inicio.getTime();
    }
}
