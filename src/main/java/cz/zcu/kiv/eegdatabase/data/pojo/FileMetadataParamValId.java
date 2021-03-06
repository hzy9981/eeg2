package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 19.1.2010 23:18:53 by Hibernate Tools 3.2.1.GA


import javax.persistence.Embeddable;

/**
 * FileMetadataParamValId generated by hbm2java
 */
@Embeddable
public class FileMetadataParamValId  implements java.io.Serializable {


     private int fileMetadataParamDefId;
     private int dataFileId;

    public FileMetadataParamValId() {
    }

    public FileMetadataParamValId(int fileMetadataParamDefId, int dataFileId) {
       this.fileMetadataParamDefId = fileMetadataParamDefId;
       this.dataFileId = dataFileId;
    }
   
    public int getFileMetadataParamDefId() {
        return this.fileMetadataParamDefId;
    }
    
    public void setFileMetadataParamDefId(int fileMetadataParamDefId) {
        this.fileMetadataParamDefId = fileMetadataParamDefId;
    }
    public int getDataFileId() {
        return this.dataFileId;
    }
    
    public void setDataFileId(int dataFileId) {
        this.dataFileId = dataFileId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FileMetadataParamValId) ) return false;
		 FileMetadataParamValId castOther = ( FileMetadataParamValId ) other; 
         
		 return (this.getFileMetadataParamDefId()==castOther.getFileMetadataParamDefId())
 && (this.getDataFileId()==castOther.getDataFileId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getFileMetadataParamDefId();
         result = 37 * result + this.getDataFileId();
         return result;
   }   


}


