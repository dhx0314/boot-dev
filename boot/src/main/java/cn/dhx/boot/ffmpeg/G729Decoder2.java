package cn.dhx.boot.ffmpeg;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.ffmpeg.avcodec.AVCodec;
import org.bytedeco.ffmpeg.avcodec.AVCodecContext;
import org.bytedeco.ffmpeg.avcodec.AVPacket;
import org.bytedeco.ffmpeg.avutil.AVFrame;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

import static org.bytedeco.ffmpeg.global.avcodec.*;
import static org.bytedeco.ffmpeg.global.avutil.*;

@Slf4j
public class G729Decoder2 {
    static boolean bRegisterFilter = false;
    AVFrame frame;
    AVCodec codec;
    AVCodecContext codec_ctx;
    AVPacket pkt;
    ByteBuffer byteBuf = ByteBuffer.allocate(320);

    void init() {
        if (bRegisterFilter == false) {
            bRegisterFilter = true;
            //avcodec_register_all();
        }
        codec = avcodec_find_decoder(AV_CODEC_ID_G729);
        codec_ctx = avcodec_alloc_context3(codec);
        codec_ctx.sample_rate(8000);
        codec_ctx.channels(1);
        codec_ctx.sample_fmt(AV_SAMPLE_FMT_S16P);
        avcodec_open2(codec_ctx, codec, (PointerPointer) null);
        frame = av_frame_alloc();
//        pkt = av_packet_alloc();
        pkt = new AVPacket().retainReference();
        pkt.stream_index(-1);


    }

    void destroy() {
        avcodec_close(codec_ctx);
        av_free(codec_ctx);
        av_frame_free(frame);
    }

    byte[] decode(byte[] buf) {

        int data_size;
        int i, ch;
        byteBuf.clear();
        byteBuf.put(buf);
        pkt.data(new BytePointer(byteBuf));
        pkt.size(buf.length);


        int ret = avcodec_send_packet(codec_ctx, pkt);
        if (ret < 0) {
            //fprintf(stderr, "Error submitting the packet to the decoder\n");
            //exit(1);
            return null;
        }

        log.info("1 " + ret);
        /* read all the output frames (in general there may be any number of them */

        while (ret >= 0) {
            ret = avcodec_receive_frame(codec_ctx, frame);
            if (ret == AVERROR_EAGAIN() || ret == AVERROR_EOF()) {
//                readPacket = true;
                break;
            } else if (ret < 0) {
                // throw new Exception("avcodec_receive_frame() error " + ret + ": Error during audio decoding.");
//                readPacket = true;
                break;
            }

            AVFrame samples_frame = frame;
            int i1 = frame.nb_samples();
            System.out.println(i1);

            int sample_format = samples_frame.format();
            int planes = av_sample_fmt_is_planar(sample_format) != 0 ? (int) samples_frame.channels() : 1;
            System.out.println("planes " + planes);



            for (i = 0; i < planes; i++) {

                BytePointer data = frame.data(i);



                ByteBuffer buf2 = data.asByteBuffer();
                byte[] bytes = new byte[buf2.capacity()];
                buf2.get(bytes, 0, bytes.length);
                System.out.println(Arrays.toString(bytes));
                for (short aByte : bytes) {
                    System.out.println("aByte "+ aByte);
                }
            }


        }


        log.info(" 4     " + ret);

        return null;
    }


}
