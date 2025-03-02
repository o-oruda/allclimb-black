package io.ooruda.allclimb.module.database.entity.payment.code.coverter;

import io.ooruda.allclimb.module.database.entity.payment.code.PaymentMethod;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class PaymentMethodConverter implements AttributeConverter<PaymentMethod, String> {

    @Override
    public String convertToDatabaseColumn(PaymentMethod paymentMethod) {
        return Optional.ofNullable(paymentMethod)
                .map(PaymentMethod::getCode)
                .orElse(null);
    }

    @Override
    public PaymentMethod convertToEntityAttribute(String code) {
        return PaymentMethod.fromCode(code);
    }
}
