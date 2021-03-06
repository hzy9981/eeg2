/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.zcu.kiv.eegdatabase.logic.controller.experiment;

import cz.zcu.kiv.eegdatabase.data.dao.GenericDao;
import cz.zcu.kiv.eegdatabase.data.dao.PersonDao;
import cz.zcu.kiv.eegdatabase.data.pojo.*;
import cz.zcu.kiv.eegdatabase.logic.util.ControllerUtils;
import cz.zcu.kiv.eegdatabase.logic.zip.Generator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Petr Jezek
 */
public class DownloadMetadataZipController extends SimpleFormController {

    private Generator zipGenerator;
    private Log log = LogFactory.getLog(getClass());
    private GenericDao<Experiment, Integer> experimentDao;
    private GenericDao<History, Integer> historyDao;
    private PersonDao personDao;

    public DownloadMetadataZipController() {
        setCommandClass(MetadataCommand.class);
        setCommandName("chooseMetadata");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        return super.formBackingObject(request);
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
//      //ModelAndView mav = new ModelAndView("downloadMetadataZipView");
        MetadataCommand mc = (MetadataCommand) command;
        int id = Integer.parseInt(request.getParameter("id"));
        Experiment fromDB = experimentDao.read(id);
        String scenarioName = fromDB.getScenario().getTitle();

        Set<DataFile> files = fromDB.getDataFiles();
        //gets a parameters from request
        //contents is in the request if user wants download data file
        String[] contents = request.getParameterValues("content");
        //fileParam represents file metadata params
        String[] fileParam = request.getParameterValues("fileParam");
        FileMetadataParamValId[] params = null;
        if (fileParam != null) {
            params = new FileMetadataParamValId[fileParam.length];
            //go throws parameters and creates FileMetadataParamsValId instances
            //in the request data_file_id and file_metadata_param_def_id is separated
            //by # in the form file_id#file_metadata_param_def_id
            //
            for (int i = 0; i < fileParam.length; i++) {
                String[] tmp = fileParam[i].split("#");
                params[i] = new FileMetadataParamValId(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[0]));
            }
        }
        Set<DataFile> newFiles = new HashSet<DataFile>();
        if (fileParam != null || contents != null) {
            //go over data files selected from db
            for (DataFile item : files) {
                DataFile newItem = null;
                if (contents != null) {
                    if (Arrays.asList(contents).contains(String.valueOf(item.getDataFileId()))) {
                        newItem = new DataFile();
                        newItem.setDataFileId(item.getDataFileId());
                        newItem.setExperiment(item.getExperiment());
                        newItem.setFileContent(item.getFileContent());
                        newItem.setFilename(item.getFilename());
                        newItem.setMimetype(item.getMimetype());
                        newItem.setDescription(item.getDescription());
                    }
                }
                Set<FileMetadataParamVal> newVals = new HashSet<FileMetadataParamVal>();
                if (params != null) {
                    for (FileMetadataParamVal paramVal : item.getFileMetadataParamVals()) {
                        for (FileMetadataParamValId paramId : params) {
                            if (paramVal.getId().getDataFileId() == paramId.getDataFileId() && paramVal.getId().getFileMetadataParamDefId() == paramId.getFileMetadataParamDefId()) {
                                newVals.add(paramVal);
                            }
                        }
                    }
                }
                if (!newVals.isEmpty()) {
                    if (newItem == null) {
                        newItem = new DataFile();
                    }
                    newItem.setFileMetadataParamVals(newVals);
                }
                if (newItem != null) {
                    newFiles.add(newItem);
                }
            }
        }
        Person user = personDao.getPerson(ControllerUtils.getLoggedUserName());
        Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        History history = new History();
        log.debug("Setting downloading metadata");
        history.setExperiment(fromDB);
        log.debug("Setting user");
        history.setPerson(user);
        log.debug("Setting time of download");
        history.setDateOfDownload(currentTimestamp);
        log.debug("Saving download history");
        historyDao.create(history);

        OutputStream out = getZipGenerator().generate(fromDB, mc, newFiles);

        response.setHeader("Content-Type", "application/zip");
        if (scenarioName == null) {
            response.setHeader("Content-Disposition", "attachment;filename=Experiment_data.zip");
        } else {
            String[] names = scenarioName.split(" ");
            scenarioName = names[0];
            for (int i = 1; i < names.length; i++) {
                scenarioName += "_" + names[i];

            }
            response.setHeader("Content-Disposition", "attachment;filename=" + scenarioName + ".zip");
        }

        if (out instanceof ByteArrayOutputStream) {
            ByteArrayOutputStream bout = (ByteArrayOutputStream) out;
            response.getOutputStream().write(bout.toByteArray());
        }
        log.debug(zipGenerator);
        return null;
    }

    /**
     * @return the zipGenerator
     */
    public Generator getZipGenerator() {
        return zipGenerator;
    }

    /**
     * @param generator the zipGenerator to set
     */
    public void setZipGenerator(Generator generator) {
        this.zipGenerator = generator;
    }

    public GenericDao<Experiment, Integer> getExperimentDao() {
        return experimentDao;
    }

    public void setExperimentDao(GenericDao<Experiment, Integer> experimentDao) {
        this.experimentDao = experimentDao;
    }

    public GenericDao<History, Integer> getHistoryDao() {
        return historyDao;
    }

    public void setHistoryDao(GenericDao<History, Integer> historyDao) {
        this.historyDao = historyDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
