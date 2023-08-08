package com.demo.microservice.limitsservice.ITCase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LimitITCase {

    @Autowired
    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @LocalServerPort
    int randomServerPort;

    @Test
    void call_limit_api_should_success() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:"+randomServerPort+"/api/v1/limits", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(""" 
                {"minimum":0,"maximum":0}
        """.trim());
    }

}
