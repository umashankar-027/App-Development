package com.example.demo1.util;
import java.sql.Date;

import org.springframework.stereotype.Component;

import com.example.demo1.entity.Userjwt;

//import com.supermarketapp.supermarket.model.Worker;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

	@Component
	public class Jwtutil 
	{
	    // @Value("${application.jwt.secret-key}")
	    private static String securityKey = "VCCjuIfD65SriNthatDQCmfHaridgRb9GIXhoQlPBB7qhaRANcDJw1MeZ480fqe";

	    public String generateToken(Userjwt u) 
	    {
	        long issueTime = System.currentTimeMillis();

	        Date issueDate = new Date(issueTime);

	        // claims
	        Claims claims = Jwts.claims()
	                .setIssuer(u.getUserName()+";"+u.getPassword())
	                .setIssuedAt(issueDate);

	        return Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS256, securityKey)
	                .compact();
	    }

	    public String verify(String auth) {

	        try {
	            return Jwts
	            		.parser()
	            		.setSigningKey(securityKey)
	            		.parseClaimsJws(auth)
	            		.getBody().getIssuer();
	        } 
	        catch (Exception e) {
	            return null;
	        }

	    }
	}

