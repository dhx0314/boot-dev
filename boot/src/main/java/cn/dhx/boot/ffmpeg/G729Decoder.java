package cn.dhx.boot.ffmpeg;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacpp.*;
import org.bytedeco.ffmpeg.avcodec.*;
import org.bytedeco.ffmpeg.avformat.*;
import org.bytedeco.ffmpeg.avutil.*;
import org.bytedeco.ffmpeg.swscale.*;

import static org.bytedeco.ffmpeg.global.avcodec.*;
import static org.bytedeco.ffmpeg.global.avformat.*;
import static org.bytedeco.ffmpeg.global.avutil.*;

@Slf4j
public class G729Decoder {
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

        avcodec_open2(codec_ctx, codec, (PointerPointer) null);
        frame = av_frame_alloc();
        pkt = av_packet_alloc();

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

            log.info("2      " + ret);
            if (ret == AVERROR_EOF)//ret == AVERROR(EAGAIN) ||
                break;
            else if (ret < 0) {
                //fprintf(stderr, "Error during decoding\n");
                //exit(1);

                log.info(" 3     " + ret);
                return null;
            }
            data_size = av_get_bytes_per_sample(codec_ctx.sample_fmt());
            log.info("data_size: " + data_size);
            if (data_size < 0) {
                /* This should not occur, checking just for paranoia */
                //fprintf(stderr, "Failed to calculate data size\n");
                return null;
            }
            System.out.println("1--------------");
            System.out.println(frame.nb_samples());
            AVFrame samples_frame = frame;

            int sample_format = samples_frame.format();
            int planes = av_sample_fmt_is_planar(sample_format) != 0 ? (int) samples_frame.channels() : 1;
            System.out.println("planes " + planes);
            int sample_size = data_size / av_get_bytes_per_sample(sample_format);
            System.out.println("--- " + sample_format);

//            for (i = 0; i < frame.nb_samples(); i++) {
//                System.out.println("f"+i);
            BytePointer data = frame.data(0);
            ByteBuffer byteBuffer = data.asBuffer();
            ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
            short[] bytes = new short[shortBuffer.capacity()];
            shortBuffer.get(bytes, 0, bytes.length);
            System.out.println(shortBuffer);
            System.out.println(bytes.length);
            for (short aByte : bytes) {
                System.out.println(aByte);
            }


//            av_get_bytes_per_sample(sample_format);
//            for (i = 0; i < frame.nb_samples(); i++) {
//                for (ch = 0; ch < codec_ctx.channels(); ch++) {
//
////                    int sample_format = samples_frame.format();
//
//                    BytePointer data1 = frame.data(i);
//                    System.out.println("--"+i);
//                    if (data1 == null) {
//                        continue;
//                    }
//                    ByteBuffer buf2 = data1.asByteBuffer();
//                    System.out.println(buf2.capacity());
//                    byte[] bytes = new byte[buf2.capacity()];
//                    buf2.get(bytes, 0, bytes.length);
////                    System.out.println(Arrays.toString(bytes));
//                }
//
//                //fwrite(frame.data[ch] + data_size*i, 1, data_size, outfile);
//            }
//            System.out.println("1--------------");
        }


        log.info(" 4     " + ret);

        return null;
    }


}
