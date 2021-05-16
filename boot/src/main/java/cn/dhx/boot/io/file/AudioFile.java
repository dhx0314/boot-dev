package cn.dhx.boot.io.file;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

@Slf4j
@Getter
public abstract class AudioFile {
    protected static int savedDays = 2;
    protected String sessionId;
    protected String filePath;
    protected long dataLength;
    protected boolean createSuccess;
    protected FileOutputStream fos;
    protected BufferedOutputStream bos;

    protected AudioFile(String sessionId, String type) {
        if (savedDays > 0) {
            this.sessionId = sessionId;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = sdf.format(System.currentTimeMillis());
//            this.filePath = String.format("%s%s/%s.%s", GlobalConfig.AUDIO_FILE_SAVED_PATH,
//                    datePath, this.sessionId, type);

            this.filePath = "d:\\bos.txt";
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                this.fos = new FileOutputStream(filePath);
                this.bos = new BufferedOutputStream(fos);
                this.createSuccess = true;
                log.info("[{}] AudioFile [{}] is created.", this.sessionId, filePath);
            } catch (FileNotFoundException e) {
                log.error("[{}] AudioFile [{}] is not exist!", this.sessionId, filePath, e);
            }
        }
    }

    public abstract void writeData(byte[] data);

    public abstract void saveFile();

}
