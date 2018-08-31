package cn.zPluto.oauth2.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 *
 * 自定义的的认证provider
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 处理用户登陆信息的认证方法
   * @param authentication
   * @return
   * @throws AuthenticationException
   */
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

     return null;
  }

  @Override
  public boolean supports(Class<?> aClass) {
     return false;
  }


}