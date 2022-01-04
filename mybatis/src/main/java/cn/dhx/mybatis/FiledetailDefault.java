#save("/entity", ".java")

#setPackageSuffix("entity")


import java.io.Serializable;

#tableComment("实体类")
public class Filedetail implements Serializable {
    private static final long serialVersionUID = -29476395970683568L;
    
    private Integer id;
    
    private String ani;
    
    private String dnis;
    
    private String calldirect;
    
    private String fileid;
    
    private String filename;
    
    private String agentfilename;
    
    private String customfilename;
    
    private String fileinfo;
    
    private String deviceid;
    
    private String agentid;
    
    private Date startdatetime;
    
    private Date enddatetime;
    
    private String callid;
    
    private String contactid;
    
    private Integer calllenth;
    
    private String recordtype;
    
    private String servername;
    
    private String fileencodingfmt;
    
    private String separablefileencodingfmt;

#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)
#getSetMethod($column)

}

