package com.rsm.spring.oauth2.rsmauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;

import org.thymeleaf.expression.Lists;
import com.rsm.spring.oauth2.rsmauthserver.web.AuthorizationConsentController;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.context.annotation.ImportRuntimeHints;


@SpringBootApplication
@ImportRuntimeHints(RsmAuthServerApplication.DemoAuthorizationServerApplicationRuntimeHintsRegistrar.class)
public class RsmAuthServerApplication {

static class DemoAuthorizationServerApplicationRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			// Thymeleaf
			hints.reflection().registerTypes(
					Arrays.asList(
							TypeReference.of(AuthorizationConsentController.ScopeWithDescription.class),
							TypeReference.of(Lists.class)
					), builder ->
							builder.withMembers(MemberCategory.DECLARED_FIELDS,
									MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS)
			);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(RsmAuthServerApplication.class, args);
	}

}
