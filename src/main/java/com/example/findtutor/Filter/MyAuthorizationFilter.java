package com.example.findtutor.Filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
@Slf4j
public class MyAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/login")){
            filterChain.doFilter(request,response);
        }else {
            String authHeader=request.getHeader(AUTHORIZATION);
            if(authHeader!=null&authHeader.startsWith("Bearer ")){
                try {
                    String token=authHeader.substring("Bearer ".length());
                    Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
                    JWTVerifier jwtVerifier= JWT.require(algorithm).build();
                    DecodedJWT decodedJWT=jwtVerifier.verify(token);
                    String username=decodedJWT.getSubject();
                    String []roles=decodedJWT.getClaim("roles").asArray(String.class);
                    Collection<SimpleGrantedAuthority> simpleGrantedAuthorities  =new ArrayList<>();
                    stream(roles).forEach(role->{
                        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
                    });
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request,response);
                }catch (Exception e){
                    log.error("Error with logging in: {}", e);
                    response.setHeader("error",e.getMessage());
                    response.sendError(403);
                }
            }else{
                filterChain.doFilter(request,response);
            }
        }
    }
}
