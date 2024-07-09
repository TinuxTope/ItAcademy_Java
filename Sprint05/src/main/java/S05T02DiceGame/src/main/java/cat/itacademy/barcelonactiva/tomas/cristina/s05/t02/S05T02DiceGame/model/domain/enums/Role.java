package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public enum Role {
    ROLE_USER(List.of("USER_READ", "USER_WRITE")),
    ROLE_ADMIN(List.of("ADMIN_READ", "ADMIN_WRITE", "USER_READ", "USER_WRITE"));

    private final List<String> permissions;

    Role(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
        List<GrantedAuthority> authorities = getPermissions().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority(this.name()));
        return authorities;
    }
}
