package com.portal.business.commons.models;

import com.portal.business.commons.exceptions.TableNotFoundException;
import com.portal.business.commons.generic.RemittenceEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "profile")
public class Profile extends RemittenceEntity implements Serializable {

    public static Long ADMINISTRATOR = 1L;
    public static Long STORE = 2L;
    public static Long REMITTANCE_OPERATOR = 3L;
    public static Long COMMERCIAL_ANALYST = 4L;
    public static Long COMPLIANCE_OFFICER = 5L;
    public static Long SELLER = 6L;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean enabled;
    private String name;
    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    private List<PermissionHasProfile> permissionHasProfiles;
    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<ProfileData> profileData;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ReportHasProfile> reportHasProfiles;

    public Profile() {
    }

    public Profile(Long id, boolean enabled, String name) {
        this.id = id;
        this.enabled = enabled;
        this.name = name;
    }

    public Profile(Long id, boolean enabled, String name, List<PermissionHasProfile> permissionHasProfiles, List<ProfileData> profileData, List<ReportHasProfile> reportHasProfiles) {
        this.id = id;
        this.enabled = enabled;
        this.name = name;
        this.permissionHasProfiles = permissionHasProfiles;
        this.profileData = profileData;
        this.reportHasProfiles = reportHasProfiles;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionHasProfile> getPermissionHasProfiles() {
        return this.permissionHasProfiles;
    }

    public void setPermissionHasProfiles(List<PermissionHasProfile> permissionHasProfiles) {
        this.permissionHasProfiles = permissionHasProfiles;
    }

    public List<ProfileData> getProfileData() {
        return this.profileData;
    }

    public void setProfileData(List<ProfileData> profileData) {
        this.profileData = profileData;
    }

    public List<ReportHasProfile> getReportHasProfiles() {
        return this.reportHasProfiles;
    }

    public void setReportHasProfiles(List<ReportHasProfile> reportHasProfiles) {
        this.reportHasProfiles = reportHasProfiles;
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

    public ProfileData getProfileDataByLanguageId(Long languageId) {
        ProfileData pd = null;
        for (ProfileData pData : this.profileData) {
            if (pData.getLanguage().getId().equals(languageId)) {
                pd = pData;
                break;
            }
        }
        return pd;
    }
    
    @Override
    public boolean equals(Object other) {
        return (other instanceof Profile) && (id != null)
            ? id.equals(((Profile) other).id)
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
            ? (this.getClass().hashCode() + id.hashCode())
            : super.hashCode();
    }
    
}
