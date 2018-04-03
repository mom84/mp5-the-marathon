package at.refugeescode.mp5themarathon;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class Runner {

    private String name;
    private Duration time;

    public Runner(){

    }

    public Runner(String name, Duration time) {
        this.name = name;
        this.time=time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public boolean like(Runner runner) {
      return (runner.name.equals(name)) && (runner.time == time);
    }
}
