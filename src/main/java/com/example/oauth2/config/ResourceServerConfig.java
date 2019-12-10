package com.example.oauth2.config;

import com.example.oauth2.service.MyAuthenticationEntryPoint;
import com.example.oauth2.service.RestAuthAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源提供端的配置
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private RestAuthAccessDeniedHandler deniedHandler;

    @Autowired
    private MyAuthenticationEntryPoint authenticationEntryPoint;
    /**
     * 这里设置需要token验证的url
     * 可以在WebSecurityConfigurerAdapter中排除掉，
     * 对于相同的url，如果二者都配置了验证
     * 则优先进入ResourceServerConfigurerAdapter,进行token验证。而不会进行
     * WebSecurityConfigurerAdapter 的 basic auth或表单认证。
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/user/me")
                .and()
                .authorizeRequests()
                .antMatchers("/user/me")
                .authenticated();
        //需要的时候创建session，支持从session中获取认证信息，ResourceServerConfiguration中
        //session创建策略是stateless不使用，这里其覆盖配置可创建session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(deniedHandler);
        //此处是关键，默认stateless=true，只支持access_token形式，
        // OAuth2客户端连接需要使用session，所以需要设置成false以支持session授权
        resources.stateless(false);
    }

}