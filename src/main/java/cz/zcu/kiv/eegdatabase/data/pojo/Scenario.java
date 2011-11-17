package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 19.1.2010 23:18:53 by Hibernate Tools 3.2.1.GA

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.annotations.Entity;
import org.hibernate.search.annotations.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Scenario generated by hbm2java
 */
@Entity
@Indexed
@Analyzer(impl = StandardAnalyzer.class)
public class Scenario implements Serializable, Comparable<Scenario> {

    @DocumentId
    private int scenarioId;
    private Person person;
    private ResearchGroup researchGroup;
    @Fields({
            @Field(name = "title"),
            @Field(store = Store.YES)}) //use a different field name
    private String title;
    @Fields({
            @Field(name = "scenarioLength"),
            @Field(store = Store.YES)})
    private int scenarioLength;
    //private Blob scenarioXml;
    @Fields({
            @Field(name = "description"),
            @Field(store = Store.YES)}) //use a different field name
    private String description;
    private Set<Experiment> experiments = new HashSet<Experiment>(0);
    private Set<History> histories = new HashSet<History>(0);
    private boolean privateScenario;
    private boolean userMemberOfGroup;
    private String scenarioName;
    private String mimetype;

    private IScenarioType scenarioType;
    private long scn;

    public Scenario() {
    }

    public Scenario(int scenarioId, Person person, ResearchGroup researchGroup) {
        this.scenarioId = scenarioId;
        this.person = person;
        this.researchGroup = researchGroup;
    }

    public Scenario(int scenarioId, Person person, ResearchGroup researchGroup,
                    String title, int scenarioLength, String description,
                    Set<Experiment> experiments, IScenarioType scenarioType) {
        this.scenarioId = scenarioId;
        this.person = person;
        this.researchGroup = researchGroup;
        this.title = title;
        this.scenarioLength = scenarioLength;
        this.description = description;
        this.experiments = experiments;
        this.scenarioType = scenarioType;
    }

    public int getScenarioId() {
        return this.scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ResearchGroup getResearchGroup() {
        return this.researchGroup;
    }

    public void setResearchGroup(ResearchGroup researchGroup) {
        this.researchGroup = researchGroup;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScenarioLength() {
        return this.scenarioLength;
    }

    public void setScenarioLength(int scenarioLength) {
        this.scenarioLength = scenarioLength;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getScn() {
        return scn;
    }

    public Set<Experiment> getExperiments() {
        return this.experiments;
    }

    public void setExperiments(Set<Experiment> experiments) {
        this.experiments = experiments;
    }

    public void setPrivateScenario(boolean privateScenario) {
        this.privateScenario = privateScenario;
    }

    public boolean isPrivateScenario() {
        return this.privateScenario;
    }

    public void setUserMemberOfGroup(boolean userIsMember) {
        this.userMemberOfGroup = userIsMember;
    }

    public boolean isUserMemberOfGroup() {
        return userMemberOfGroup;
    }

    public Set<History> getHistories() {
        return histories;
    }

    public void setHistories(Set<History> histories) {
        this.histories = histories;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public IScenarioType getScenarioType() {
        return scenarioType;
    }

    public void setScenarioType(IScenarioType scenarioDoc) {
        this.scenarioType = scenarioDoc;
    }
    public int compareTo(Scenario scen) {
        return this.title.compareTo(scen.getTitle());
    }
}


