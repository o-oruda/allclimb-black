package io.ooruda.allclimb.user.domain.purchase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1/purchase")
@RestController
public class PurchaseController {

    @PostMapping("/{productId}")
    public void purchase(@PathVariable("productId") String productId) {

        log.info("product-id : {}", productId);
    }

    @PostMapping("/cancel/{purchaseId}")
    public void cancel(@PathVariable("purchaseId") String purchaseId) {

        log.info("purchase-id : {}", purchaseId);
    }

}
