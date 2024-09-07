package com.loyalist.onlinemoviebookingsystem.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@SuppressWarnings("deprecation")
@Component
public class JWTService {
	
	private String secretKey = "6acc5976bd8c70f368861d04a1b150aea4e8cee1d77737eff1e974daffa7e19f";
	
	public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }


    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //it is a generic method to extract the information from claims.
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //get information about the token claims.
    //This method parse the token and verifies its signature using previously setSignInKey() and returns the claims object.
    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    //generate Token

	public String generateToken(String userName) {
		Map<String, Object> claims=new HashMap<>();
		return createToken(userName,claims);
	}
	
	private String createToken(String userName, Map<String, Object> claims) {
		return Jwts.builder()
		.setClaims(claims)
		.setSubject(userName)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
		.signWith(getSignKey(),SignatureAlgorithm.HS256)
		.compact();
  
	}

	private Key getSignKey() {
		byte[] keyBytes=Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
