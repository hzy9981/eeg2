package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 19.1.2010 23:18:53 by Hibernate Tools 3.2.1.GA

import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Weather generated by hbm2java
 */
@Indexed
@Entity
@javax.persistence.Table(name="WEATHER")
public class Weather implements Serializable {
    @DocumentId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WEATHER_ID")
    private int weatherId;
    @Fields({
            @Field(index = Index.TOKENIZED), //same property indexed multiple times
            @Field(name = "description")}) //use a different field name
    @Column(name = "DESCRIPTION")
    private String description;
    @Fields({
            @Field(index = Index.TOKENIZED), //same property indexed multiple times
            @Field(name = "title")}) //use a different field name
    @Column(name = "TITLE")
    private String title;
    @OneToMany(mappedBy = "weather")
    private Set<Experiment> experiments = new HashSet<Experiment>(0);
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ResearchGroup> researchGroups = new HashSet<ResearchGroup>(0);
    @OneToMany(mappedBy = "weather")
    private Set<WeatherGroupRel> weatherGroupRels = new HashSet<WeatherGroupRel>(0);
    @Column(name = "ORA_ROWSCN", insertable = false, updatable = false)
    private long scn;
    @Column(name = "IS_DEFAULT")
    private int defaultNumber;

    public Weather() {
    }

    public Weather(int weatherId, String title) {
        this.weatherId = weatherId;
        this.title = title;
    }

    public Weather(int weatherId, String description, String title, Set<Experiment> experiments) {
        this.weatherId = weatherId;
        this.description = description;
        this.title = title;
        this.experiments = experiments;
    }

    public int getWeatherId() {
        return this.weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public long getScn() {
        return scn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Experiment> getExperiments() {
        return this.experiments;
    }

    public Set<ResearchGroup> getResearchGroups() {
        return researchGroups;
    }

    public void setResearchGroups(Set<ResearchGroup> researchGroups) {
        this.researchGroups = researchGroups;
    }

    public Set<WeatherGroupRel> getWeatherGroupRels() {
        return weatherGroupRels;
    }

    public void setWeatherGroupRels(Set<WeatherGroupRel> weatherGroupRels) {
        this.weatherGroupRels = weatherGroupRels;
    }

    public int getDefaultNumber() {
        return defaultNumber;
    }

    public void setDefaultNumber(int defaultNumber) {
        this.defaultNumber = defaultNumber;
    }

    public void setExperiments(Set<Experiment> experiments) {
        this.experiments = experiments;
    }
}


