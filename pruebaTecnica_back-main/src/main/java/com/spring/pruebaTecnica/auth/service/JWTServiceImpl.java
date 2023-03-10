package com.spring.pruebaTecnica.auth.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.pruebaTecnica.auth.SimpleGrantedAuthorityMixin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Se encarga de la gestion y la logica implementa en el interfaz de JWT para las autorizaciones de los recursos
 */
@Component
public class JWTServiceImpl implements JWTService {

	public static final String SECRET = Base64Utils.encodeToString("soloJJ-1213".getBytes());
	
	public static final long EXPIRATION_DATE = 3600000L;//= 1 hora (si se necesita mas poner 3600000L * cantidad de horas
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

	/**
	 * Crea el token para enviar a la cliente
	 * @param auth
	 * @return
	 * @throws IOException
	 */
	@Override
	public String create(Authentication auth) throws IOException {

		String username = ((User) auth.getPrincipal()).getUsername();

		Collection<? extends GrantedAuthority> roles = auth.getAuthorities();

		Claims claims = Jwts.claims();
		claims.put("authorities", new ObjectMapper().writeValueAsString(roles));//Agregar el rol adicionalmente como string json

		String token = Jwts.builder()
				.setClaims(claims)//agregar los parametros a la cadena
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes())//agregar la firma
				.setIssuedAt(new Date())//agregar la fecha de crecacion
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))//agregar la fecha de expiracion
				.compact();

		return token;
	}

	/**
	 * Valida si el llego el token con la firma
	 * @param token
	 * @return
	 */
	@Override
	public boolean validate(String token) {

		try {
			getClaims(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}

	}

	/**
	 * Obtiene los claims para poder guardar parametroa adicionales o desencadenar mas filtros
	 * @param token
	 * @return
	 */
	@Override
	public Claims getClaims(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes())
				.parseClaimsJws(limpiarToken(token)).getBody();
		return claims;
	}

	@Override
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	/**
	 * Obtiene y almacena los roles del usuario en memoria
	 * @param token
	 * @return
	 * @throws IOException
	 */
	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {
		Object roles = getClaims(token).get("authorities");

		Collection<? extends GrantedAuthority> authorities = Arrays
				.asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
						.readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));

		return authorities;
	}

	/**
	 * Limpia la cabecera, extrae y retorn el token de tipo Bearer
	 * @param token
	 * @return
	 */
	@Override
	public String limpiarToken(String token) {//validar el prefijo
		if (token != null && token.startsWith(TOKEN_PREFIX)) {
			return token.replace(TOKEN_PREFIX, "");
		}
		return null;
	}

}
