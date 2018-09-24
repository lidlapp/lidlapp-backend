package lidlapp;

import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.net.URL;

public class WebSecurity extends WebSecurityConfigurerAdapter {
    private static final String JWK = "https://www.googleapis.com/oauth2/v2/certs";
    private static final String AUDIENCE = "611765389674-fondb1lr61g90qnbb51c02jqbio5t6g5.apps.googleusercontent.com";
    private static final String ISSUER = "https://accounts.google.com";


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable();
        JwkProvider provider = new UrlJwkProvider(new URL(JWK));

        JwtWebSecurityConfigurer
                .forRS256(AUDIENCE, ISSUER)
                .configure(http);
    }
}
