package io.spring.initializr.stub;

import io.spring.initializr.web.autoconfigure.InitializrAutoConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A sample app where the Initializr auto-configuration has been disabled.
 *
 * @author Stephane Nicoll
 */
@SpringBootApplication(exclude = {InitializrAutoConfiguration.class})
public class SampleApp {
}
