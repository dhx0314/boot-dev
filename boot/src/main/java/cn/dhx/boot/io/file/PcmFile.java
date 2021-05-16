package cn.dhx.boot.io.file;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class PcmFile extends AudioFile {

    public PcmFile(String sessionId) {
        super(sessionId, "pcm");
    }

    @Override
    public void writeData(byte[] data) {
        if (savedDays > 0 && createSuccess) {
            try {
                bos.write(data);
                dataLength += data.length;
            } catch (IOException e) {
                log.error("[{}] AudioFile [{}] writes data ERROR!", sessionId, filePath, e);
            }
        }

    }

    @Override
    public void saveFile() {
        if (savedDays > 0) {
            if (bos != null) {
                try {
                    bos.flush();
                    bos.close();
                } catch (IOException e) {
                    log.error("[{}] AudioFile [{}] closes BufferedOutputStream ERROR!", sessionId, filePath, e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    log.error("[{}] AudioFile [{}] closes FileOutputStream ERROR!", sessionId, filePath, e);
                }
            }
            if (dataLength > 0) {
                log.info("[{}] AudioFile [{}] is success saved.", sessionId, filePath);
            } else {
                log.warn("[{}] AudioFile [{}] is saved, but is empty!", sessionId, filePath);
            }
        }
    }
}
