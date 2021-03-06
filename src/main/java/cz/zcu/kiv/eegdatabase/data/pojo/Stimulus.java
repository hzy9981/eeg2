package cz.zcu.kiv.eegdatabase.data.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: stebjan
 * Date: 20.2.12
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name="STIMULUS")
public class Stimulus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STIMULUS_ID")
    private int stimulusId;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "stimulus")
    private Set<StimulusRel> stimulusRels = new HashSet<StimulusRel>(0);

    public Stimulus() {

    }

    public Stimulus(int stimulusId, String description) {
        this.stimulusId = stimulusId;
        this.description = description;
    }

    public int getStimulusId() {
        return stimulusId;
    }

    public void setStimulusId(int stimulusId) {
        this.stimulusId = stimulusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StimulusRel> getStimulusRels() {
        return stimulusRels;
    }

    public void setStimulusRels(Set<StimulusRel> stimulusRels) {
        this.stimulusRels = stimulusRels;
    }
}
