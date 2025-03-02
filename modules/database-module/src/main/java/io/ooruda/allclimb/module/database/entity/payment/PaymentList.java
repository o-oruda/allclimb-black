package io.ooruda.allclimb.module.database.entity.payment;

import io.ooruda.allclimb.module.database.entity.BaseEntity;
import io.ooruda.allclimb.module.database.entity.payment.code.ItemType;
import io.ooruda.allclimb.module.database.entity.payment.code.PaymentMethod;
import io.ooruda.allclimb.module.database.entity.payment.code.PaymentState;
import io.ooruda.allclimb.module.database.entity.payment.code.PaymentType;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "payment_list")
public class PaymentList extends BaseEntity {

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "item_type")
    private ItemType itemType; // T - ticket

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_code")
    private String itemCode; // {itemType}-{itemId} ex) TICKET-1

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity")
    private BigDecimal quantity; // 수량

    @Column(name = "price")
    private BigDecimal price; // 가격

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "state")
    private PaymentState state;

    @Column(name = "request_body")
    private String requestBody;

    public static PaymentList from(long memId, TicketInfo ticketInfo) {

        return PaymentList.builder()
                .memberId(memId)
                .paymentMethod(PaymentMethod.KAKAO)
                .paymentType(PaymentType.PAYMENT)
                .itemType(ItemType.TICKET)
                .itemId(ticketInfo.getId())
                .itemCode(makeItemCode(ItemType.TICKET, ticketInfo.getId()))
                .itemName(ticketInfo.getName())
                .quantity(BigDecimal.ONE)
                .price(ticketInfo.getPrice())
                .totalPrice(ticketInfo.getPrice()) // FIXME
                .state(PaymentState.READY)
                .build();
    }

    private static String makeItemCode(ItemType itemType, long id) {
        return itemType.name() + "_" + id;
    }

}
