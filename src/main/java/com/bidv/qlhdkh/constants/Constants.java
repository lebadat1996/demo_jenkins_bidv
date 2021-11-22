package com.bidv.qlhdkh.constants;

import lombok.Data;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@Configuration
@Data
public class Constants {
    @Value("classpath:report/Form1.jrxml")
    String resourceFile;
    @Value("classpath:report/Form8.jrxml")
    String resourceFile1;
    @Value("classpath:report/Form11.jrxml")
    String resourceFile2;
    @Value("classpath:content/emailContent.html")
    Resource contentEmail;
    @Value("${email.link}")
    String emailLink;
    @Value("${service.bidv.day.I}")
    Integer dayI;
    @Value("${service.bidv.month.I}")
    Integer monthI;
    @Value("${service.bidv.day.I.I}")
    Integer dayO;
    @Value("${service.bidv.month.I.I}")
    Integer monthO;
    @Value("${service.bidv.day.II}")
    Integer dayII;
    @Value("${service.bidv.month.II}")
    Integer monthII;
    @Value("${service.bidv.day.II.I}")
    Integer dayT;
    @Value("${service.bidv.month.II.I}")
    Integer monthT;
    @Value("${spring.mail.username}")
    String userName;
    @Value("${spring.mail.password}")
    String password;
    @Value("${spring.mail.host}")
    String hostEmail;
    @Value("${spring.mail.port}")
    int portEmail;
    @Value("${service.bidv.wsEndPoint}")
    String webEndpoint;
    @Value("${service.bidv.environment}")
    String environment;
    @Value("${service.bidv.role.tt}")
    String roleTT;
    @Value("${service.bidv.role.qlkh}")
    String roledm;
    //connect FileNet
    @Value("${com.bidv.uri}")
    String uri;
    @Value("${com.bidv.osName}")
    String osName;
    @Value("${com.bidv.stanza}")
    String stanza;
    @Value("${com.bidv.userName}")
    String user;
    @Value("${com.bidv.passWord}")
    String pass;
    @Value("${com.bidv.login.user}")
    String userLogin;
    @Value("${com.bidv.login.password}")
    String passLogin;
    @Value("${com.bidv.folder.upload}")
    String pathUpload;
    @Value("${com.bidv.link.cookie}")
    String linkCookie;
    public static final String ROLE_TK = "Thư ký";
    public static final String ROLE_CTHD = "Chủ tịch Hội đồng";
    public static final String RESPONSE_ERROR_EMAIL = "Error Send Mail Success";
    public static final String RESPONSE_EMAIL = "Send Mail Success";
    public static final String TYPE = "String";
    public static final String RESPONSE_REPORT = "Generate Report Success";
    public static final String RESPONSE_ERROR_REPORT = "Error Not Found Data";
    public static final String RESPONSE_SAVE_ESTIMATE = "Save Estimate Success";
    public static final String RESPONSE_ERROR_SAVE_ESTIMATE = "Error Save Estimate Success";
    public static final String RESPONSE_ERROR_FIND_DATA = "Not Found Data";
    public static final String RESPONSE_ERROR_GEN_CODE = " Error genCode";
    public static final String XDTC_KHCN_HT = "XDTC_KHCN_HT";
    public static final String XDTC_KHCN_CS = "XDTC_KHCN_CS";
    public static final String NT_KHCN_HT = "NT_KHCN_HT";
    public static final String NT_KHCN_CS = "NT_KHCN_CS";
    public static final String KSTDTH_HT_DNL = "KSTDTH_HT_DNL";
    public static final String KSTDTH_HT_DND = "KSTDTH_HT_DND";
    public static final String KSTDTH_HT_DNDC = "KSTDTH_HT_DNDC";
    public static final String KSTDTH_CS_DNL = "KSTDTH_CS_DNL";
    public static final String KSTDTH_CS_DND = "KSTDTH_CS_DND";
    public static final String KSTDTH_CS_DNDC = "KSTDTH_CS_DNDC";
    public static final String DN_CTLSK_CS = "DN_CTLSK_CS";
    public static final String DN_CTLSK_HT = "DN_CTLSK_HT";
    public static final String BCNT_KHCN_CS = "BCNT_KHCN_CS";
    public static final String BCNT_KHCN_HT = "BCNT_KHCN_HT";
    public static final String NVHT08 = "NVHT08";
    public static final String NVCS08 = "NVCS08";
    public static final String NVCS09 = "NVCS09";
    public static final String NVCS10 = "NVCS10";
    public static final String NVHT09 = "NVHT09";
    public static final String NVHT10 = "NVHT10";
    public static final String BCCN_KHCN_HT = "BCCN_KHCN_HT";
    public static final String BCCN_KHCN_CS = "BCCN_KHCN_CS";
    public static final String SKCS06 = "SKCS06";
    public static final String SKHT06 = "SKHT06";
    public static final String SKCS07 = "SKCS07";
    public static final String SKHT07 = "SKHT07";
    public static final String SKCS08 = "SKCS08";
    public static final String SKHT08 = "SKHT08";
    public static final String CN = "Chủ nhiệm";
    public static final String TK = "Thư ký";
    public static final String TG = "Tác giả/đồng tác giả";
    public static final String CHECK_NULL = "Giải pháp không xác định được số tiền làm lợi";


    public <F, T> T fromTo(F input, Class<T> destinationClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(input, destinationClass);
    }

    public <F, T> List<T> fromToList(List<F> input, Class<T> destinationClass) {
        return input.stream().map(item -> fromTo(item, destinationClass)).collect(Collectors.toList());

    }

    public <F, T> void dtoToEntity(F dto, T entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
    }

    public <F, T> T fromToNotAmbiguity(F input, Class<T> destinationClass) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(input, destinationClass);
    }
}
