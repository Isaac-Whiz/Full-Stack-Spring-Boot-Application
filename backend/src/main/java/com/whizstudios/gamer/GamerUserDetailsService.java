package com.whizstudios.gamer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GamerUserDetailsService implements UserDetailsService {

    private final GamerDAO gamerDAO;

    public GamerUserDetailsService(@Qualifier("gamerJPAService") GamerDAO gamerDAO) {
        this.gamerDAO = gamerDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return gamerDAO.selectGamerByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }
}
