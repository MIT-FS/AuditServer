package us.mitfs.samples.auditserver;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import us.muit.fs.samples.auditserver.controllers.HealthController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;


@SpringBootTest(classes = us.muit.fs.samples.auditserver.AuditserverApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
class SuccessfulHealthzTest {

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void healthz() throws Exception {
		String endpoint = "http://localhost:" + port + "/readyz";
		System.out.println("endpoint: "+endpoint);
		Map<String, Object> endpointResponse = this.restTemplate.getForObject(endpoint, Map.class);
		System.out.println("Response details: "+endpointResponse);
		assertThat(endpointResponse).containsKeys("healthy", "totalAdditions", "metric");
		assertThat(endpointResponse.get("healthy")).isEqualTo(true);
	}
}


