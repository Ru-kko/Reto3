package com.fincas.app.crud.clients;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fincas.app.crud.messages.messageEntity;
import com.fincas.app.crud.reservations.reservationEntity;

@Entity
@Table(name="CLIENTS")
public class clientEntity {
    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String email;   
    private String password;
    private String name;
    private Integer age;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<messageEntity> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<reservationEntity> reservations;
    
    public clientEntity(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    /** Empty constructor */
    public clientEntity(){}
    
    public Long getIdClient() {
        return idClient;
    }
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    public List<reservationEntity> getReservations() {
        return reservations;
    }
    public List<messageEntity> getMessages() {
        return messages;
    }
    public void setMessages(List<messageEntity> messages) {
        this.messages = messages;
    }
    public void setReservations(List<reservationEntity> reservations) {
        this.reservations = reservations;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
