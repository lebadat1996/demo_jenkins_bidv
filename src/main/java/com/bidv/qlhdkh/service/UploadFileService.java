package com.bidv.qlhdkh.service;

import com.bidv.qlhdkh.model.LstDocument;

public interface UploadFileService {
    void createDocument(LstDocument lstDocument, int caseId) throws Exception;

    LstDocument getListDoc(int caseId);
}
