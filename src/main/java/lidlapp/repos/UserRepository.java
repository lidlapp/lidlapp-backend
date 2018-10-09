package lidlapp.repos;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.base.Strings;
import lidlapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;

public interface UserRepository extends CrudRepository<User, String> {
    default User findByAuth(Authentication authentication) {
        var userId = (String) authentication.getPrincipal();
        if (Strings.isNullOrEmpty(userId) || !authentication.isAuthenticated()) {
            throw new IllegalArgumentException("Not authenticated");
        }
        return findById(userId).orElseGet(() -> {
            var user = new User();
            user.setId(userId);
            DecodedJWT details = (DecodedJWT) authentication.getDetails();
            user.setNickname(details.getClaim("given_name").asString());
            user.setEmail(details.getClaim("email").asString());
            user.setName(details.getClaim("name").asString());
            return save(user);
        });
    }
}
