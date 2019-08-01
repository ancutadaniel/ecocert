package com.ecocert.core.authentication.security.oauth2.user;

import com.ecocert.core.authentication.model.User;

import java.util.Map;

public class OAuth2UserInfoFactory {

	public static OAuth2UserInfo getOAuth2UserInfo(String authProvider, Map<String, Object> attributes) {
		if (authProvider.equalsIgnoreCase(User.Provider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
		} else if (authProvider.equalsIgnoreCase(User.Provider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else {
			throw new IllegalArgumentException("Unsupported auth provider: " + authProvider);
        }
    }
}
