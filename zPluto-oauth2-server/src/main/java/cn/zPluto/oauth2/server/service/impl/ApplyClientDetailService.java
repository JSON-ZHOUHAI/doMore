package cn.zPluto.oauth2.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author zhouh
 * @description
 * @date 2018/8/31
 *
 */
public class ApplyClientDetailService  implements ClientDetailsService {

    @Autowired
    private DataSource dataSource;

    @Override
    public ClientDetails loadClientByClientId(String applyName) throws ClientRegistrationException {
        JdbcClientDetailsService jdbcClientDetailsService= new JdbcClientDetailsService(dataSource);
        ClientDetails clientDetails = jdbcClientDetailsService.loadClientByClientId(applyName);
        return clientDetails;
    }
}
