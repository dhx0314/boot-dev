package cn.dhx.designpattern.structure.bridge;

/**
 * @version v1.0
 * @ClassName: Windows
 * @Description: 扩展抽象化角色(windows操作系统)
 * @Author: 黑马程序员
 */
public class Windows extends OpratingSystem {

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
