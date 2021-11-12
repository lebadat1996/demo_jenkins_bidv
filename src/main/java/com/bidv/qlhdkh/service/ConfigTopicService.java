package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.model.CaseInfoModel;
import com.bidv.qlhdkh.model.ConfigTopic;
import com.bidv.qlhdkh.model.ResponseFile;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ConfigTopicService {
    List<ConfigTopic> listConfigTopic();

    void generatePDF() throws JRException, IOException;

    void exportPDFDataReport(String path) throws FileNotFoundException, JRException;

    ResponseFile generateFilePdf(CaseInfoModel caseInfoModel) throws IOException, JRException;;


}
