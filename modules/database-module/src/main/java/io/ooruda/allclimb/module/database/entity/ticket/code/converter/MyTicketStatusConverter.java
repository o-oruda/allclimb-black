package io.ooruda.allclimb.module.database.entity.ticket.code.converter;

import io.ooruda.allclimb.module.database.entity.ticket.code.MyTicketStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

import static io.ooruda.allclimb.module.database.entity.ticket.code.MyTicketStatus.*;

@Converter(autoApply = true)
public class MyTicketStatusConverter implements AttributeConverter<MyTicketStatus, String> {

    @Override
    public String convertToDatabaseColumn(MyTicketStatus myTicketStatus) {
        return Optional.ofNullable(myTicketStatus)
                .map(MyTicketStatus::getCode)
                .orElse(READY.getCode());
    }

    @Override
    public MyTicketStatus convertToEntityAttribute(String code) {
        return fromCode(code);
    }
}
