package roomescape.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "payment")
public class PaymentClientProperties {

    private String secretKey;
    private int connectTimeoutSecond;
    private int readTimeoutSecond;
    private String baseUrl;
    private String approveUri;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public int getConnectTimeoutSecond() {
        return connectTimeoutSecond;
    }

    public void setConnectTimeoutSecond(int connectTimeoutSecond) {
        this.connectTimeoutSecond = connectTimeoutSecond;
    }

    public int getReadTimeoutSecond() {
        return readTimeoutSecond;
    }

    public void setReadTimeoutSecond(int readTimeoutSecond) {
        this.readTimeoutSecond = readTimeoutSecond;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApproveUri() {
        return approveUri;
    }

    public void setApproveUri(String approveUri) {
        this.approveUri = approveUri;
    }
}
