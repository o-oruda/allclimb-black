package io.ooruda.allclimb.user.domain.pass;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Pass", description = "Pass api for front")
@RequiredArgsConstructor
@RequestMapping("/v1/pass")
@RestController
public class PassController {

    @Operation(summary = "pass 목록 조회")
    @GetMapping
    public String passList() {
        log.info("passList");
        return "pass";
    }
}
