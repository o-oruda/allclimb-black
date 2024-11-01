package io.ooruda.allclimb.module.database.entity.ticket.code.converter;

import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

import static io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus.*;

@Converter(autoApply = true)
public class SaleStatusConverter implements AttributeConverter<SaleStatus, String> {

    @Override
    public String convertToDatabaseColumn(SaleStatus saleStatus) {
        return Optional.ofNullable(saleStatus)
                .map(SaleStatus::getCode)
                .orElse(OFF_SALE.getCode());
    }

    @Override
    public SaleStatus convertToEntityAttribute(String code) {
        return fromCode(code);
    }
}
