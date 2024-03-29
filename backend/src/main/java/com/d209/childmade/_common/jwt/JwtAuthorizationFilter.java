package com.d209.childmade._common.jwt;

import com.d209.childmade._common.exception.JwtException;
import com.d209.childmade.member.dto.SecurityMemberDto;
import com.d209.childmade.member.entity.Member;
import com.d209.childmade.member.service.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    private final JwtUtil jwtUtil;
    private final MemberService memberService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getRequestURI().contains("api/auth/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = resolveToken(request);

        // 토큰 검사 생략(모두 허용 URL의 경우 토큰 검사 통과)
        if (!StringUtils.hasText(token)) {
            doFilter(request, response, filterChain);
            return;
        }

        // AccessToken을 검증하고, 만료되었을경우 예외를 발생시킨다.
        if (!jwtUtil.validateToken(token)) {
            throw new JwtException("Access Token 만료!");
        }

        if (StringUtils.hasText(token) && jwtUtil.validateToken(token)) {
            Member findMember = memberService.findById(Integer.parseInt(jwtUtil.getMemberId(token)))
                    .orElseThrow(IllegalStateException::new);

            //SecurityContext에 저장할 Member 객체 생성
            SecurityMemberDto securityDto = SecurityMemberDto.from(findMember);

            Authentication authentication = jwtUtil.getAuthentication(securityDto);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String resolveToken(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(token) && token.startsWith(BEARER_PREFIX)) {
            return token.substring(BEARER_PREFIX.length());
        }

        return null;
    }
}
