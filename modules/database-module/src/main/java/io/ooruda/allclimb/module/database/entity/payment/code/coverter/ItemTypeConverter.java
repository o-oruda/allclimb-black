package io.ooruda.allclimb.module.database.entity.payment.code.coverter;

import io.ooruda.allclimb.module.database.entity.payment.code.ItemType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class ItemTypeConverter implements AttributeConverter<ItemType, String> {

    @Override
    public String convertToDatabaseColumn(ItemType itemType) {
        return Optional.ofNullable(itemType)
                .map(ItemType::getCode)
                .orElse(null);
    }

    @Override
    public ItemType convertToEntityAttribute(String code) {
        return ItemType.fromCode(code);
    }
}
