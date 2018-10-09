package lidlapp.config;

import com.auth0.jwk.UrlJwkProvider;
import com.auth0.spring.security.api.JwtAuthenticationProvider;
import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.net.URL;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private static final String JWK = "https://www.googleapis.com/oauth2/v2/certs";
    private static final String AUDIENCE = "611765389674-fondb1lr61g90qnbb51c02jqbio5t6g5.apps.googleusercontent.com";
    private static final String ISSUER = "https://accounts.google.com";


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable().and()
                .httpBasic().disable()
                .csrf().and()
                .authorizeRequests()
                .antMatchers("/account").fullyAuthenticated()
                .anyRequest().permitAll();

        var jwkProvider = new UrlJwkProvider(new URL(JWK));
        var provider = new JwtAuthenticationProvider(jwkProvider, ISSUER, AUDIENCE);
        JwtWebSecurityConfigurer
                .forRS256(AUDIENCE, ISSUER, provider)
                .configure(http);
    }
}
