package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // このクラスがspringに対する設定を行うものであることを示す
@EnableMethodSecurity // メソッド単位での認可を有効にする。(コントローラークラスのアクセス制御　preauthorizeに関連)
public class SecurityConfig {
	
	@Bean
	  PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	  	
	@Bean
	SecurityFilterChain securityFileterChain(HttpSecurity http) throws Exception{
		http.formLogin(login -> login // フォーム認証を使う
				.loginPage("/login") // ログインページのURL
				.defaultSuccessUrl("/admin/index", true) // ログイン後の遷移先
				.permitAll()
			) // フォーム認証画面は認証不要
			.logout(logout -> logout
	            .logoutUrl("/logout") // ログアウトURL
	            .logoutSuccessUrl("/") // ログアウト後の遷移先
	            .invalidateHttpSession(true) // セッション破棄 デフォルトでtrueなので明示しなくてもいい
	            .deleteCookies("JSESSIONID") // Cookie削除
            )
			.authorizeHttpRequests(authz -> authz
//					.requestMatchers("/css/**").permitAll() // cssファイルは認証不要
					.requestMatchers("/webjars/**").permitAll() //bootstrap許可
					.requestMatchers("/").permitAll() // トップページは認証不要
					.requestMatchers("/new/**").hasRole("ADMIN")  // アクセス制限
					.anyRequest().authenticated() // 他のURLはログイン後アクセス可能
		);
		
		return http.build();
	}
}
