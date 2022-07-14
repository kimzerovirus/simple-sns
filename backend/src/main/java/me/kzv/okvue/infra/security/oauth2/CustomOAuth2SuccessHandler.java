package me.kzv.okvue.infra.security.oauth2;

import lombok.extern.log4j.Log4j2;
import me.kzv.okvue.infra.security.jwt.JwtTokenProvider;
import me.kzv.okvue.web.account.dto.TokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Log4j2
@Component
public class CustomOAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenProvider tokenProvider;
    private final String redirectUrl;

    public CustomOAuth2SuccessHandler(JwtTokenProvider tokenProvider, @Value("${oauth2.authorized-redirect-url}") String redirectUrl) {
        this.tokenProvider = tokenProvider;
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (response.isCommitted()) {
            // 응답이 이미 커밋되었을 경우? -> 응답이 이미 완료되었는데 임의로 접근하는 경우??
            log.warn("Unable to redirect");
            return;
        }

        DefaultOAuth2User auth2User = (DefaultOAuth2User) authentication.getPrincipal();

        String email = (String) auth2User.getAttributes().get("email");
        String nickname = (String) auth2User.getAttributes().get("name"); // naver kakao는 반환 키값 확인 필요
        String role = auth2User.getAuthorities().stream().collect(Collectors.toList()).get(0).toString().substring(5);


//        auth2User.getAttributes().forEach((item, index) -> log.info(item));
//        log.info(auth2User.getAttributes());
//        log.info(auth2User.getAuthorities().getClass().getName()); // collection type
//        // 스프링 시큐리티에서 권한 부어하면 prefix ROLE_이 붙으므로 잘라준다.
//        log.info(auth2User.getAuthorities().stream().collect(Collectors.toList()).get(0).toString().substring(5));


        final String token = null;
        final String targetUrl = UriComponentsBuilder.fromUriString(redirectUrl).queryParam("token", token).build().toString();
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
