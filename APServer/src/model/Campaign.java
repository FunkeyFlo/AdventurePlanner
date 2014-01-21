/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Flo
 */
public class Campaign implements java.io.Serializable {
    
    private Integer campaignId, access;
    private String campaignName, rpgName, description;

    public Campaign(Integer campaignId, Integer access, String campaignName,
            String rpgName, String description) {
        this.campaignId = campaignId;
        this.access = access;
        this.campaignName = campaignName;
        this.rpgName = rpgName;
        this.description = description;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getRpgName() {
        return rpgName;
    }

    public void setRpgName(String rpgName) {
        this.rpgName = rpgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
        return getCampaignName();
    }
}