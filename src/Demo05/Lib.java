package Demo05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "lib")
public class Lib {
    public void out(){
        System.out.println("lib");
    }
}
