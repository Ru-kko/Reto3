package com.fincas.app.crud.farms;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fincas.app.crud.category.categoryEntity;
import com.fincas.app.crud.messages.messageEntity;
import com.fincas.app.crud.reservations.reservationEntity;

@Entity
@Table(name="FARMS")
public class farmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String address;
    private Integer extension;
    private String description;  
    
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("farms")
    private categoryEntity category;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "farm")
    @JsonIgnoreProperties({"farm", "client"})
    private List<messageEntity> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "farm")
    @JsonIgnoreProperties("farm")
    private List<reservationEntity> reservations;
    
    public farmEntity(String address, Integer extension, String name, String description) {
        this.address = address;
        this.extension = extension;
        this.name = name;
        this.description = description;
    }
    /** Empty constructor */
    public farmEntity(){}
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public List<messageEntity> getMessages() {
        return messages;
    }
    public List<reservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<reservationEntity> reservations) {
        this.reservations = reservations;
    }
    public void setMessages(List<messageEntity> messages) {
        this.messages = messages;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getExtension() {
        return extension;
    }
    public void setExtension(Integer exension) {
        this.extension = exension;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public categoryEntity getCategory() {
        return category;
    }
    public void setCategory(categoryEntity category) {
        this.category = category;
    }
}
