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
    
    private Integer id, access;
    private String name, rpgName, description;

    public Campaign(Integer id, Integer access, String name,
            String rpgName, String description) {
        this.id = id;
        this.access = access;
        this.name = name;
        this.rpgName = rpgName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer campaignId) {
        this.id = campaignId;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return getName();
    }
}