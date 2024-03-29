package com.springsystem.domain;

import jdk.jfr.DataAmount;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long>{

    @NotBlank(message = "Insira um nome")
    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 60, message = "O nome deve ter entre {min} e {max} caracteres")
    private String nome;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal salario;

    @NotNull
    @PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_entrada", nullable = false, columnDefinition = "DATE")
    private LocalDate dataEntrada;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_saida", columnDefinition = "DATE")
    private LocalDate dataSaida;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private Endereco endereco;

    @NotNull(message = "{NotNull.funcionario.cargo}")
    @ManyToOne
    @JoinColumn(name = "cargo_id_fk")
    private Cargo cargo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
