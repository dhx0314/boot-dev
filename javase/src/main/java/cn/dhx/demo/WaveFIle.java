package cn.dhx.demo;

import cn.dhx.util.ConverterUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaveFIle {




    public static char aLawDecompressTable[] =
            {
                    0xEA80, 0xEB80, 0xE880, 0xE980, 0xEE80, 0xEF80, 0xEC80, 0xED80,
                    0xE280, 0xE380, 0xE080, 0xE180, 0xE680, 0xE780, 0xE480, 0xE580,
                    0xF540, 0xF5C0, 0xF440, 0xF4C0, 0xF740, 0xF7C0, 0xF640, 0xF6C0,
                    0xF140, 0xF1C0, 0xF040, 0xF0C0, 0xF340, 0xF3C0, 0xF240, 0xF2C0,
                    0xAA00, 0xAE00, 0xA200, 0xA600, 0xBA00, 0xBE00, 0xB200, 0xB600,
                    0x8A00, 0x8E00, 0x8200, 0x8600, 0x9A00, 0x9E00, 0x9200, 0x9600,
                    0xD500, 0xD700, 0xD100, 0xD300, 0xDD00, 0xDF00, 0xD900, 0xDB00,
                    0xC500, 0xC700, 0xC100, 0xC300, 0xCD00, 0xCF00, 0xC900, 0xCB00,
                    0xFEA8, 0xFEB8, 0xFE88, 0xFE98, 0xFEE8, 0xFEF8, 0xFEC8, 0xFED8,
                    0xFE28, 0xFE38, 0xFE08, 0xFE18, 0xFE68, 0xFE78, 0xFE48, 0xFE58,
                    0xFFA8, 0xFFB8, 0xFF88, 0xFF98, 0xFFE8, 0xFFF8, 0xFFC8, 0xFFD8,
                    0xFF28, 0xFF38, 0xFF08, 0xFF18, 0xFF68, 0xFF78, 0xFF48, 0xFF58,
                    0xFAA0, 0xFAE0, 0xFA20, 0xFA60, 0xFBA0, 0xFBE0, 0xFB20, 0xFB60,
                    0xF8A0, 0xF8E0, 0xF820, 0xF860, 0xF9A0, 0xF9E0, 0xF920, 0xF960,
                    0xFD50, 0xFD70, 0xFD10, 0xFD30, 0xFDD0, 0xFDF0, 0xFD90, 0xFDB0,
                    0xFC50, 0xFC70, 0xFC10, 0xFC30, 0xFCD0, 0xFCF0, 0xFC90, 0xFCB0,
                    0x1580, 0x1480, 0x1780, 0x1680, 0x1180, 0x1080, 0x1380, 0x1280,
                    0x1D80, 0x1C80, 0x1F80, 0x1E80, 0x1980, 0x1880, 0x1B80, 0x1A80,
                    0x0AC0, 0x0A40, 0x0BC0, 0x0B40, 0x08C0, 0x0840, 0x09C0, 0x0940,
                    0x0EC0, 0x0E40, 0x0FC0, 0x0F40, 0x0CC0, 0x0C40, 0x0DC0, 0x0D40,
                    0x5600, 0x5200, 0x5E00, 0x5A00, 0x4600, 0x4200, 0x4E00, 0x4A00,
                    0x7600, 0x7200, 0x7E00, 0x7A00, 0x6600, 0x6200, 0x6E00, 0x6A00,
                    0x2B00, 0x2900, 0x2F00, 0x2D00, 0x2300, 0x2100, 0x2700, 0x2500,
                    0x3B00, 0x3900, 0x3F00, 0x3D00, 0x3300, 0x3100, 0x3700, 0x3500,
                    0x0158, 0x0148, 0x0178, 0x0168, 0x0118, 0x0108, 0x0138, 0x0128,
                    0x01D8, 0x01C8, 0x01F8, 0x01E8, 0x0198, 0x0188, 0x01B8, 0x01A8,
                    0x0058, 0x0048, 0x0078, 0x0068, 0x0018, 0x0008, 0x0038, 0x0028,
                    0x00D8, 0x00C8, 0x00F8, 0x00E8, 0x0098, 0x0088, 0x00B8, 0x00A8,
                    0x0560, 0x0520, 0x05E0, 0x05A0, 0x0460, 0x0420, 0x04E0, 0x04A0,
                    0x0760, 0x0720, 0x07E0, 0x07A0, 0x0660, 0x0620, 0x06E0, 0x06A0,
                    0x02B0, 0x0290, 0x02F0, 0x02D0, 0x0230, 0x0210, 0x0270, 0x0250,
                    0x03B0, 0x0390, 0x03F0, 0x03D0, 0x0330, 0x0310, 0x0370, 0x0350,
            };




    public final static byte[] headerOfPCMU = new byte[58];



    static {
//        initHeaderOfPCM();
        initHeaderOfPCMU();

    }

    private static void initHeaderOfPCMU() {
        try {
            /****** The "RIFF" chunk ******/
            // 0-3："RIFF"，每个字符占1个字节
            System.arraycopy("RIFF".getBytes("ASCII"), 0, headerOfPCMU, 0, 4); // 0-3
            // 4-7：总体文件的大小（不包括id和size本身，文件长度-8），4字节长整数
            System.arraycopy(reverseByteArray(ConverterUtil.longTo4Bytes(0)), 0, headerOfPCMU, 4, 4); // 4-7
            // 8-11："WAVE"，每个字符占1个字节
            System.arraycopy("WAVE".getBytes("ASCII"), 0, headerOfPCMU, 8, 4); // 8-11
            /****** The "fmt " sub-chunk ******/
            // 12-15："fmt "，注意最后一位的空格
            System.arraycopy("fmt ".getBytes("ASCII"), 0, headerOfPCMU, 12, 4); // 12-15
            // 16-19：fmt块的大小（不包括id和size本身），PCMU的值为18，且fmt子块最后必有2个字节长度的附加信息
            System.arraycopy(reverseByteArray(ConverterUtil.longTo4Bytes(18)), 0, headerOfPCMU, 16, 4); // 16-19
            // 20-21：格式种类（PCMU是7）
            System.arraycopy(reverseByteArray(ConverterUtil.intTo2Bytes(7)), 0, headerOfPCMU, 20, 2); // 20-21
            // 22-23：通道数，单声道为1，双声道(立体声)为2，这里统一设置为单声道
            System.arraycopy(reverseByteArray(ConverterUtil.intTo2Bytes(1)), 0, headerOfPCMU, 22, 2); // 22-23
            // 24-27：采样率（每秒采集到的样本数，表示每个通道的播放速度），PCMU固定为8000HZ
            System.arraycopy(reverseByteArray(ConverterUtil.longTo4Bytes(8000)), 0, headerOfPCMU, 24, 4); // 24-27
            // 28-31：每秒播放字节数 = 采样率 x 一个样本的比特数 x 通道数 / 8
            System.arraycopy(reverseByteArray(ConverterUtil.longTo4Bytes(8000 * 8 * 1 / 8)), 0, headerOfPCMU, 28, 4); // 28-31
            // 32-33：所有通道的一个样本所需的比特数 = 一个样本的比特数 x 通道数 / 8
            System.arraycopy(reverseByteArray(ConverterUtil.intTo2Bytes(8 * 1 / 8)), 0, headerOfPCMU, 32, 2); // 32-33
            // 34-35：一个样本的比特数，PCMU固定是8bits
            System.arraycopy(reverseByteArray(ConverterUtil.intTo2Bytes(8)), 0, headerOfPCMU, 34, 2); // 34-35
            // 36-37：需要增加的附加信息的大小，统一为0，即无附加信息
            System.arraycopy(reverseByteArray(ConverterUtil.intTo2Bytes(0)), 0, headerOfPCMU, 36, 2); // 36-37
            /****** The "fact" sub-chunk ******/
            // 38-41："fact"，每个字符占1个字节
            System.arraycopy("fact".getBytes("ASCII"), 0, headerOfPCMU, 38, 4); // 38-41
            // 42-45：fact块的大小（不包括上面的id和size本身）
            System.arraycopy(reverseByteArray(ConverterUtil.longTo4Bytes(4)), 0, headerOfPCMU, 42, 4); // 42-45
            // 46-49：音频数据转为PCM后的数据大小
            System.arraycopy(reverseByteArray(ConverterUtil.longTo4Bytes(0)), 0, headerOfPCMU, 46, 4); // 46-49
            /****** The "data" sub-chunk ******/
            // 50-53："data"，每个字符占1个字节
            System.arraycopy("data".getBytes("ASCII"), 0, headerOfPCMU, 50, 4); // 50-53
            // 54:57：数据块的长度（不包括id和size本身）
            System.arraycopy(reverseByteArray(ConverterUtil.longTo4Bytes(0)), 0, headerOfPCMU, 54, 4); // 54-57
        } catch (Exception e) {
            log.error("! init wave file header of PCMU ERROR!!!", e);
            log.error("---------- System EXIT! -------------");
            System.exit(1);
        }
    }

    private static byte[] reverseByteArray(byte[] bytes) {
        byte[] reversal = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++)
            reversal[bytes.length - 1 - i] = bytes[i];
        return reversal;
    }
}
