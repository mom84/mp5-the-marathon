package at.refugeescode.mp5themarathon;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class RunnersEndpoint {

    private List<Runner> runners = new ArrayList<>();


    @GetMapping("/runners")
    List<Runner> getAll() {
        return runners;
    }

    @PostMapping("/runners")
    void post(@RequestBody Runner runner) {
        runners.add(runner);
    }

    @GetMapping("/winner")
    Runner getwinner() {
        return runners.stream()
                .sorted((e1,e2) -> e1.getTime().compareTo(e2.getTime()))
                .findFirst()
                .orElse(new Runner());
    }


//    boolean b;
//    @PostMapping("/winner")
//    void poststring(@RequestBody String s){
//      b = false ;
//    }
//
//    @GetMapping("/winner")
//    boolean returnMessage(){
//        return b;
//    }


}
