package com.pointOfSale.suvaraj.project1.auth.service;

import java.util.Collections;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.pointOfSale.suvaraj.project1.entity.User;

@Service
public class JwtService {
	
	private String secreteKey = "123";
	
	public String createToken(User user)
	{
		Date now = new Date();
		Date validity = new Date(now.getTime() + 3600000); //1 hour
		
		Algorithm algorithm = Algorithm.HMAC256(secreteKey);
		
		return JWT.create().withSubject(user.getEmail())
							.withIssuedAt(now)
							.withExpiresAt(validity)
							.sign(algorithm);
	}
	
	
	private DecodedJWT getDecodedJWt(String token)
	{
		Algorithm algorithm = Algorithm.HMAC256(secreteKey);
		
		JWTVerifier verifer = JWT.require(algorithm).build();
		
		DecodedJWT decoded = verifer.verify(token);
		return decoded;
	}
	
	
	public Authentication validateToken(String token) {
			
		DecodedJWT decoded = getDecodedJWt(token);
		
		User user = new User();
		user.setEmail(decoded.getSubject());
		
		return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
		
	}
	
	public String getUsername(String token)
	{
		DecodedJWT decoded = getDecodedJWt(token);
		//System.err.println(decoded.getSubject());
		return decoded.getSubject();
		
	}

}
