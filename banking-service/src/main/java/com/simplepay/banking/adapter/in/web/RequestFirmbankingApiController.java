package com.simplepay.banking.adapter.in.web;

import com.simplepay.banking.port.service.RequestFirmbankingService;
import com.simplepay.common.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/banking")
@RequiredArgsConstructor
@RestController
public class RequestFirmbankingApiController {

    private final RequestFirmbankingService requestFirmbankingService;
    private final RequestFirmbankingDtoMapper requestFirmbankingDtoMapper;

    @PostMapping("/firmbanking")
    public ResponseEntity<ApiResponse<FirmbankingRequestResultResponse>> requestFirmbanking(
        @RequestBody RequestFirmbankingRequest request
    ) {

        var command = requestFirmbankingDtoMapper.mapToCommand(request);
        var firmbankingResult = requestFirmbankingService.requestFirmbanking(command);
        var data = requestFirmbankingDtoMapper.mapToResponse(firmbankingResult);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                ApiResponse.OK(data)
            );
    }
}
