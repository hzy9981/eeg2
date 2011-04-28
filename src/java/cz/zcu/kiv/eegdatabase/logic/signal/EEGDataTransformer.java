package cz.zcu.kiv.eegdatabase.logic.signal;

import cz.zcu.kiv.eegdatabase.data.pojo.DataFile;
import cz.zcu.kiv.eegdatabase.data.pojo.Experiment;

import java.sql.SQLException;
import java.util.Set;

public class EEGDataTransformer implements DataTransformer {

    public boolean isSuitableExperiment(Experiment e) {
        boolean vhdr = false;
        boolean eeg = false;
        Set<DataFile> files = e.getDataFiles();
        for (DataFile file: files) {
            if (file.getFilename().endsWith(".vhdr")) {
                vhdr = true;
            }
            if ((file.getFilename().endsWith(".eeg")) || (file.getFilename().endsWith(".avg"))) {
                eeg = true;
            }
        }
        return (vhdr && eeg);
    }

    public double[] transformExperimentalData(Experiment e) throws SQLException {
        VhdrReader r = new VhdrReader();
        EegReader eeg;
        DataFile vhdr = null;
        DataFile vmrk = null;
        DataFile binaryFile = null;
        for (DataFile file: e.getDataFiles()) {
            if (file.getFilename().endsWith(".vhdr")) {
                vhdr = file;
            }
            if (file.getFilename().endsWith(".vmrk")) {
                vmrk = file;
            }
        }
        r.readVhdr(vhdr);
        for (DataFile file : e.getDataFiles()) {
            if (file.getFilename().equals(r.getProperties().get("CI").get("DataFile"))) {
                binaryFile = file;
                break;
            }
        }
        if (vmrk != null) {
            r.readVmrk(vmrk);
        }
        eeg = new EegReader(r);
        return eeg.readFile(binaryFile);
    }
}