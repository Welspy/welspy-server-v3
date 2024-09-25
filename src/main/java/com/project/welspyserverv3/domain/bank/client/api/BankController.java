package com.project.welspyserverv3.domain.bank.client.api;

import com.project.welspyserverv3.domain.bank.client.dto.request.ChargeMoneyRequest;
import com.project.welspyserverv3.domain.bank.client.dto.request.SaveMoneyRequest;
import com.project.welspyserverv3.domain.bank.service.BankService;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @PatchMapping
    @Operation(summary = "저금하기")
    public BaseResponseData<Long> savingMoney(@RequestBody @Valid SaveMoneyRequest request){
        return BaseResponseData.ok(
                "저금 성공",
                bankService.savingMoney(request));
    }

    @PatchMapping("/charge")
    @Operation(summary = "충전")
    public BaseResponseData<Long> chargeMoney(@RequestBody @Valid ChargeMoneyRequest request){
        return BaseResponseData.ok(
                "저금 성공",
                bankService.chargeMoney(request));
    }

}
