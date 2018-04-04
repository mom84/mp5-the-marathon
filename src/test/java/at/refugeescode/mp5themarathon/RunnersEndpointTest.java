package at.refugeescode.mp5themarathon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class RunnersEndpointTest {


    @LocalServerPort
    private int port;


    @Autowired
    private TestRestTemplate restTemplate;

    @SpyBean
    private RunnersEndpoint runnersEndpoint;

    private String endpoint1 = "/runners";
    private String endpoint2 = "/winner";

    private String urlRunners;
    private String urlWinner;

    @BeforeEach
    void before() {
        // prepares the URL of our endpoint
        urlRunners = "http://localhost:" + port + endpoint1;
        urlWinner = "http://localhost:" + port + endpoint2;
    }

    @Test
    void getAll() {

        ResponseEntity<Runner[]> response = restTemplate.getForEntity(urlRunners, Runner[].class);
        List<Runner> runners = Arrays.asList(response.getBody());

        assertTrue(runners.isEmpty());
        verify(runnersEndpoint).getAll();

    }

    @Test
    void post() {
        Duration duration = Duration.ofHours(1).plusMinutes(20);
        Runner runner = new Runner("Mohammad" , duration);
        ResponseEntity<Runner> response = restTemplate.postForEntity(urlRunners, runner, Runner.class);

        assertEquals(runner.getName(), response.getBody().getName());
        assertEquals(runner.getTime(), response.getBody().getTime());
        //assertThat(runner, samePropertyValuesAs(response.getBody()));
        verify(runnersEndpoint).post(any(Runner.class));


        ResponseEntity<Runner[]> responseRunners = restTemplate.getForEntity(urlRunners, Runner[].class);
        List<Runner> runnersList = Arrays.asList(responseRunners.getBody());
        assertFalse(runnersList.isEmpty());
        assertEquals(runner.getName(), runnersList.get(0).getName());
        assertEquals(runner.getTime(), runnersList.get(0).getTime());
        verify(runnersEndpoint).getAll();
    }


    @Test
    void getwinner() {

        Duration duration1 = Duration.ofHours(1).plusMinutes(10);
        Runner runner1 = new Runner("Mohammad" , duration1);
        Duration duration2 = Duration.ofHours(1).plusMinutes(05);
        Runner runner2 = new Runner("Diaa" , duration2);
         restTemplate.postForEntity(urlRunners, runner1, Runner.class);
         restTemplate.postForEntity(urlRunners, runner2, Runner.class);

        ResponseEntity<Runner> responseRunner = restTemplate.getForEntity(urlWinner, Runner.class);
        assertEquals("Diaa", responseRunner.getBody().getName());
        verify(runnersEndpoint).getwinner();



    }
}