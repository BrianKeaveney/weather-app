package com.genesys.weatherapp.IT;

import com.genesys.weatherapp.testutils.SampleDtos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ExtendWith(SpringExtension.class)
public class SensorIT extends BaseIT {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void testGetSensorFlow() {
        webTestClient
                .get()
                .uri("/sensor?id=asdfasdf")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .jsonPath("$.message").isEqualTo("Success")
                .jsonPath("$.sensor").exists();
    }

    @Test
    public void testRegisterSensorFlow() {
        SampleDtos.SENSOR_ID = "aaaaaaa";

        webTestClient
                .post()
                .uri("/sensor/register")
                .body(BodyInserters.fromValue(SampleDtos.getSampleSensorRequest()))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .jsonPath("$.message").isEqualTo("Success")
                .jsonPath("$.sensor").exists();
    }

    @Test
    public void testGetMetricsFlow() {
        webTestClient
                .post()
                .uri("/sensor/metrics/get")
                .body(BodyInserters.fromValue(SampleDtos.getSampleSensorQueryRequest()))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .jsonPath("$.message").isEqualTo("Success")
                .jsonPath("$.metrics").exists();
    }

    @Test
    public void testAddMetricsFlow() {
        webTestClient
                .post()
                .uri("/sensor/metrics")
                .body(BodyInserters.fromValue(SampleDtos.getSampleMetricsRequest()))
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .jsonPath("$.message").isEqualTo("Success")
                .jsonPath("$.metrics").exists();
    }
}
