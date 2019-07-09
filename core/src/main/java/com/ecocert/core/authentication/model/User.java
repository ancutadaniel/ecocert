package com.ecocert.core.authentication.model;

import com.ecocert.core.authentication.config.SecurityConfig;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.security.AuthProvider;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Column(nullable = false)
	@Getter
	@Setter
	private String name;

	@Email
	@Column(nullable = false)
	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String imageUrl;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private SecurityConfig.OAuthProvider provider;

	@Getter
	@Setter
	private String providerUserId;
}