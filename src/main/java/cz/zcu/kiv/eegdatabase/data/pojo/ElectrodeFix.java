package cz.zcu.kiv.eegdatabase.data.pojo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: stebjan
 * Date: 1.3.12
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class ElectrodeFix implements Serializable {

    private int electrodeFixId;
    private String title;
    private String description;
    private int defaultNumber;

    public ElectrodeFix() {
    }

    public int getElectrodeFixId() {
        return electrodeFixId;
    }

    public void setElectrodeFixId(int electrodeFixId) {
        this.electrodeFixId = electrodeFixId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDefaultNumber() {
        return defaultNumber;
    }

    public void setDefaultNumber(int defaultNumber) {
        this.defaultNumber = defaultNumber;
    }

}