package link.projectjg.apiserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import link.projectjg.apiserver.dto.Response;
import link.projectjg.apiserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;

@Api(tags = {"mail"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/mails")
public class MailController {

    private final MemberService memberService;

    @PostMapping("/resend-authentication-mail")
    @ApiOperation(value = "인증 메일 재전송", notes = "재전송은 인증되지 않은 회원이 인증 메일을 보낸지 1분 이상 지났을 때 보낼 수 있습니다.")
    public ResponseEntity<Response> resendAuthenticationEmail(@ApiIgnore Principal principal) {
        return new ResponseEntity<>(Response.OK(memberService.resendAuthenticationEmail(principal.getName())), HttpStatus.OK);
    }
}