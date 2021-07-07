package com.shelloftrades.beginnerdemo.filter;

import com.shelloftrades.beginnerdemo.security.JwtUtil;
import com.shelloftrades.beginnerdemo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private MyUserDetailsService myUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Filter all requests from any endpoints containing Authorization header.
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException
    {
        final String  authHeader = request.getHeader("Authorization");

        // Extract the username
        String username = null;
        String jwt = null;

        // Validate the JWT
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        // Validate username and make sure that the security context
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = myUserDetailService.loadUserByUsername(username);

            // This is supposed to be done automatically by Spring Security
            // But since I'm taking over, this is a simulation of a normal operation when token is valid
            UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(upat);
        }

        filterChain.doFilter(request, response);
    }
}
