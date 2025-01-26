package br.com.contato12.entity;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="td_users")
public class UserEntity extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    public String name;

}

// Quarkus recomenda o padrão Active Record Pattern para acesso a banco de dados. Digerente do Spring que recomenda o Repository Pattern.