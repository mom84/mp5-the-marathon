//package at.refugeescode.mp5themarathon;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import java.util.Arrays;
//import java.util.List;
//


//@RestController
//@RequestMapping("/winner")
//public class WinnerEndpoint {
//
//
//
//    private RestTemplate restTemplate;
//
//    @Value("${server.port}")
//    private String port;
//
//    public WinnerEndpoint(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @GetMapping
//    Runner getwinner() {
//
//        String url = "http://localhost:" + port + "/runners";
//        ResponseEntity<Runner[]> response = restTemplate.getForEntity(url, Runner[].class);
//        List<Runner> runners = Arrays.asList(response.getBody());
//
//        if (runners.isEmpty()) {
//            return null;
//        }
//
//        return runners.stream()
//                .sorted((e1, e2) -> e1.getTime().compareTo(e2.getTime()))
//                .findFirst()
//                .orElse(null);
//    }
//
//
//}