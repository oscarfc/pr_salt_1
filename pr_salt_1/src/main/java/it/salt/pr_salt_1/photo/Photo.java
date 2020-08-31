/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.salt.pr_salt_1.photo;

import it.salt.pr_salt_1.AbstractEntity;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author oscar.favero
 */
@NamedQueries({
    @NamedQuery(name = Photo.FIND_ALL, query = "select e from Photo e order by e.createdOn DESC"),
    @NamedQuery(name = Photo.FIND_BY_SITE, query = "select e from Photo e where e.site= :site order by e.date, e.time DESC"),
    @NamedQuery(name = Photo.FIND_BY_ID_AND_SITE, query = "select e from Photo e where e.id= :id and e.site= :site"),})

@Entity
@Table(name = "photo")
public class Photo extends AbstractEntity {

    public static final String FIND_ALL = "Photo.findAll";
    public static final String FIND_BY_SITE = "Photo.findBySite";
    public static final String FIND_BY_ID_AND_SITE = "Photo.findByIdAndSite";

    @NotEmpty
    @Column(name = "site", nullable = false)
    private String site;

    @NotEmpty
    @Column(name = "camera", nullable = false)
    private Integer camera;

    @NotEmpty
    @Column(name = "date", nullable = false)
    private Date date;

    @NotEmpty
    @Column(name = "time", nullable = false)
    private Time time;

    @NotEmpty
    @Column(name = "photo_path", nullable = false)
    private String photoPath;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getCamera() {
        return camera;
    }

    public void setCamera(Integer camera) {
        this.camera = camera;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

}
