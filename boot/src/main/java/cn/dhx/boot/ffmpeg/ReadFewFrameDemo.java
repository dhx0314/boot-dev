package cn.dhx.boot.ffmpeg;

import org.bytedeco.ffmpeg.avcodec.AVCodec;
import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.avformat.*;
import org.bytedeco.ffmpeg.avutil.AVFrame;
import org.bytedeco.ffmpeg.swscale.SwsContext;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.NoException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.bytedeco.ffmpeg.global.avcodec.*;
import static org.bytedeco.ffmpeg.global.avformat.*;
import static org.bytedeco.ffmpeg.global.avutil.*;
import static org.bytedeco.ffmpeg.global.swscale.*;

public class ReadFewFrameDemo {


    public static void main(String[] args) throws Exception {


        //
/**
 *

        @NoException public static native AVIOContext avio_alloc_context(
        @Cast("unsigned char*") byte[] buffer,
        int buffer_size,
        int write_flag,
        Pointer opaque,
        Read_packet_Pointer_byte___int read_packet,
        Write_packet_Pointer_byte___int write_packet,
        Seek_Pointer_long_int seek);
 */

        byte[] buffer =new byte[1024];
//        avio_alloc_context(buffer,1024,1)

//        avcodec_find_decoder();

    }
}

