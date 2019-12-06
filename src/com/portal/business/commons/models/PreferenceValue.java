package com.portal.business.commons.models;

import com.portal.business.commons.exceptions.TableNotFoundException;
import com.portal.business.commons.generic.RemittenceEntity;
import com.portal.business.commons.utils.QueryConstants;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "preference_value")
@NamedQueries({
    @NamedQuery(name = QueryConstants.PREFERENCE_VALUE_BY_PREFERENCE_FIELD,
    query = "SELECT pv FROM PreferenceValue pv WHERE pv.preferenceField.id=:preferenceFieldId AND pv.enterprise.id=:enterpriseId AND pv.endingDate IS NULL ORDER BY pv.id DESC")
})
public class PreferenceValue extends RemittenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp beginningDate;
    private Timestamp endingDate;
    private String value;
    @ManyToOne
    @JoinColumn(name = "enterpriseId")
    private Enterprise enterprise;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "preferenceFieldId")
    private PreferenceField preferenceField;

    public PreferenceValue() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getBeginningDate() {
        return this.beginningDate;
    }

    public void setBeginningDate(Timestamp beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Timestamp getEndingDate() {
        return this.endingDate;
    }

    public void setEndingDate(Timestamp endingDate) {
        this.endingDate = endingDate;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PreferenceField getPreferenceField() {
        return preferenceField;
    }

    public void setPreferenceField(PreferenceField preferenceField) {
        this.preferenceField = preferenceField;
    }

    public Enterprise getEnterprise() {
        return this.enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public String toString() {
        return super.toString();
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
        final PreferenceValue other = (PreferenceValue) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
