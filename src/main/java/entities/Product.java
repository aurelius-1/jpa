package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
//@Table(name = "product")
public class Product {

    @Id
    private int id;

    @Basic(optional = false)
    private String name;
//    /private double price;

//    @Column(name = "expiration_date")
//    private LocalDate expirationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

//    public LocalDate getExpirationDate() {
//        return expirationDate;
//    }
//
//    public void setExpirationDate(LocalDate expirationDate) {
//        this.expirationDate = expirationDate;
//    }
}
