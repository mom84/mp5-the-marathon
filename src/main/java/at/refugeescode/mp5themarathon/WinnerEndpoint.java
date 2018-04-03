//package at.refugeescode.mp5themarathon;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/winner")
//public class WinnerEndpoint {
//
//
//   @Autowired
//   RunnersEndpoint runnersEndpoint;
//
//    @Value("${server.port}")
//    private String port;
//
//
//    @GetMapping
//    Runner getwinner() {
//      return runnersEndpoint.getAll().stream()
//                .sorted((e1, e2) -> e1.getTime().compareTo(e2.getTime()))
//                .findFirst()
//                .orElse(null);
//
//    }
//
//
//}