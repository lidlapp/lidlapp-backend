package lidlapp.config;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lidlapp.models.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;


public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String prefix = "Bearer ";
        var header = request.getHeader("Authorization");
        if (header == null || !header.startsWith(prefix)) {
            chain.doFilter(request, response);
            return;
        }
        var token = header.substring(prefix.length());


        try {
            var kid = JwtHelper.headers(token).get("kid");
            var decoded = JwtHelper.decodeAndVerify(token, verifier(kid));
            Map<String, String> userInfo = objectMapper.readValue(decoded.getClaims(), Map.class);
            var user = new User();
            user.setId(userInfo.get("sub"));
            user.setEmail(userInfo.get("email"));
            var authentication = new UsernamePasswordAuthenticationToken(user, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw new BadCredentialsException("Could not obtain access token");
        }
    }


    private RsaVerifier verifier(String kid) throws JwkException, MalformedURLException {
        JwkProvider provider = new UrlJwkProvider(new URL("https://www.googleapis.com/oauth2/v2/certs"));
        Jwk jwk = provider.get(kid);
        return new RsaVerifier((RSAPublicKey) jwk.getPublicKey());
    }
}