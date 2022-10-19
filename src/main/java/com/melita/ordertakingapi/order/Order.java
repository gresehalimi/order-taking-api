package com.melita.ordertakingapi.order;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "order_list")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateTimeInstallation;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProductCategory> orderProductCategories;
    @CreationTimestamp
    private Instant createdAt;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private OrderCustomer orderCustomer;

    @PrePersist
    void ensureLinks() {
        orderProductCategories.forEach(opc -> opc.setOrder(this));
        if (orderCustomer != null) {
            orderCustomer.setOrder(this);
            orderCustomer.setOrderId(id);
        }
    }
}

