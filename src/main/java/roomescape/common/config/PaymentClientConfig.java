package roomescape.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import roomescape.common.properties.PaymentClientProperties;
import roomescape.payment.exception.handler.PaymentApproveExceptionHandler;

import java.time.Duration;

@Configuration
@EnableConfigurationProperties(PaymentClientProperties.class)
public class PaymentClientConfig {

    @Autowired
    PaymentClientProperties paymentClientProperties;

    @Bean
    public RestClientCustomizer restClientCustomizer() {
        return restClientBuilder -> restClientBuilder
                .requestFactory(generateTimeoutRequestFactory());
    }

    private SimpleClientHttpRequestFactory generateTimeoutRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(Duration.ofSeconds(paymentClientProperties.getConnectTimeoutSecond()));
        requestFactory.setReadTimeout(Duration.ofSeconds(paymentClientProperties.getReadTimeoutSecond()));
        return requestFactory;
    }

    @Bean
    public RestClient paymentRestClient(RestClient.Builder restClientBuilder) {
        return restClientBuilder
                .baseUrl(paymentClientProperties.getBaseUrl())
                .build();
    }

    @Bean
    public PaymentApproveExceptionHandler paymentApproveExceptionHandler() {
        return new PaymentApproveExceptionHandler();
    }
}
