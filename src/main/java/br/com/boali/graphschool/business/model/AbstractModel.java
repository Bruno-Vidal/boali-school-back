package br.com.boali.graphschool.business.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abs")
@Data
@NoArgsConstructor
public class AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
}
