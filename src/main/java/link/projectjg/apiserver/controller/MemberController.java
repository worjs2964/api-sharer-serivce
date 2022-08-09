package link.projectjg.apiserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import link.projectjg.apiserver.dto.Response;
import link.projectjg.apiserver.dto.member.MemberJoinReq;
import link.projectjg.apiserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"member"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ApiOperation(value = "회원 가입", notes = "회원 가입을 진행합니다. 정상적으로 회원가입이 완료되면 응답으로 생성된 회원에 이메일, 닉네임을 반환합니다.")
    public ResponseEntity<Response> createUser(@Validated @RequestBody MemberJoinReq memberJoinReq) {
        return new ResponseEntity<>(Response.OK(memberService.joinMember(memberJoinReq)), HttpStatus.OK);
    }
}
