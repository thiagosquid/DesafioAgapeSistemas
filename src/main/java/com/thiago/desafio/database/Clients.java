package com.thiago.desafio.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
public class Clients implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty(message = "Campo obrigatorio")
    @Length(max=40, message="Excedeu o número de caracteres")
    private String name;
    @NotEmpty(message = "Campo obrigatorio")
    @Length(max=14)
    private String CPF;
    
    @NotEmpty(message = "Campo obrigatorio")
    @Length(max=17)
    private String RG;
    private String birthdate; //verificar se é esse tipo mesmo
    
    @NotEmpty(message = "Campo obrigatorio")
    @Length(max=40, message="Excedeu o número de caracteres")
    private String address;
    
    @Length(max=20, message="Excedeu o número de caracteres")
    private String complement;
    
    @NotEmpty(message = "Campo obrigatorio")
    @Length(max=20, message="Excedeu o número de caracteres")
    private String district;
    
    @Max(value=99999999)
    private Integer CEP; // possibilidade mudar para String
    
    @NotEmpty(message = "Campo obrigatorio")
    @Length(max=20, message="Excedeu o número de caracteres")
    private String city;
    
    @NotEmpty(message = "Campo obrigatorio")
    @Length(min=2, max=2, message="Excedeu o número de caracteres")
    private String UF;
    
    @Column(nullable = true)
    @Length(max=13, message="Excedeu o número de caracteres")
    private String phone;
    
    @NotEmpty(message = "Campo obrigatorio")
    @Length(max=15, message="Excedeu o número de caracteres")
    private String cellphone;
    
    @Length(max=150, message="Excedeu o número de caracteres")
    private String observation;

    public Clients() {
    }

    public Clients(Integer id, String name, String CPF, String RG, String birthdate, String address, String complement, String district, Integer CEP, String city, String UF, String phone, String cellphone, String observation) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.RG = RG;
        this.birthdate = birthdate;
        this.address = address;
        this.complement = complement;
        this.district = district;
        this.CEP = CEP;
        this.city = city;
        this.UF = UF;
        this.phone = phone;
        this.cellphone = cellphone;
        this.observation = observation;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer code) {
        this.id = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCEP() {
        return CEP;
    }

    public void setCEP(Integer CEP) {
        this.CEP = CEP;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clients other = (Clients) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clients{" + "id=" + id + ", name=" + name + ", CPF=" + CPF + ", RG=" + RG + ", birthdate=" + birthdate + ", address=" + address + ", complement=" + complement + ", district=" + district + ", CEP=" + CEP + ", city=" + city + ", UF=" + UF + ", phone=" + phone + ", cellphone=" + cellphone + ", observation=" + observation + '}';
    }

    
    
    
    
}
