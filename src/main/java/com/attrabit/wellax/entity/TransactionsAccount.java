package com.attrabit.wellax.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_transactions_account")
public class TransactionsAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
