package kovalskiy91.selfdev.springcore.beanresolution;

import org.springframework.stereotype.Component;

@Component("aService")
public class Service implements Writer, Reader {

    @Override
    public String read() {
        return null;
    }

    @Override
    public void write(String string) {

    }
}
