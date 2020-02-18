package com.portal.business.commons.models;

import com.portal.business.commons.exceptions.TableNotFoundException;
import com.portal.business.commons.generic.RemittenceEntity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_method")
public class PaymentMethod extends RemittenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final Long CASH = 1L;
    public static final Long BANK_ACCOUNT = 2L;
    public static final Long ALODIGA_ACCOUNT = 3L;


    public PaymentMethod() {
    }
    @Id
    private Long id;
    private String name;
    private boolean enabled;
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    

    @Override
    public String toString() {
        return "RechargeType{ id=" + this.id + ",name=" + this.name + " }";

    }
    
    @Override
    public Object getPk() {
        return getId();
    }


    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PaymentMethod other = (PaymentMethod) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}