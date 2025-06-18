package com.example.config;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	// ログイン成功時に呼び出されるメソッド
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, // クライアントから送られてきたリクエスト情報を保持するオブジェクト。使用していないが、記述は必要 
            HttpServletResponse response, // サーバーからクライアントに返すレスポンス情報を操作するためのオブジェクト
            Authentication authentication) // authenticationオブジェクトからログインしたユーザーの情報を取得
            throws IOException, ServletException {

        // ロールを取得。ロールが一つでもgetAuthorities()は必ずコレクション型
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();
            if (role.equals("ROLE_ADMIN")) {
                response.sendRedirect("/admin/index");
                return;
            } else if (role.equals("ROLE_PUBLIC")) {
                response.sendRedirect("/public/index");
                return;
            }
        }

        // 該当するロールがない場合
        response.sendRedirect("/"); // fallback
    }
}
