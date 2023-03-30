package cn.dhx.demo.boot.cache;

import cn.dhx.demo.boot.entity.AudioStream;
import cn.dhx.demo.boot.tcp.client.TcpClient;
import cn.dhx.demo.boot.util.JsonUtil;
import cn.dhx.demo.boot.util.NetByteUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class TcpChannelUtil {

    @Autowired
    private TcpClient tcpClient;

    public void OpenAudioStream() {
        AudioStream audioStream = new AudioStream();
        audioStream.setCmd("OpenAudioStream");
        audioStream.setCallid("18270779730");
        audioStream.setCaller("1001");
        audioStream.setCallee("1002");
        String jsonStr = JsonUtil.toString(audioStream);
        int length = jsonStr.length();
        byte[] length4 = NetByteUtil.intToBytes(length);
        byte[] jsonStrBytes = jsonStr.getBytes();
        byte[] bytesAll = ArrayUtils.addAll(length4, jsonStrBytes);
        send(bytesAll);
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
