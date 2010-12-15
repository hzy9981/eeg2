package cz.zcu.kiv.eegdatabase.data.dao;

import cz.zcu.kiv.eegdatabase.data.pojo.HearingImpairment;

import java.util.List;

public interface HearingImpairmentDao extends GenericDao<HearingImpairment, Integer> {
    public List<HearingImpairment> getItemsForList();
}