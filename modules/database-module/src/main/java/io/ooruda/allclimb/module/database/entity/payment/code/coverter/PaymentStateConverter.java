package io.ooruda.allclimb.module.database.entity.payment.code.coverter;

import io.ooruda.allclimb.module.database.entity.payment.code.PaymentState;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class PaymentStateConverter implements AttributeConverter<PaymentState, String> {

    @Override
    public String convertToDatabaseColumn(PaymentState paymentState) {
        return Optional.ofNullable(paymentState)
                .map(PaymentState::getCode)
                .orElse(null);
    }

    @Override
    public PaymentState convertToEntityAttribute(String code) {
        return PaymentState.fromCode(code);
    }
}
