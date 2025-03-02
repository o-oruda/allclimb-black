package io.ooruda.allclimb.module.database.entity.payment.code.coverter;

import io.ooruda.allclimb.module.database.entity.payment.code.PaymentType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class PaymentTypeConverter implements AttributeConverter<PaymentType, String> {

    @Override
    public String convertToDatabaseColumn(PaymentType paymentType) {
        return Optional.ofNullable(paymentType)
                .map(PaymentType::getCode)
                .orElse(null);
    }

    @Override
    public PaymentType convertToEntityAttribute(String code) {
        return PaymentType.fromCode(code);
    }
}
