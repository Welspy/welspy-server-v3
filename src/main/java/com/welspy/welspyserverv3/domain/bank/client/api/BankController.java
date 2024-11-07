package com.welspy.welspyserverv3.domain.bank.client.api;

import com.welspy.welspyserverv3.domain.bank.client.dto.BankLog;
import com.welspy.welspyserverv3.domain.bank.client.dto.request.ChargeMoneyRequest;
import com.welspy.welspyserverv3.domain.bank.client.dto.request.SaveMoneyRequest;
import com.welspy.welspyserverv3.domain.bank.service.BankQueryService;
import com.welspy.welspyserverv3.domain.bank.service.BankService;
import com.welspy.welspyserverv3.domain.bank.service.response.MyBankResponse;
import com.welspy.welspyserverv3.global.common.dto.request.PageRequest;
import com.welspy.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
@Tag(name = "뱅킹 API")
public class BankController {

    private final BankService bankService;
    private final BankQueryService bankQueryService;

    @GetMapping
    @Operation(summary = "내 뱅킹 정보 조회")
    public BaseResponseData<MyBankResponse> myBank(HttpServletRequest http) {
        System.out.println(http.getRequestURI() + " " + http.getMethod() + " - " + http.getRemoteAddr());
        return BaseResponseData.ok(
                "조회 성공",
                bankService.myBank());
    }

    @GetMapping("/log-all")
    @Operation(summary = "모든 로그 기록 보기")
    public BaseResponseData<List<BankLog>> getAllLog(PageRequest request,
                                                     HttpServletRequest http) {
        System.out.println(http.getRequestURI() + " " + http.getMethod() + " - " + http.getRemoteAddr());
        return BaseResponseData.ok(
                "조회 성공",
                bankQueryService.getAllLog(request));
    }

    @GetMapping("/log-my")
    @Operation(summary = "내 로그 기록 보기")
    public BaseResponseData<List<BankLog>> getMyLog(PageRequest request) {
        return BaseResponseData.ok(
                "조회 성공",
                bankQueryService.getMyLog(request));
    }

    @PatchMapping
    @Operation(summary = "저금하기")
    public BaseResponseData<Long> savingMoney(@RequestBody @Valid SaveMoneyRequest request) {
        return BaseResponseData.ok(
                "저금 성공",
                bankService.savingMoney(request));
    }

    @PatchMapping("/charge")
    @Operation(summary = "충전")
    public BaseResponseData<Long> chargeMoney(@RequestBody @Valid ChargeMoneyRequest request) {
        return BaseResponseData.ok(
                "저금 성공",
                bankService.chargeMoney(request));
    }

}