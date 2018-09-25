package lidlapp.controllers;

import com.google.common.base.Strings;
import lidlapp.models.User;
import lidlapp.repos.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
public class AccountController {
    private final UserRepository userRepository;

    public AccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    private User getUser(Authentication auth) {
        return userRepository.findByAuth(auth);
    }

    @PutMapping
    private User editUser(@RequestBody User request, Authentication auth) {
        var user = userRepository.findByAuth(auth);
        // Nickname
        var nickname = request.getNickname();
        if (!Strings.isNullOrEmpty(nickname)) {
            user.setNickname(nickname);
        }
        // Name
        var name = request.getName();
        if (!Strings.isNullOrEmpty(name)) {
            user.setName(name);
        }
        // IBAN
        var iban = request.getIban();
        if (!Strings.isNullOrEmpty(iban)) {
            user.setIban(iban);
        }
        return user;
    }
}
