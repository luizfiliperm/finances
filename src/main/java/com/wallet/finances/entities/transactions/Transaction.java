package com.wallet.finances.entities.transactions;

import com.wallet.finances.entities.wallet.Wallet;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Transaction {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id")
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "value")
        private BigDecimal value;
        @Column(name = "date")
        private Date date;
        @ManyToOne
        @JoinColumn(name = "wallet_id")
        private Wallet wallet;

        public Transaction(){}

        public Transaction(Long id, String name, BigDecimal value, Date date) {
                this.id = id;
                this.name = name;
                this.value = value;
                this.date = date;
        }
        //getters and setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public BigDecimal getValue() {
                return value;
        }

        public void setValue(BigDecimal value) {
                this.value = value;
        }

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }
}
