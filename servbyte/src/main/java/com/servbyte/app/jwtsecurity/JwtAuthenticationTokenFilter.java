package com.servbyte.app.jwtsecurity;


import com.servbyte.app.models.jwt.JwtAuthenticationToken;
import com.sun.net.httpserver.Filter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{
//    protected JwtAuthenticationTokenFilter(String defaultFilterProcessesUrl) {
//        super(defaultFilterProcessesUrl);
//    }

    public JwtAuthenticationTokenFilter() {

        super("/rest/**");
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        System.out.println("httpServletRequest: " + httpServletRequest.toString());
        String header = httpServletRequest.getHeader("Authorisation");
        System.out.println(header);
        if(header==null || !header.startsWith("Token ")){
            throw new RuntimeException("Jwt Token is missing");
        }
        String authenticationToken = header.substring(6);
        System.out.println("authenticationToken: " + authenticationToken);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }


}
