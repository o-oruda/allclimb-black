package io.ooruda.allclimb.module.database.entity.ticket.code.converter;

import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

import static io.ooruda.allclimb.module.database.entity.ticket.code.TicketType.*;

@Converter(autoApply = true)
public class TicketTypeConverter implements AttributeConverter<TicketType, String> {

    @Override
    public String convertToDatabaseColumn(TicketType ticketType) {
        return Optional.ofNullable(ticketType)
                .map(TicketType::getCode)
                .orElse(PERIOD.getCode());
    }

    @Override
    public TicketType convertToEntityAttribute(String s) {
        return fromCode(s);
    }
}
