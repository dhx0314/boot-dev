package cn.dhx.netty.boot.cache;

import cn.dhx.netty.boot.entity.AudioStream;
import cn.dhx.netty.boot.tcp.client.TcpClient;
import cn.dhx.netty.boot.util.NetByteUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class TcpChannelUtil {


    @Autowired
    private TcpClient tcpClient;

    public void OpenAudioStream() {
        AudioStream audioStream = new AudioStream();
        audioStream.setCmd("aa");
        audioStream.setCallid("38248268aw");
        audioStream.setCaller("1001");
        audioStream.setCallee("1002");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = objectMapper.writeValueAsString(audioStream);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        int length = jsonStr.length();
        log.info("length {}",length);
        byte[] length4 = NetByteUtil.intToBytes(length);
        byte[] jsonStrBytes = jsonStr.getBytes();
        byte[] bytes2 = ArrayUtils.addAll(length4, jsonStrBytes);
        send(bytes2);
    }

    public void CloseAudioStream() {

    }

    public void send(byte[] msg) {
        Channel channel = tcpClient.getChannel();
        ByteBuf buffer = Unpooled.buffer(msg.length);
        buffer.writeBytes(msg);
        if (!channel.isActive()) {
            tcpClient.doConnect();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        channel.writeAndFlush(buffer);
    }

}
