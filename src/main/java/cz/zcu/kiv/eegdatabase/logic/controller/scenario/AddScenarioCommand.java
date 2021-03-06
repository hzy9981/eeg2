package cz.zcu.kiv.eegdatabase.logic.controller.scenario;

import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

public class AddScenarioCommand {

    private int id;
    private int researchGroup;
    private String title;
    private String length;
    private String description;
    private MultipartFile dataFile;
    private MultipartFile dataFileXml;
    private boolean privateNote;
    private int scenarioSchema;
    private boolean dataFileAvailable;
    private boolean xmlFileCheckBox;
    private String scenarioOption;
    private String schemaDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResearchGroup() {
        return researchGroup;
    }

    public void setResearchGroup(int researchGroup) {
        this.researchGroup = researchGroup;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getDataFile() {
        return dataFile;
    }

    public void setDataFile(MultipartFile dataFile) {
        this.dataFile = dataFile;
    }

    public boolean getPrivateNote() {
        return this.privateNote;
    }

    public void setPrivateNote(boolean privateNote) {
        this.privateNote = privateNote;
    }

    public int getScenarioSchema() {
      return scenarioSchema;
    }

    public void setScenarioSchema(int scenarioSchema) {
      this.scenarioSchema = scenarioSchema;
    }

    public boolean isDataFileAvailable() {
        return dataFileAvailable;
    }

    public void setDataFileAvailable(boolean dataFileAvailable) {
        this.dataFileAvailable = dataFileAvailable;
    }

    public MultipartFile getDataFileXml() {
      return dataFileXml;
    }

    public void setDataFileXml(MultipartFile dataFileXml) {
      this.dataFileXml = dataFileXml;
    }

    public boolean isXmlFileCheckBox() {
        return xmlFileCheckBox;
    }

    public void setXmlFileCheckBox(boolean xmlFileCheckBox) {
        this.xmlFileCheckBox = xmlFileCheckBox;
    }

    public String getScenarioOption() {
        return scenarioOption;
    }

    public void setScenarioOption(String scenarioOption) {
        this.scenarioOption = scenarioOption;
    }

    public String getSchemaDescription() {
        return schemaDescription;
    }

    public void setSchemaDescription(String schemaDescription) {
        this.schemaDescription = schemaDescription;
    }

}
