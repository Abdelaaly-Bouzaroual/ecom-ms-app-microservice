package org.masterenset.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

//@ConfigurationProperties(prefix = "customer.params")
//public record CustomerConfigParams(String x, String y) {
//
////    customer.params.x=11
////    customer.params.y=22
//
//
//}


@ConfigurationProperties(prefix = "customer.params")
@RefreshScope
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerConfigParams {

    private String x;
    private String  y;
}
