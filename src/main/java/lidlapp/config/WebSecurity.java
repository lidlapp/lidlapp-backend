package lidlapp.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private static final String JWK = "https://www.googleapis.com/oauth2/v2/certs";
    private static final String AUDIENCE = "611765389674-fondb1lr61g90qnbb51c02jqbio5t6g5.apps.googleusercontent.com";
    private static final String ISSUER = "https://accounts.google.com";


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().and()
                .authorizeRequests()
                .antMatchers("/store").authenticated()
                .anyRequest().permitAll();
        JwtWebSecurityConfigurer
                .forRS256(AUDIENCE, ISSUER)
                .configure(http);
    }
}
