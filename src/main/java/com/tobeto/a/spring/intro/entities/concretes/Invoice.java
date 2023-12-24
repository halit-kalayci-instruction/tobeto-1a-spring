package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice extends BaseEntity {
    @Column(name="invoice_no")
    private String invoiceNo;
    @Column(name="total_price")
    private Float totalPrice;
    @Column(name="discount_rate")
    private Float discountRate;
    @Column(name="tax_rate")
    private Float taxRate;

    @ManyToOne
    @JoinColumn(name="rental_id")
    private Rental rental;
}
